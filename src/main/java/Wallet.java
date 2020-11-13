public class Wallet {

    if playerCount = 2 {
        private int money = 20;

    }
    else if playerCount = 3 {
        private int money = 18;

    }

    else playerCount = 4 {
        private int money = 16;

    }

    public Wallet(){

    }
    public void setPoint(int money) {

        // Placeholder - Should "minus money" be possible?
        this.money += money;
        if(money < 0) {
            money = 0;
        }
    }
    public int getMoney() {
        return money;
    }

}
