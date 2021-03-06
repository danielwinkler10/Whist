package player;

import card.Card;
import card.Guess;
import global.GlobalShit;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    // Variables
    Scanner in = new Scanner(System.in);

    // Constructor
    public Player(String name) {
        this.name = name;
        hand = new Hand();
    }

    // Variables
    private String name;
    private int score;
    private Hand hand;

    //Getters
    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hand getHand() {
        return hand;
    }


    public int getPrediction() {
        int prediction;
        System.out.println(name + " Pick a prediction based on Trump (0 - 13)");
        prediction = in.nextInt();
        return prediction;
    }

    public Guess getGuess(Guess highestGuess) {
        int num, shape;
        displayHand();
        System.out.println(name + " Pick a number 5 or above to guess. Pick 0 to pass");
        num = in.nextInt();
        if (num < GlobalShit.GUESS_MIN || num < highestGuess.getAmount() || num > GlobalShit.NUMBER_COUNT) {
            System.out.println("Guess not high enough, automatically passing");
            return GlobalShit.PASS;
        }
        do {
            System.out.println("Enter the trump to base your guess on, 0-4");
            System.out.println("0 - Diamonds, 1 - Clubs, 2 - Hearts, 3 - Spades, 4 - Non-Trump");
            System.out.println("Non-Trump is only available if you guessed 7 or above");
            shape = in.nextInt();
        } while (shape > GlobalShit.SHAPE_COUNT || shape < 0);
        if (shape == GlobalShit.SHAPE_COUNT && num < GlobalShit.NON_TRUMP_GUESS_MIN) {
            System.out.println("Can't guess Non-Trump with less than 7, automatically passing");
            return GlobalShit.PASS;
        }
        if (num == highestGuess.getAmount()) {
            if (shape > highestGuess.getShape()) {
                return new Guess(num, shape);
            } else {
                System.out.println("your shape is weaker than the current guess leader's shape, automatically passing");
                return new Guess(-1, -1);
            }
        } else {
            return new Guess(num, shape);
        }
    }

    public Card getCard(int neededShape) {
        System.out.println("Pick a card from your hand");
        System.out.println("Needed shape is " + GlobalShit.getShapeName(neededShape));
        displayHand();
        int shape, num;
        System.out.println("Enter the shape, 0-3");
        System.out.println("0 - Diamond, 1 - Clubs, 2 - Hearts, 3 - Spades");
        shape = in.nextInt();
        shape = validateShape(shape, neededShape);
        System.out.println("Enter number 2-14");
        num = validateNumber(in.nextInt(), shape);
        return hand.getCards().remove(findIndexOfCardInHand(new Card(shape, num)));
    }

    // Setters
    public void setScore(int score) {
        this.score = score;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public void setHand(ArrayList<Card> cards) {
        hand.setCards(cards);
    }

    // Validation methods
    private int validateNumber(int num, int shape) {
        while (!hand.isInHand(new Card(shape, num))) {
            System.out.println("Not a valid number, Enter number 2-14");
            num = in.nextInt();
        }
        return num;
    }

    private int validateShape(int shape, int neededShape) {
        if (hand.hasShape(neededShape)) {
            if (shape != neededShape)
                System.out.println("You have to select a card of the required shape. Selecting the required shape, " + GlobalShit.getShapeName(neededShape) + ", automatically");
            return neededShape;
        } else {
            while ((shape < 0 || shape >= GlobalShit.SHAPE_COUNT || !hand.hasShape(shape))) {
                System.out.println("Not a valid number, Enter number 0-3");
                shape = in.nextInt();
            }
            return shape;
        }
    }

    //Helper methods
    public void displayHand() {
        System.out.println(name + " these are your cards:");
        for (int i = 0; i < hand.getCards().size(); i++) {
            Card c = hand.getCards().get(i);
            if (i == hand.getCards().size() - 1) {
                System.out.print(c.getNum() + " " + GlobalShit.getShapeName(c.getShape()));
            } else {
                System.out.print(c.getNum() + " " + GlobalShit.getShapeName(c.getShape()) + ", ");
            }
        }
        System.out.println();
    }

    private int findIndexOfCardInHand(Card card) {
        for (int i = 0; i < hand.getCards().size(); i++) {
            Card currentCard = hand.getCards().get(i);
            if (card.getShape() == currentCard.getShape() && card.getNum() == currentCard.getNum()) return i;
        }
        return -1;
    }
}
