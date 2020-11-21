package Cards;
import Player.*;
import Fields.*;

public class PlayerSpecific extends Cards
{
    public PlayerSpecific(String text, int index)
    {
        super(text,index);
    }

    @Override
    public void drawCard(Player[] players, int player, Field[] fields)
    {
        switch (this.getCardText().substring(0,2)){
            //Bilkort
            case("1:"):
                players[0].getCardArray().add(this);
                break;
            //Skibskort
            case("6:"):
                players[1].getCardArray().add(this);
                break;
            //Kattekort
            case("12:"):
                players[2].getCardArray().add(this);
                break;
            //Hundekort
            case("13:"):
                players[3].getCardArray().add(this);
                break;

        }

    }
}
