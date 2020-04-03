package driver;


import global.GlobalShit;
import card.Deck;
import player.Player;

import java.util.ArrayList;

public class Main {
  static  ArrayList<Player> players= new ArrayList<>();
    static Deck deck = new Deck(players);

    public static void main(String[] args) {
      createPlayers(GlobalShit.SHAPE_COUNT);
    }

    public static ArrayList<Player> getPlayers() {
        return players;
    }

    public static ArrayList<Player> createPlayers(int numPlayers){
        ArrayList<Player> players= new ArrayList<>();

        for (int i = 0; i <numPlayers ; i++) {
         Player p= new Player("Player"+i);
            players.add(p);
        }
        return players;
    }
}
