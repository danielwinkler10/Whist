package card;

public class Guess {
    int amount;
    int donald;

    public Guess(int amount,int donald){
        this.amount=amount;
        this.donald=donald;
    }

    public int getAmount(){
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getDonald() {
        return donald;
    }

    public void setDonald(int donald) {
        this.donald = donald;
    }
}
