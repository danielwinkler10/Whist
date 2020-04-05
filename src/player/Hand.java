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

    // Method to check if a chosen card is in player's hand
    public boolean isInHand(Card cardToCheck) {
        //Loops through all of the player's cards
        for (int i = 0; i < cards.size(); i++) {
            // Checks if both shape & number are found in a card in the player's hand
            if (cards.get(i).getNum() == cardToCheck.getNum() && cards.get(i).getShape() == cardToCheck.getShape()) {
                return true;
            }
        }
        return false;
    }

    // Method to check if player has the required shape
    public boolean hasShape(int shape) {
        //Loops through all of the player's cards
        for (int i = 0; i < cards.size(); i++) {
            // Checks if player has shape in hand
            if (cards.get(i).getShape() == shape) {
                return true;
            }
        }
        return false;
    }

    // Method to sort the player's hand
    public void sortHand() {
        // An ArrayList to put the cards in order
        ArrayList<Card> organizedCards = new ArrayList<>();
        // Loop through the numbers
        for (int i = 0; i < GlobalShit.NUMBER_COUNT; i++) {
            int currentMinIndex = 0;
            // Loop through the cards in hand
            for (int j = 1; j < cards.size(); j++) {
                // Puts the cards in order based on number and shape
                if (cards.get(currentMinIndex).getShape() > cards.get(j).getShape()){
                    currentMinIndex = j;
                } else if (cards.get(currentMinIndex).getShape() == cards.get(j).getShape() && cards.get(currentMinIndex).getNum() > cards.get(j).getNum()){
                    currentMinIndex = j;
                }
            }
            // Add card to the ArrayList in order
            organizedCards.add(cards.remove(currentMinIndex));
        }
        // Old cards array = Organized ArrayList
        cards = organizedCards;
    }


}
