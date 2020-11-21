package Cards;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import Player.Player;

public abstract class Cards
{
    private int cardIndex;
    private String cardText;


        public Cards (String text, int index)
        {
            this.cardIndex = index;
            this.cardText = text;
        }

    public int getCardIndex() {
        return cardIndex;
    }

    public String getCardText() {
        return cardText;
    }

    public abstract void drawCard(Player[] players);


}
