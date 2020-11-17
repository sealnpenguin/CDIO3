public class Wallet {
    private int money;
    public Wallet(){

    }
    public void setMoney(int money) {

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
