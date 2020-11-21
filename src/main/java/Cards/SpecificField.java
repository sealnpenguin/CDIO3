package Cards;
import Player.*;

public class SpecificField extends Cards
{
    public SpecificField(String text, int index)
    {
        super(text, index);
    }

    @Override
    public void drawCard(Player[] players, int player)
    {
        switch(this.getCardText().substring(0, 2))
        {
            case("18"):
                players[player].setSpecificPosition(10);


                //Plads 10
        }
    }
}
