package Cards;

import Fields.Field;
import Fields.FieldChance;
import Player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//kort 10 er fængselskort

class GetOutOfJailTest {

    @Test
    void drawCard() {
        Player[] players = new Player[]{new Player("test1"), new Player("test2"), new Player("test3"), new Player("test4")};
        FieldChance f1 = new FieldChance();
        Field[] f2 = new Field[0];
        System.out.println("Du har jailkort");
        System.out.println(players[0].getJailCard());
        DynamicArr<GetOutOfJail> choiceCards = new DynamicArr<GetOutOfJail>();
        int choiceCounter = 0;
        for (int i = 0; i < f1.getCards().size; i++) {
            if(f1.getCards().getLast() instanceof GetOutOfJail){
                choiceCards.add((GetOutOfJail) f1.getCards().getLast());
            }
            f1.getCards().lastItemToFront();
        }
            choiceCards.getLast().drawCard(players, 0, f2, -1);
            System.out.print(choiceCards.getLast().getCardText());
        System.out.println("Du har jailkort");
        System.out.println(players[0].getJailCard());
        //System.out.println();
    }
}