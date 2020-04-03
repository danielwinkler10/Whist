package driver;

import global.Global;
import player.Player;

import java.util.ArrayList;

public class Main {
  static  ArrayList<Player> players= new ArrayList<>();

    public static void main(String[] args) {
      createPlayers(Global.SHAPE_COUNT);
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
