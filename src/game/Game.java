package game;

import card.Deck;
import card.Guess;
import player.Player;

import java.util.ArrayList;

import global.GlobalShit;

public class Game {
    private int firstGuesser;
    public static int donald;
    private int highestGuesser;
    private int initialHighestGuess; //may be a nicer way to think about this or enforce that they bet higher or equal to initial contract
    private int[] roundWinners;
    private int[] predictions;
    private int[] results;
    Deck deck;
    private ArrayList<Player> players;

    public Game(ArrayList<Player> players, int firstGuesser, Deck deck) {
        this.firstGuesser = firstGuesser;
        this.deck = deck;
        this.players = new ArrayList<Player>(players);
        roundWinners = new int[GlobalShit.NUMBER_COUNT];
        predictions = new int[GlobalShit.SHAPE_COUNT];
    }

    public void playGame() {
        //shuffle, deal
        //generateDonald
        //generatePredictions
        //Play 13 Rounds
        //Store the results
        //Figure out score changes
        deck.shuffle();
        deck.deal();
        generateDonald();
        generatePredictions();
        playRounds();

    }

    private void playRounds() {
        int guesser = firstGuesser;
        for (int i = 0; i < GlobalShit.NUMBER_COUNT; i++) {
            Round round = new Round(guesser);
            roundWinners[i] = round.playRound();
            guesser = roundWinners[i];
        }
    }

    private void generateDonald() {
        //TODO add Gulash logic
        int passCount = 0;
        Guess highestGuess = new Guess(-1, -1);
        boolean[] passLocations = new boolean[GlobalShit.SHAPE_COUNT];
        for (int i = 0; i < passLocations.length; i++) {
            passLocations[i] = false;
        }
        for (int i = firstGuesser; passCount < passLocations.length - 1; i++) {
            if (!passLocations[i % passLocations.length]) {
                Guess currentGuess = players.get(i % passLocations.length).getGuess(highestGuess);
                if (currentGuess.getAmount() == -1) {
                    passCount++;
                    passLocations[i % passLocations.length] = true;
                } else {
                    highestGuess = currentGuess;
                }
            }
        }


        initialHighestGuess = highestGuess.getAmount();
        donald = highestGuess.getShape();
    }

    public static int getDonald() {
        return donald;
    }

    private int[] generatePlayerResults() {
        int[] out = new int[4];
        for (int i = 0; i < roundWinners.length; i++) {
            out[roundWinners[i]]++;
        }
        return out;
    }

    private void updatePlayerScores() {
        for (int i = 0; i < players.size(); i++) {
            Player p = players.get(i);
            p.setScore(p.getScore() + calculateIndividualScore(i));
        }
    }


    private void generatePredictions() {
        for (int i = highestGuesser; i < i + GlobalShit.SHAPE_COUNT; i++) {
            int prediction;
            do {
                prediction = players.get(i % GlobalShit.SHAPE_COUNT).getPrediction();
            } while (!isPredictionValid(prediction, i - highestGuesser));
            predictions[i % GlobalShit.SHAPE_COUNT] = prediction;
        }
    }

    private boolean isPredictionValid(int prediction, int playerPositionInPredictionRound) {
        if (prediction > GlobalShit.NUMBER_COUNT || prediction < 0) return false;
        if (playerPositionInPredictionRound == 0) return prediction >= initialHighestGuess;
        if (playerPositionInPredictionRound == GlobalShit.SHAPE_COUNT - 1) {
            int firstThreeSum = 0;
            for (int i = 0; i < GlobalShit.SHAPE_COUNT; i++) {
                firstThreeSum += predictions[i];
            }
            return (prediction + firstThreeSum) == GlobalShit.NUMBER_COUNT;
        }
        return true;
    }

    private int calculateIndividualScore(int player) {
        int prediction = predictions[player];
        int actual = results[player];
        if (prediction == 0) {
            if (actual != prediction) {
                return (((actual - 1) * GlobalShit.zeroRedemptionFactor) - GlobalShit.zeroInitialPenalty);
            } else {
                if (isUp()) {
                    return GlobalShit.zeroUpScore;
                } else {
                    return GlobalShit.zeroDownScore;
                }
            }

        } else if (prediction == actual) {
            return prediction * prediction + GlobalShit.bonusOnTheSquare;
        } else {
            return (-GlobalShit.penaltyForEachOneOff) * (Math.abs(prediction - actual));
        }
    }

    private boolean isUp() {
        int sum = 0;
        for (int i = 0; i < GlobalShit.SHAPE_COUNT; i++) {
            sum += predictions[i];
        }
        return sum > GlobalShit.NUMBER_COUNT;
    }

}
