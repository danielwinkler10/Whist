package game;

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
    private ArrayList<Player> players;

    public Game(ArrayList<Player> players, int firstGuesser) {
        this.firstGuesser = firstGuesser;
        this.players = new ArrayList<Player>(players);
        roundWinners = new int[GlobalShit.NUMBER_COUNT];
        predictions = new int[GlobalShit.SHAPE_COUNT];
    }

    private void generateDonald() {
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
                    highestGuess = currentGuess; //TODO implement getGuess and make sure it only allows higher guesses
                }
            }
        }


        initialHighestGuess = highestGuess.getAmount();
        donald = highestGuess.getShape();
    }

    public static int getDonald() {
        return donald;
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

}
