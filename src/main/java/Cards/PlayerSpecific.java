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
            case("1:"):

        }

    }
}
