package player;

import card.Card;
import card.Guess;
import global.GlobalShit;

import java.util.Scanner;

public class Player {
    private String name;
    private int score;
    private Hand hand;

    public Player(String name) {
        this.name = name;
    }

    Scanner in = new Scanner(System.in);


    //Setters
    public void setHand(Card[] card) {
        hand.setHand(card);
    }

    //Getters
    public Card getCard(int neededShape) {
        System.out.println("Pick a card from your hand");
        int shape, num;
        System.out.println("Enter number 2-14");
        num = in.nextInt();
        validateNumber(num);

        System.out.println("Enter the shape, 0-4");
        System.out.println("0 - Diamond, 1 - Clubs, 2 - Hearts, 3 - Spades");
        shape = in.nextInt();
        validateShape(shape, neededShape);

        Card newCard = new Card(shape, num);

        if (hand.isInHand(newCard)) {
            return newCard;
        } else {
            //Not sure this will work, if the card is not in the hand I'm just calling this function again
            //Big brains
            System.out.println("Not in your hand");
            return getCard(neededShape);
        }
    }

    public int getPrediction() {
        int prediction;
        System.out.println("Pick a prediction based on Trump (2 - 14)");
        prediction = in.nextInt();
        return prediction;
    }


    //Helper Methonds

    private void validateNumber(int num) {
        while (!(num >= GlobalShit.NUMBER_MIN && num <= GlobalShit.NUMBER_COUNT)) {
            System.out.println("Not a valid number, Enter number 2-14");
            num = in.nextInt();
        }
    }


    private void validateShape(int num, int neededShape) {
        while (!(num >= 0 && num <= GlobalShit.SHAPE_COUNT)) {
            System.out.println("Not a valid number, Enter number 0-3");
            num = in.nextInt();
        }
        if (neededShape != -1) {
            if (this.hand.hasShape(neededShape)) {
                while (num != neededShape) {
                    System.out.println("Please pick the correct shape");
                    num = in.nextInt();
                }
            }
        }
    }

    public Guess getGuess(Guess highestGuess) {
        return new Guess (-1, -1);
    }
}
