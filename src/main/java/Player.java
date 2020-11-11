import java.util.ArrayList;

public class Player{
    private String name;
    private Boolean inJail;
    private Boolean JailCard;
    private Boolean[] myProperties = new Boolean[12]; //spilleren ejendomme
    private int Position;
    private int  playernumber;


    public Player(String Name, int number)
    {
        name = Name;
        inJail = false;
        JailCard = false;
        Position = 0;
        playernumber = number;
    }

    public int getplayernumber()
    {
        return playernumber;
    }

    public int getPosition()
    {
        return Position;
    }

    public void setPosition(int properties)
    {
        this.Position = Position;
    }

    public void setMyProperties(int k)
    {
        myProperties[k] = true;
    }

    public void setJailCard(boolean k) {
        if (!k)
            JailCard = false;
        else JailCard = true;
    }

    //Return array with players properties
    public boolean[] getmyProperties(){
        return myProperties;
    }

    Wallet wallet = new Waller();
}
