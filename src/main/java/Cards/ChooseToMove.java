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
    public void drawCard(Player[] players, int player, Field[] fields)
    {

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
