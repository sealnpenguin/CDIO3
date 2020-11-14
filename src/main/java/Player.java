import java.util.ArrayList;

public class Player{
    //Attributes
    private String name;
    private Boolean inJail;
    private int JailCard;
    private Boolean[] myProperties = new Boolean[11]; //Players properties (Max properties is 12)
    private int Position;

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
        this.Position = Position;
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

    //Wallet wallet = new Waller();
}
