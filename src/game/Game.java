package game;

import card.Guess;
import player.Player;
import java.util.ArrayList;
import global.GlobalShit;

public class Game {
    private int firstGuesser;
    public int donald;
    private int highestGuesser;
    private int initialHighestGuess; //may be a nicer way to think about this or enforce that they bet higher or equal to initial contract
    private int[] roundWinners;
    private int[] predictions;
    private int[] results;
    private ArrayList<Player> players;
    public Game(ArrayList<Player> players, int firstGuesser){
        this.firstGuesser = firstGuesser;
        this.players = new ArrayList<Player>(players);
        roundWinners = new int[GlobalShit.NUMBER_COUNT];
        predictions = new int[GlobalShit.SHAPE_COUNT];
    }
    private int generateDonald() {
        int passCount = 0;
        Guess highestGuess;




        initialHighestGuess = highestGuess.getAmount();
        return 0; //TODO implement logic for going through players and getting highest guess
    }
    private void generatePredictions(){
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
        if (playerPositionInPredictionRound == GlobalShit.SHAPE_COUNT - 1){
            int firstThreeSum = 0;
            for (int i = 0; i < GlobalShit.SHAPE_COUNT; i++) {
                firstThreeSum +=predictions[i];
            }
            return (prediction + firstThreeSum) == GlobalShit.NUMBER_COUNT;
        }
    }

}
