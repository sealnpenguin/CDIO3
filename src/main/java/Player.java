public class Player{
    //Attributes
    private String name;
    private Boolean inJail;
    private int JailCard;
    private Boolean[] myProperties = new Boolean[11]; //Players properties (Max properties is 12)
    private int Position;
    private Wallet wallet = new Wallet();

    public Player(String Name)
    {
        name = Name;
        inJail = false;
        JailCard = 0;
        Position = 0;
    }


    public int getPosition()
    {
        return Position;
    }

    public void setPosition(int Position)
    {
        this.Position += Position;
        if(this.Position >= 24) this.Position -= 24;
    }
    public String getName()
    {
        return name;
    }

    public void setMyProperties(int k, boolean tf)
    {
        if (tf)
        myProperties[k] = true;
        else
            myProperties[k] = false;
    }

    //adds or remove jailcard(s) to a player
    public int setJailCard(int jailCard) {
        return this.JailCard += jailCard;
    }
    public int getJailCard()
    {
        return this.JailCard;
    }

    //Return array with players properties
    public Boolean[] getmyProperties(){
        return myProperties;
    }

    public int getMoney(){
        return wallet.getMoney();
    }

    public void setMoney(int money){
        wallet.setMoney(money);
    }

}