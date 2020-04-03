package player;

import card.Card;

import java.util.ArrayList;

public class Hand {
    ArrayList<Card> cards;


    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public boolean isInHand(Card cardToCheck){
        for(int i =0; i< cards.size(); i++){
            if(cards.get(i).getNum() == cardToCheck.getNum() && cards.get(i).getShape() == cardToCheck.getShape()){
                return true;
            }
        }
        return false;
    }
    public boolean hasShape(int shape){
        for(int i =0; i< cards.size(); i++){
            if(cards.get(i).getShape() == shape){
                return true;
            }
        }
        return false;
    }

}
