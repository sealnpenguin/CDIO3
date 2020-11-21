package Player;

public class Player{
    //Attributes
    private String name;
    private Boolean inJail;
    private boolean JailCard;
    private Boolean[] myProperties = new Boolean[11]; //Players properties (Max properties is 12)
    private int Position, oldposition;
    private Wallet wallet = new Wallet();


    public Player(String Name)
    {
        name = Name;
        inJail = false;
        JailCard = false;
        Position = 0;
        oldposition = 0;
    }


    public int getPosition()
    {
        return Position;
    }

    public void setPosition(int Position)
    {
        this.oldposition = this.Position;
        this.Position += Position;
        if(this.Position >= 24) this.Position -= 24;
    }
    public int getOldposition()
    {
        return oldposition;
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
