package Cards;
import Fields.*;
import Cards.*;
import Player.*;
import java.util.Scanner;


import Player.Player;

import java.util.Scanner;

public class ChooseToMove extends Cards
{
    public ChooseToMove(String text, int index)
    {
        super(text, index);
    }

    @Override
    //Updates the playerPosition **** not sure if it should use landOnField method on new field as well
    public void drawCard(Player[] players, int player, Field[] fields, int choice)
    {
        switch (this.getCardText().substring(0,2)){
            case("3:"):
                players[player].setPosition(choice);
                break;
            case("4:"):
                if(choice == 0){ players[player].setSpecificPosition(10);}
                else { players[player].setSpecificPosition(11);}
                break;
            case("5:"):
                if(choice == 0){
                    this.setDrawAgain(true);
                }
                else{players[player].setPosition(choice);}
                break;
            case("8:"):
                if(choice == 0){ players[player].setSpecificPosition(10);}
                else if(choice == 1) { players[player].setSpecificPosition(11);}
                else if(choice == 2){ players[player].setSpecificPosition(19);}
                else if(choice == 3){ players[player].setSpecificPosition(20);}
                break;
            case("9:"):
                if(choice == 0){ players[player].setSpecificPosition(4);}
                else { players[player].setSpecificPosition(5);}
                break;
            case("15"):
                if(choice == 0){ players[player].setSpecificPosition(7);}
                else if(choice == 1) { players[player].setSpecificPosition(8);}
                else if(choice == 2){ players[player].setSpecificPosition(22);}
                else if(choice == 3){ players[player].setSpecificPosition(23);}
                break;
            case("17"):
                if(choice == 0){ players[player].setSpecificPosition(13);}
                else { players[player].setSpecificPosition(14);}
                break;
            case("19"):
                if(choice == 0){ players[player].setSpecificPosition(4);}
                else if(choice == 1) { players[player].setSpecificPosition(5);}
                else if(choice == 2){ players[player].setSpecificPosition(13);}
                else if(choice == 3){ players[player].setSpecificPosition(14);}
                break;
            case("20"):
                if(choice == 0){ players[player].setSpecificPosition(1);}
                else if(choice == 1) { players[player].setSpecificPosition(2);}
                else if(choice == 2){ players[player].setSpecificPosition(16);}
                else if(choice == 3){ players[player].setSpecificPosition(17);}
                break;

        }
        //Checks that the one case with no movement i not the path and calls land on field method
        if(!this.getCardText().substring(0,2).equals("5:") && choice != 0) {
            fields[players[player].getPosition()].landOnField(players, player);
        }

    }


    /* Ved chancekort 3 er det denne funktion der lader en vælge hvor langt frem der skal gåes */
    public static void moveForward(Player[] players, int player){
        Scanner ryk = new Scanner(System.in);
        System.out.println("indtast hvor mange felter de ønsker at rykke frem: ");
        int FremRyk = ryk.nextInt();
        while(FremRyk < 1 || FremRyk > 5) {
            System.out.println("Der er indtastet en ugyldig værdig. Indtast en gyldig værdi mellem 1 og 5: ");
            FremRyk = ryk.nextInt();
        }
        players[player].setPosition(FremRyk);
    }




}
