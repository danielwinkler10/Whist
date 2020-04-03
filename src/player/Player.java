package player;

import card.Card;

import java.util.Scanner;

public class Player {
    private String name;
    private int score;
    private Hand hand;

    public void setHand(Card[] card){
        hand.setHand(card);
    }

    Card getCard(){
        System.out.println("Pick a card from your hand");

        int shape, num;
        Scanner in = new Scanner(System.in);

        System.out.println("Enter number 2-14");
        num = in.nextInt();
        while (!(num >=2 && num <=14)){
            System.out.println("Not a valid number, Enter number 2-14");
            num = in.nextInt();
        }

        System.out.println("Enter the shape, 0-4");
        System.out.println("0 - Diamond, 1 - Clubs, 2 - Hearts, 3 - Spades");
        shape = in.nextInt();
        while (!(shape >=0 && shape <=3)){
            System.out.println("Not a valid number, Enter number 2-14");
            num = in.nextInt();
        }

        Card newCard = new Card(shape,num);
        // if() card is valid, calling a method in Hand.
        return newCard;
    }
}
