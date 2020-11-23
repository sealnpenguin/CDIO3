package Fields;

import Player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertiesTest {

    @Test
    void landOnField() {
        Player[] players = new Player[]{new Player("test")};
        players[0].setMoney(20);
        System.out.println(players[0].getMoney());
        Field[] fields = new Field[24];
        FieldsOnBoard f1 = new FieldsOnBoard();
        fields = f1.getFieldArr();
        fields[1].landOnField(players, 0);
        System.out.println(players[0].getMoney());
    }
}