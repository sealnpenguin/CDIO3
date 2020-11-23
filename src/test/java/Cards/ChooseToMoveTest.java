package Cards;

import Fields.Field;
import Fields.FieldChance;
import Fields.FieldsOnBoard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import Player.*;

class ChooseToMoveTest {

    @Test
    void drawCard() {
        Field[] fields = new Field[24];
        FieldsOnBoard f1 = new FieldsOnBoard();
        fields = f1.getFieldArr();
        DynamicArr<ChooseToMove> choiceCards = new DynamicArr<ChooseToMove>();
        Player[] players = new Player[]{new Player("test1"), new Player("test2"), new Player("test3"), new Player("test4"), new Player("test5")};
        int choiceCounter = 0;
        for (int i = 0; i < ((FieldChance)fields[3]).getCards().size; i++) {
            if(((FieldChance)fields[3]).getCards().getLast() instanceof ChooseToMove){
                choiceCards.add((ChooseToMove) ((FieldChance)fields[3]).getCards().getLast());
            }
            ((FieldChance)fields[3]).getCards().lastItemToFront();
        }
        //test for kort 3 "Ryk op til 5 felter frem"
        for (int i = 0; i < 5; i++) {
            choiceCards.getLast().drawCard(players, i, fields, i+1);
            assertEquals(players[i].getPosition(), i+1);
        }
        choiceCards.lastItemToFront();

        //Test for kort 4 "Vælg orange felt" (Skatepark: position 10 og swimmingpool: position 11)
        choiceCards.getLast().drawCard(players, 0, fields, 0);
        assertEquals(players[0].getPosition(), 10);
        choiceCards.getLast().drawCard(players, 0, fields, 1);
        assertEquals(players[0].getPosition(), 11);
        choiceCards.lastItemToFront();

        //Tester for kort 5 "Ryk et felt frem eller tag et chancekort"
        players[0].setSpecificPosition(0);


    }
}