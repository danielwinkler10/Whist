package player;

import card.Card;
import card.Guess;
import global.GlobalShit;

import java.util.Scanner;

public class Player {
    private String name;
    private int score;
    private Hand hand;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public Player(String name) {
        this.name = name;
        hand = new Hand();
    }

    Scanner in = new Scanner(System.in);


    //Setters
    public void setHand(Card[] cards) {
        hand.setCards(cards);
    }

    //Getters
    public Card getCard(int neededShape) {
        System.out.println("Pick a card from your hand");
        int shape, num;
        System.out.println("Enter number 2-14");
        num = in.nextInt();
        validateNumber(num);

        System.out.println("Enter the shape, 0-3");
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
        System.out.println(name + " Pick a prediction based on Trump (0 - 13)");
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
                while (num != neededShape)
                    System.out.println("Please pick the correct shape");
                    num = in.nextInt();
                }
            }
        }


    public Guess getGuess(Guess highestGuess) {
        int num, shape;
        System.out.println(name + " Pick a number 5 or above to guess. Pick 0 to pass");
        num = in.nextInt();
        if (num < GlobalShit.GUESS_MIN || num < highestGuess.getAmount() || num > GlobalShit.NUMBER_COUNT){
            System.out.println("Guess not high enough, automatically passing");
            return new Guess (-1, -1);
        }
        System.out.println("Enter the trump to base your guess on, 0-4");
        System.out.println("0 - Diamonds, 1 - Clubs, 2 - Hearts, 3 - Spades, 4 - Non-Trump");
        System.out.println("Non-Trump is only available if you guessed 7 or above");
        shape = in.nextInt();
        if (shape == 4 && num < GlobalShit.NON_TRUMP_GUESS_MIN){
            System.out.println("Can't guess Non-Trump with less than 7, automatically passing");
            return new Guess (-1, -1);
        }
        if (num == highestGuess.getAmount()){
            if (shape > highestGuess.getShape()){
                return new Guess(num, shape);
            } else {
                System.out.println("your shape is weaker than the current guess leader's shape, automatically passing");
                return new Guess (-1, -1);
            }
        } else {
            return new Guess(num, shape);
        }
    }
}
