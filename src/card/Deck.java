package card;
import java.util.ArrayList;
import java.util.Collections;
import global.GlobalShit;

public class Deck {
    ArrayList cards;
    public Deck(){
        cards= new ArrayList<Card>();
        for (int shape = 0; shape < 4 ; shape++) {
            for (int num = 2; num < 15 ; num++) {
                cards.add(new Card(shape, num));
            }
        }
    }
    public void shuffle(){
        Collections.shuffle(cards);
    }
    public void deal(){

    }
}
