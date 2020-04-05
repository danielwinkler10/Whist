package player;

import card.Card;
import global.GlobalShit;
import java.util.ArrayList;


public class Hand {

    ArrayList<Card> cards;

    // Getters
    public ArrayList<Card> getCards() {
        return cards;
    }

    // Setters
    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    // Method to check if a chosen card is in player's hand.
    public boolean isInHand(Card cardToCheck) {
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getNum() == cardToCheck.getNum() && cards.get(i).getShape() == cardToCheck.getShape()) {
                return true;
            }
        }
        return false;
    }

    // Method to check if player has the required shape.
    public boolean hasShape(int shape) {
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getShape() == shape) {
                return true;
            }
        }
        return false;
    }

    // Method to sort the player's hand.
    public void sortHand() {
        ArrayList<Card> organizedCards = new ArrayList<>();
        for (int i = 0; i < GlobalShit.NUMBER_COUNT; i++) {
            int currentMinIndex = 0;
            for (int j = 1; j < cards.size(); j++) {
                if (cards.get(currentMinIndex).getShape() > cards.get(j).getShape()) currentMinIndex = j;
                else if (cards.get(currentMinIndex).getShape() == cards.get(j).getShape() && cards.get(currentMinIndex).getNum() > cards.get(j).getNum())  currentMinIndex = j;
            }
            organizedCards.add(cards.remove(currentMinIndex));
        }
        cards = organizedCards;
    }


}
