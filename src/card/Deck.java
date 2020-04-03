package card;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    ArrayList<Card> cards;
    public Deck(){
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

    }

    public ArrayList getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
}
