package player;

import card.Card;

public class Hand {
    Card[] cards = new Card[13];

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
}
