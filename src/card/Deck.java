package card;

import global.Global;
import player.Player;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    ArrayList<Card> cards;
    ArrayList<Player> players;

    public Deck(ArrayList<Player> players) {
        cards = new ArrayList<>();
        this.players = players;
        for (int shape = 0; shape < Global.SHAPE_COUNT; shape++) {
            for (int num = Global.NUMBER_MIN; num < Global.NUMBER_MIN + Global.NUMBER_COUNT; num++) {
                cards.add(new Card(shape, num));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public void deal() {
        shuffle();
        for (int i = 0; i < players.size(); i++) {
            Player p = players.get(i);
            Card[] hand = new Card[Global.NUMBER_COUNT];
            for (int j = Global.NUMBER_COUNT * i; j < Global.NUMBER_COUNT * (i + 1); j++) {
                hand[j - (Global.NUMBER_COUNT * i)] = cards.get(j);
            }
            p.setHand(hand);
        }
    }
}
