package player;

import card.Card;
import global.GlobalShit;

import java.util.ArrayList;

public class Hand {
    ArrayList<Card> cards;


    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public boolean isInHand(Card cardToCheck) {
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getNum() == cardToCheck.getNum() && cards.get(i).getShape() == cardToCheck.getShape()) {
                return true;
            }
        }
        return false;
    }

    public boolean hasShape(int shape) {
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getShape() == shape) {
                return true;
            }
        }
        return false;
    }

    public void sortHand() {
        ArrayList<Card> organizedCards = new ArrayList<>();
        for (int i = 0; i < GlobalShit.NUMBER_COUNT; i++) {
            int currentMinIndex = 0;
            for (int j = 1; j < cards.size(); j++) {
                if (cards.get(currentMinIndex).getShape() > cards.get(j).getShape()) currentMinIndex = j;
                else if (cards.get(currentMinIndex).getShape() == cards.get(j).getShape() && cards.get(currentMinIndex).getNum() > cards.get(j).getNum())  currentMinIndex = j;
            }
            System.out.println(cards.size());
            organizedCards.add(cards.remove(currentMinIndex));
        }
        cards = organizedCards;
    }


}
