package card;

public class Guess {
    int amount;
    int shape;

    public Guess(int amount,int donald){
        this.amount=amount;
        this.shape =donald;
    }

    public int getAmount(){
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getShape() {
        return shape;
    }

    public void setShape(int shape) {
        this.shape = shape;
    }
}
