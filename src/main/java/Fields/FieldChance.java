package Fields;
import Player.*;
import Cards.*;
public class FieldChance extends Field {

    private DynamicArr<Cards> cards = new DynamicArr<Cards>();

    public FieldChance(){
        super("?", "Tag et chancekort");
    }


    @Override
    public void landOnField(Player[] players, int player) {
        takeChanceCard(players, player);
    }

    public void takeChanceCard(Player[] players, int player){
    }

    public void generateChanceCards(){
        CardInfo info = new CardInfo();
        for (int i = 0; i < info.getText().length; i++) {

        }

    }
}
