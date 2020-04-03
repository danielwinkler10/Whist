package driver;

import card.Deck;
import game.Game;
import global.GlobalShit;
import player.Player;

import java.util.ArrayList;

public class Main {
  static  ArrayList<Player> players = new ArrayList<>();

    public static void main(String[] args) {
      createPlayers(GlobalShit.SHAPE_COUNT);

      Deck deck = new Deck(players);

      for (int i =0; i < players.size(); i++){
          Game game = new Game(players, i, deck);
      }


    }

    public static ArrayList<Player> getPlayers() {
        return players;
    }

    public static ArrayList<Player> createPlayers(int numPlayers){
        ArrayList<Player> players= new ArrayList<>();
        for (int i = 0; i <numPlayers ; i++) {
         Player p = new Player("Player"+i);
            players.add(p);
        }

        return players;
    }
}
