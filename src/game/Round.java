package game;

import card.Card;
import driver.Main;
import player.Player;

import java.util.ArrayList;

public class Round {
    private int miniDonald;
    ArrayList<Card> onTable= new ArrayList();
    ArrayList<Player> players= Main.getPlayers();
    Player starter;

    public Round(Player starter){
        this.starter=starter;
    }

    public int getMiniDonald() {
        return miniDonald;
    }

    public void setMiniDonald(int miniDonald) {
        this.miniDonald = miniDonald;
    }

    public ArrayList<Card> getOnTable() {
        return onTable;
    }

    public void setOnTable(ArrayList<Card> onTable) {
        this.onTable = onTable;
    }
    public int playRound(){
        for (int i = 0; i < players.size(); i++) {
players.get(i).getCard();
        }
    }

}
