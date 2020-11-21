package Fields;

import Player.Player;

public class FieldStart extends Field{
    //Starting field
    private int fieldValue = 2; // Skal det være -2, fordi man modtager pengene?

    public FieldStart(){
       super("Start", "Modtag 2M når du passerer start");

    }

    @Override
    public void landOnField(Player[] players, int player) {

    }

    public int getFieldValue() {
        return fieldValue;
    }
}