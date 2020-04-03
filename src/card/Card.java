package card;

public class Card {
    int num;
    int shape;

    public Card(int shape, int num){
        this.num=num;
        this.shape=shape;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getShape() {
        return shape;
    }

    public void setShape(int shape) {
        this.shape = shape;
    }
}
