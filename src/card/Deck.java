package card;

import global.GlobalShit;
import player.Player;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    ArrayList<Card> cards;
    ArrayList<Player> players;

    public Deck(ArrayList<Player> players) {
        cards = new ArrayList<>();
        this.players = players;
        for (int shape = 0; shape < GlobalShit.SHAPE_COUNT; shape++) {
            for (int num = GlobalShit.NUMBER_MIN; num < GlobalShit.NUMBER_MIN + GlobalShit.NUMBER_COUNT; num++) {
                cards.add(new Card(shape, num));
            }
        }
    }

    public void shuffle() {
        //Collections.shuffle(cards); //TODO unComment
    }

    public void deal() {
        shuffle();
        for (int i = 0; i < players.size(); i++) {
            Player p = players.get(i);
            ArrayList<Card> hand = new ArrayList<>();
            for (int j = GlobalShit.NUMBER_COUNT * i; j < GlobalShit.NUMBER_COUNT * (i + 1); j++) {
                hand.set(j%GlobalShit.NUMBER_COUNT, cards.get(j));
                p.setHand(hand);
            }
        }
    }
}