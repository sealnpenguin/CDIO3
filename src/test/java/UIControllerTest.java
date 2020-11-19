//import gui_fields.GUI_Player;
//import gui_main.GUI;
//import org.junit.jupiter.api.Test;
//
//import java.util.Scanner;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class UIControllerTest {
//
//    @Test
//    void UIFieldGen() {
//        Field[] myFields = new Field[24];
//        for (int i = 0; i < myFields.length; i++) {
//            myFields[i] = new Properties();
//        }
//        Player[] players = {new Player("test1"), new Player("test2"), new Player("test3"), new Player("test4")};
//        UIController myControl = new UIController(players, myFields);
//
//
//        Scanner scan = new Scanner(System.in);
//        scan.nextInt();
//    }
//
//    @Test
//    void updateGuiPlayerPos(){
//        Field[] myFields = new Field[24];
//        for (int i = 0; i < myFields.length; i++) {
//            myFields[i] = new Properties();
//        }
//        Player[] players = {new Player("test1"), new Player("test2"), new Player("test3"), new Player("test4")};
//        UIController myControl = new UIController(players, myFields);
//        for (int i = 0; i < players.length; i++) {
//            myControl.getGUI().addPlayer(myControl.UIPlayerGen(players)[i]);
//        }
//        myControl.getGUI().getUserButtonPressed( "Click a button",
//                "Button 1", "Button 2");
//        for (int i = 0; i < players.length; i++) {
//            myControl.updateGUIPlayerPos(players[i], 0, 5);
//        }
//        myControl.getGUI().getUserButtonPressed( "Click a button",
//                "Button 1", "Button 2");
//        myControl.updateGUIPlayerPos(players[0],5, 7);
//        myControl.updateGUIPlayerPos(players[1],5, 8);
//        myControl.updateGUIPlayerPos(players[2],5, 10);
//        myControl.updateGUIPlayerPos(players[3],5, 11);
//        myControl.getGUI().getUserButtonPressed( "Click a button",
//                "Button 1", "Button 2");
//    }
//}