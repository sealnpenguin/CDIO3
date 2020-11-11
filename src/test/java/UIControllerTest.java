import gui_main.GUI;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class UIControllerTest {

    @Test
    void UIFieldGen() {
        UIController myControl = new UIController();
        GUI gui = new GUI(myControl.UIFieldGen(15));
        Scanner scan = new Scanner(System.in);
        scan.nextInt();
    }
}