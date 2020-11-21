import Fields.Field;
import Fields.Properties;
import Player.Player;
import org.junit.jupiter.api.Test;

import java.util.Scanner;
import Cards.*;

class UIControllerTest {

    @Test
    void UIFieldGen() {
        DynamicArr<Field> myFields = new DynamicArr<Field>();
        for (int i = 0; i < myFields.size; i++) {
            myFields.add(new Properties());
        }
        DynamicArr<Player> players = new DynamicArr<Player>(new Player[]{new Player("test1"), new Player("test2"), new Player("test3"), new Player("test4")});
        UIController myControl = new UIController(players, myFields);


        Scanner scan = new Scanner(System.in);
        scan.nextInt();
    }

    @Test
    void updateGuiPlayerPos(){
        DynamicArr<Field> myFields = new DynamicArr<>();
        for (int i = 0; i < myFields.listLength(); i++) {
            myFields.add(new Properties());
        }
        DynamicArr<Player> players = new DynamicArr<>(new Player[]{new Player("test1"), new Player("test2"), new Player("test3"), new Player("test4")});
        UIController myControl = new UIController(players, myFields);
        for (int i = 0; i < players.listLength(); i++) {
            myControl.getGUI().addPlayer(myControl.UIPlayerGen(players).atIndex(i));
        }
        myControl.getGUI().getUserButtonPressed( "Click a button",
                "Button 1", "Button 2");
        for (int i = 0; i < players.listLength(); i++) {
            myControl.updateGUIPlayerPos(players.atIndex(i), 0, 5);
        }
        myControl.getGUI().getUserButtonPressed( "Click a button",
                "Button 1", "Button 2");
        myControl.updateGUIPlayerPos(players.atIndex(0),5, 7);
        myControl.updateGUIPlayerPos(players.atIndex(1),5, 8);
        myControl.updateGUIPlayerPos(players.atIndex(2),5, 10);
        myControl.updateGUIPlayerPos(players.atIndex(3),5, 11);
        myControl.getGUI().getUserButtonPressed( "Click a button",
                "Button 1", "Button 2");
    }
}