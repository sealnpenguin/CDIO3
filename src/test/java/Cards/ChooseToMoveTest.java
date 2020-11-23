package Cards;

import Fields.FieldChance;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChooseToMoveTest {

    @Test
    void drawCard() {
        FieldChance f1 = new FieldChance();
        DynamicArr<ChooseToMove> choiceCards = new DynamicArr<ChooseToMove>();
        int choiceCounter = 0;
        for (int i = 0; i < f1.getCards().size; i++) {
            if(f1.getCards().getLast() instanceof ChooseToMove){
                choiceCards.add((ChooseToMove) f1.getCards().getLast());
            }
            f1.getCards().lastItemToFront();
        }
        for (int i = 0; i < choiceCards.size; i++) {
            System.out.println(choiceCards.getLast().getCardText());
            choiceCards.lastItemToFront();
        }
    }
}