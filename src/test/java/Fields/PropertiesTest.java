package Fields;

import Player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertiesTest {

    @Test
    void landOnField() {
        Player[] players = new Player[]{new Player("test"),new Player("test"),new Player("test")};
        players[0].setMoney(20);
        Field[] fields = new Field[24];
        FieldsOnBoard f1 = new FieldsOnBoard();
        fields = f1.getFieldArr();
        players[1].setMoney(20);
        ((Properties)fields[1]).setOwnedBy(1);
        ((Properties)fields[2]).setOwnedBy(1);
        players[0].setPosition(2);
        ((Properties)fields[2]).landOnField(players, 0, fields);
        assertEquals(18,players[0].getMoney());
        assertEquals(22,players[1].getMoney());
    }
}