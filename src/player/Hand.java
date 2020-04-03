package player;

import card.Card;
import global.GlobalShit;

public class Hand {
    Card[] cards = new Card[GlobalShit.NUMBER_COUNT];

    public void setHand(Card[] cardsArray){
        cards = cardsArray;
    }

    public boolean isInHand(Card cardToCheck){
        for(int i =0; i< cards.length; i++){
            if(cards[i].getNum() == cardToCheck.getNum() && cards[i].getShape() == cardToCheck.getShape()){
                return true;
            }
        }
        return false;
    }
    public boolean hasShape(int shape){
        for(int i =0; i< cards.length; i++){
            if(cards[i].getShape() == shape){
                return true;
            }
        }
        return false;
    }

}
