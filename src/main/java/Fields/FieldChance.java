package Fields;
import Player.*;
import Cards.*;

import java.util.Random;

public class FieldChance extends Field {

    private DynamicArr<Cards> cards = new DynamicArr<Cards>();

    public FieldChance(){
        super("?", "Tag et chancekort");
        this.generateChanceCards();
    }


    @Override
    public void landOnField(Player[] players, int player) {
        takeChanceCard(players, player);
    }

    public void takeChanceCard(Player[] players, int player){
    }

    public void generateChanceCards(){
        CardInfo info = new CardInfo();
        String temp;
        for (int i = 0; i < info.getText().length; i++) {
            temp = info.getText()[i];
            if(temp.substring(0,2).equals("1:") || temp.substring(0,2).equals("6:") || temp.substring(0,2).equals("12") || temp.substring(0,2).equals("13")){
                cards.add(new PlayerSpecific(temp, 0));
            }
            else if(temp.substring(0,2).equals("10")){
                cards.add(new GetOutOfJail(temp,0));
            }
            else if(temp.substring(0,2).equals("7:") || temp.substring(0,2).equals("14") || temp.substring(0,2).equals("16")){
                cards.add(new GetPaidOrPay(temp, 0));
            }
            else if(temp.substring(0,2).equals("2:") || temp.substring(0,2).equals("11") || temp.substring(0,2).equals("18") ){
                cards.add(new SpecificField(temp,0));
            }
            else{
                cards.add(new ChooseToMove(temp, 0));
            }

        }

    }

    public void mixCards(){
        Cards[] tempArr = new Cards[getCards().size];
        Random ran = new Random();
        int counter = 0;
        while(this.cards.size > 0){
            int random = ran.nextInt(this.cards.size);
            tempArr[counter]=cards.atIndex(random);
            cards.removeAt(random);
        }
        for (int i = 0; i < tempArr.length; i++) {
            cards.add(tempArr[i]);
        }
    }

    public DynamicArr<Cards> getCards(){
        return this.cards;
    }
}
