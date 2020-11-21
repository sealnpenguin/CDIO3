package Cards;
import Player.*;
import Fields.*;


public class SpecificField extends Cards
{
    public SpecificField(String text, int index)
    {
        super(text, index);
    }

    @Override
    public void drawCard(Player[] players, int player, Field[] fields)
    {
        switch(this.getCardText().substring(0, 2))
        {
            case("18"):
                Properties p1 = ((Properties)fields[10]);
                players[player].setSpecificPosition(10);
                if(p1.getOwnedBy() == -1 && p1.getOwnedBy() == player){
                    p1.setOwnedBy(player);
                }
                else{
                    players[player].setMoney(-p1.getPrice());
                    players[p1.getOwnedBy()].setMoney(p1.getPrice());
                }


                //Plads 10
        }
    }
}
