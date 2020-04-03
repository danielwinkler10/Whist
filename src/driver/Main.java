package driver;

import global.GlobalShit;
import player.Player;

import java.util.ArrayList;

public class Main {
  static  ArrayList<Player> players= new ArrayList<>();

    public static void main(String[] args) {
      createPlayers(GlobalShit.SHAPE_COUNT);
    }

    public static ArrayList<Player> getPlayers() {
        return players;
    }

    public static ArrayList<Player> createPlayers(int numPlayers){
        ArrayList<Player> players= new ArrayList<>();
       int counter=0;
        for (int i = 0; i <numPlayers ; i++) {
         Player p= new Player("Player"+counter);
            players.add(p);
            counter++;
        }
        return players;
    }
}
