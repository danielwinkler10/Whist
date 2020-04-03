package game;

import card.Guess;
import player.Player;
import java.util.ArrayList;

public class Game {
    final int DIAMOND = 0;
    final int CLUB = 1;
    final int HEART = 2;
    final int SPADE = 3;
    int firstGuess;
    int donald;
    int highestGuesser;
    int[] roundWinners;
    int[] predictions;
    int[] results;
    ArrayList<Player> players;
    public Game(ArrayList<Player> players, int firstGuess){
        this.firstGuess = firstGuess;
        this.players = new ArrayList<Player>(players);
    }
    private int generateDonald() {
        int passCount = 0;
        Guess highestGuess;
        return 0; //TODO implement logic for going through players and getting highest guess
    }


}
