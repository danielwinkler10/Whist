package global;

import card.Guess;

public class GlobalShit {
    //IF WE DO DECIDE TO CHANGE ANY OF THESE WE HAVE TO CHANGE ALL THE TEXT MESSAGES UNFORTUNATELY
    public static final int SHAPE_COUNT = 4;
    public static final int NUMBER_COUNT = 13;
    public static final int NUMBER_MIN = 2;
    public static final int GUESS_MIN = 5;
    public static final int NON_TRUMP_GUESS_MIN = 7;
    public static final int zeroUpScore = 25;
    public static final int zeroDownScore = 50;
    public static final int zeroInitialPenalty = 50;
    public static final int zeroRedemptionFactor = 10;
    public static final int penaltyForEachOneOff = 10;
    public static final int bonusOnTheSquare = 10;
    public static final Guess PASS = new Guess(GUESS_MIN, -1);
    public static final int DIAMOND = 0;
    public static final int CLUB = 1;
    public static final int HEART = 2;
    public static final int SPADE = 3;

    public static String getShapeName(int num){
        switch (num){
            case 0:
                return "Diamond";
            case 1:
                return "Club";
            case 2:
                return "Heart";
            case 3:
                return "Spade";
            default:
                return "No needed shape";
        }
    }



    //IF WE DO DECIDE TO CHANGE ANY OF THESE WE HAVE TO CHANGE ALL THE TEXT MESSAGES UNFORTUNATELY

}
