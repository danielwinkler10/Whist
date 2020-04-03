package card;
import player.Hand;
import player.Player;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    ArrayList<Card> cards;
    ArrayList<Player> players;
    public Deck(ArrayList<Player> players){
        this.players=players;
        cards= new ArrayList<>();
        for (int shape = 0; shape <4 ; shape++) {
            for (int num = 2; num <15 ; num++) {
                cards.add(new Card(shape,num));
            }
        }
    }
    public void shuffle(){
        Collections.shuffle(cards);
    }
    public void deal(){
        shuffle();
        for (int i=0; i<players.size(); i++) {
            Player p= players.get(i);
            Card[] hand= new Card[13];
            for (int j = 13*i; j <13*(i+1) ; j++) {
               hand[j-(13*i)]=cards.get(j);
            }
            p.setHand(hand);
        }

    }

    public ArrayList getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
}
