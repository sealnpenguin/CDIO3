package Cards;
import Player.*;
import Fields.*;

public class GetPaidOrPay extends Cards
{
    public GetPaidOrPay(String text, int index)
    {
        super(text, index);
    }

    @Override
    public void drawCard(Player[] players, int player, Field[] fields)
    {
        switch (this.getCardText().substring(0, 2)){
            case("14"):
                for (int i = 0; i < players.length; i++) {
                    if(i != player){
                        players[player].setMoney(-1);
                    }
                }
                players[player].setMoney(players.length-1);

        }
    }
}
