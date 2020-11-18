import gui_main.GUI;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class UIControllerTest {

    @Test
    void UIFieldGen() {
        Field[] myFields = new Field[24];
        for (int i = 0; i < myFields.length; i++) {
            //myFields[i] = new Properties();
        }
        UIController myControl = new UIController();
        GUI gui = new GUI(myControl.UIFieldGen(myFields));
        Scanner scan = new Scanner(System.in);
        scan.nextInt();
    }
}