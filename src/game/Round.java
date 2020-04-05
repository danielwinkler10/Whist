package game;

import card.Card;
import driver.Main;
import global.GlobalShit;
import player.Player;
import game.Game;

import java.util.ArrayList;

public class Round {
    private int miniDonald;
    ArrayList<Card> onTable = new ArrayList<>();
    ArrayList<Player> players = Main.getPlayers();
    int starter;

    // Constructor
    public Round(int starter) {
        this.starter = starter;
    }

    // Getter
    public int getMiniDonald() {
        return miniDonald;
    }

    // Getter
    public ArrayList<Card> getOnTable() {
        return onTable;
    }

    // Setter
    public void setMiniDonald(int miniDonald) {
        this.miniDonald = miniDonald;
    }

    // Setter
    public void setOnTable(ArrayList<Card> onTable) {
        this.onTable = onTable;
    }

    // Starts by getting the first card and setting this round's dominant shape. Then, loops over the other players getting their cards and assigning them a value based on their shape and number. Then, sees which player played the card with the highest value and sets them as the round winner
    public int playRound() {
        Card firstCard = players.get(starter).getCard(-1);
        onTable.add(firstCard);
        miniDonald = firstCard.getShape();


        for (int i = starter + 1; i < (players.size() + starter); i++) {
            Card c = players.get(i % players.size()).getCard(miniDonald);
            if (c.getShape() == Game.getDonald()) {
                c.setNum(c.getNum() + GlobalShit.NUMBER_COUNT);
            } else if (c.getShape() != miniDonald) {
                c.setNum(0);
            } //TODO MAY BE PROBLEMATIC FOR GRAPHICS, CONSIDER NOT CHANGING CARD VALUE
            onTable.add(c);
        }

        System.out.println("Round winner is " + players.get((maxIndex(onTable) + starter) % GlobalShit.SHAPE_COUNT).getName());
        return ((maxIndex(onTable) + starter) % GlobalShit.SHAPE_COUNT);
    }

    // Finds the index in an arrayList where the int with the highest value is located
    public int maxIndex(ArrayList<Card> cards) {
        int max = -1;
        int maxIndex = -1;
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getNum() > max) {
                max = cards.get(i).getNum();
                maxIndex = i;
            }
        }
        return maxIndex;
    }

}