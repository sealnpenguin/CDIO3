package Fields;
import Player.*;
import Cards.*;

import java.util.Random;

public class FieldChance extends Field {

    private DynamicArr<Cards> cards = new DynamicArr<Cards>();

    public FieldChance(){
        super("?", "Tag et chancekort");
        this.generateChanceCards(true);
    }

    public void landOnField(Player[] players, int player){

    }

    public void landOnField(Player[] players, int player, Field[] fields) {
        takeChanceCard(players, player, fields);
    }

    public void takeChanceCard(Player[] players, int player, Field[] fields){
        cards.atIndex(cards.size-1).drawCard(players, player, fields);
        if(cards.size == 0){
            boolean jail = true;
            for (int i = 0; i < players.length; i++) {
                if(players[i].getJailCard()){
                    jail = false;
                }
            }
            generateChanceCards(jail);
        }
    }
    //Method that generates a set of cards from cardInfo
    //Get out of jail card excluded parameter is false
    public void generateChanceCards(boolean jail){
        CardInfo info = new CardInfo();
        cards = new DynamicArr<Cards>();
        String temp;
        for (int i = 0; i < info.getText().length; i++) {
            temp = info.getText()[i];
            if(temp.substring(0,2).equals("1:") || temp.substring(0,2).equals("6:") || temp.substring(0,2).equals("12") || temp.substring(0,2).equals("13")){
                cards.add(new PlayerSpecific(temp, 0));
            }
            else if(temp.substring(0,2).equals("10") && jail == true){
                cards.add(new GetOutOfJail(temp,0));
            }
            else if(temp.substring(0,2).equals("7:") || temp.substring(0,2).equals("14") || temp.substring(0,2).equals("16")){
                cards.add(new GetPaidOrPay(temp, 0));
            }
            else if(temp.substring(0,2).equals("2:") || temp.substring(0,2).equals("11") || temp.substring(0,2).equals("18") ){
                cards.add(new SpecificField(temp,0));
            }
            else if(!temp.substring(0,2).equals("10")){
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
            counter++;
        }
        for (int i = 0; i < tempArr.length; i++) {
            cards.add(tempArr[i]);
        }
    }

    public DynamicArr<Cards> getCards(){
        return this.cards;
    }
}
