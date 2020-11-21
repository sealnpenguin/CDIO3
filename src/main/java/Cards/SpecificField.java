package Cards;
import Player.*;
import Fields.*;
import java.util.Scanner;


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
            case("1:"):

            case("2:"):
                players[player].setSpecificPosition(0);
                break;

            case("3:"):
                ChooseToMove.moveForward(players, player);
                break;

            case("4:"):

            case("11"):
                Properties p1 = ((Properties)fields[23]);
                players[player].setSpecificPosition(23);
                if(p1.getOwnedBy() == -1 && p1.getOwnedBy() == player){
                    p1.setOwnedBy(player);
                }
                else{
                    players[player].setMoney(-p1.getPrice());
                    players[p1.getOwnedBy()].setMoney(p1.getPrice());
                }
                break;

            case("18"):
                Properties p2 = ((Properties)fields[10]);
                players[player].setSpecificPosition(10);
                if(p2.getOwnedBy() == -1 && p2.getOwnedBy() == player){
                    p2.setOwnedBy(player);
                }
                else{
                    players[player].setMoney(-p2.getPrice());
                    players[p2.getOwnedBy()].setMoney(p2.getPrice());
                }
                break;


                //Plads 10
        }
    }
}
