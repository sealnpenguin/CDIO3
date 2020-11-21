package Fields;
import Player.*;

public class FieldChance extends Field {
    public FieldChance(){
        super("?", "Tag et chancekort");
    }


    @Override
    public void landOnField(Player[] players, int player) {
        takeChanceCard(players, player);
    }

    public void takeChanceCard(Player[] players, int player){
    }
}
