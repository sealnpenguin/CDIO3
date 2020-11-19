import gui_fields.GUI_Player;
import gui_main.GUI;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class UIControllerTest {

    @Test
    void UIFieldGen() {
        Arraylist<Field> myFields = new Arraylist<>();
        for (int i = 0; i < myFields.listLength(); i++) {
            myFields.add(new Properties());
        }
        Arraylist<Player> players = new Arraylist<>(new Player[]{new Player("test1"), new Player("test2"), new Player("test3"), new Player("test4")});
        UIController myControl = new UIController(players, myFields);


        Scanner scan = new Scanner(System.in);
        scan.nextInt();
    }

    @Test
    void updateGuiPlayerPos(){
        Arraylist<Field> myFields = new Arraylist<>();
        for (int i = 0; i < myFields.listLength(); i++) {
            myFields.add(new Properties());
        }
        Arraylist<Player> players = new Arraylist<>(new Player[]{new Player("test1"), new Player("test2"), new Player("test3"), new Player("test4")});
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