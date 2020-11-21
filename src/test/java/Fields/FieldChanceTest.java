package Fields;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldChanceTest {

    @Test
    void landOnField() {
    }

    @Test
    void takeChanceCard() {
    }

    @Test
    void generateChanceCards() {
        FieldChance f1 = new FieldChance();
        for (int i = 0; i < f1.getCards().size; i++) {
            System.out.println(f1.getCards().atIndex(i).getCardText());
        }
        f1.mixCards();
        for (int i = 0; i < f1.getCards().size; i++) {
            System.out.println(f1.getCards().atIndex(i).getCardText());
        }
    }

}