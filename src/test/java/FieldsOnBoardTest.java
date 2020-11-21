import gui_main.GUI;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import Fields.*;

class FieldsOnBoardTest {

    @Test
    void fieldsOnBoard() {
        FieldsOnBoard f1 = new FieldsOnBoard();
        f1.fieldsOnBoard();
        for (int i = 0; i < f1.getFieldArr().length; i++) {
            Field[] testarr = f1.getFieldArr();
            String testString = testarr[i].getFieldName();
            System.out.println(testString + " fieldOnBoardtest test");
        }
        UIController myControl = new UIController(f1.getFieldArr());
        myControl.getGUI().getUserButtonPressed("test", "Button1");
    }
}