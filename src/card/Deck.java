package card;

import global.GlobalShit;
import player.Player;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    ArrayList<Card> cards;
    ArrayList<Player> players;
    // Creates a new deck that includes 13 cards of each shape= 52 cards
    public Deck(ArrayList<Player> players) {
        cards = new ArrayList<>();
        this.players = players;
        for (int shape = 0; shape < GlobalShit.SHAPE_COUNT; shape++) {
            for (int num = GlobalShit.NUMBER_MIN; num < GlobalShit.NUMBER_MIN + GlobalShit.NUMBER_COUNT; num++) {
                cards.add(new Card(shape, num));
            }
        }
    }
// Shuffle the deck using the built-in method
    public void shuffle() {
        Collections.shuffle(cards);
    }
// Shuffle the deck then assign cards to each player
    public void deal() {
        shuffle();
        for (int i = 0; i < players.size(); i++) {
            Player p = players.get(i);
            ArrayList<Card> hand = new ArrayList<>();
            for (int j = GlobalShit.NUMBER_COUNT * i; j < GlobalShit.NUMBER_COUNT * (i + 1); j++) {
                hand.add(cards.get(j));
                p.setHand(hand);
            }
            p.getHand().sortHand();
        }
    }
}