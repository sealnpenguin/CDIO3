//import gui_fields.GUI_Field;
//import gui_fields.GUI_Player;

import java.awt.*;
//import java.util.ArrayList;
//import java.util.List;

/* !!!TANKER!!!
- FIX SÅ PROGRAMMET IKKE STOPPER VED FOR STOR INT I NUMBEROFPLAYERS
- DET SAMME KAN GØRES FOR STRING
- SKAL GUI REFERERER OG KØRES HERFRA? - RET NÅR JAN HAR OPSAT GUI
- PLAYER.HASTURN? - HAR INDSAT EVENTUELT BRUG ANDEN LØSNING????
- MÅSKE PLAYER SKAL HAVE EN GUI_PLAYER OBJECT I SIG FOR AT NEMMERE TILGÅ DEM?
- BENYT MARTINS ARRAYLISTE!
- SE VÆLG FARVE
- GUI PLAYER ARRAY? NØDVENDIGT?
*/

public class GameBoard {
    static void Game() {
        int endGameIf = 0;
        boolean GameOver = false;
        //int numberOfPlayers;
       // List<Player> playerList = new ArrayList<>();

        Die die = new Die(1); // One die is instantiated with new Dice(int X);
        //GUI gui = new GUI();
       //DynamicArr<GUI_Player> GuiPlayerArr = new DynamicArr<>();
        Field[] myFields = new Field[24];
        for (int i = 0; i < myFields.length; i++) {
            myFields[i] = new Properties();
        }
        UIController uiController = new UIController(myFields);
        //GUI_Field field = uiController.getGUI().getFields()[0];
        //uiController.UIFieldGen(myFields);



        int numberOfPlayers = uiController.getGUI().getUserInteger("Enter the number of players ranging from 2-4");
        while (numberOfPlayers > 4 || numberOfPlayers < 2) {
            uiController.getGUI().showMessage("Please try again in the range of 2-4");
            numberOfPlayers = uiController.getGUI().getUserInteger("Please enter the number of players ranging from 2-4");
        }
        Player[] playerList = new Player[numberOfPlayers];
        // Create player objects as per the playerdefined numberOfPlayers int.

        for (int i = 0; i < numberOfPlayers; i++) {
            Player player = new Player(uiController.getGUI().getUserString("Enter name for player " + i));
            //Sets the players money according the rules
            switch (numberOfPlayers) {
                case 2 -> player.setMoney(20);
                case 3 -> player.setMoney(18);
                case 4 -> player.setMoney(16);
            }
            playerList[i] = player;
        }
        uiController.addPlayers(playerList);
        //Initialize and Add players to gui
        for (int i = 0; i < playerList.length; i++) {

            //GUI_Player guiplayerx = new GUI_Player(player.getName(), player.getMoney());

            //Vælg farve - Lavet hurtigt - Måske ryk til andet sted?
            String color = uiController.getGUI().getUserSelection(uiController.getGuiPlayer(i).getName()+" choose a color for your car","RED", "BLACK", "BLUE","MAGENTA","PINK","CYAN","YELLOW","WHITE");
            switch (color) {
                case "RED" -> uiController.getGuiPlayer(i).getCar().setPrimaryColor(Color.RED);
                case "BLACK" -> uiController.getGuiPlayer(i).getCar().setPrimaryColor(Color.BLACK);
                case "BLUE" -> uiController.getGuiPlayer(i).getCar().setPrimaryColor(Color.BLUE);
                case "MAGENTA" -> uiController.getGuiPlayer(i).getCar().setPrimaryColor(Color.MAGENTA);
                case "PINK" -> uiController.getGuiPlayer(i).getCar().setPrimaryColor(Color.PINK);
                case "CYAN" -> uiController.getGuiPlayer(i).getCar().setPrimaryColor(Color.CYAN);
                case "YELLOW" -> uiController.getGuiPlayer(i).getCar().setPrimaryColor(Color.YELLOW);
                case "WHITE" -> uiController.getGuiPlayer(i).getCar().setPrimaryColor(Color.WHITE);
            }

            //GuiPlayerArr.add(guiplayerx); // Adds guiplayer to guiplayer array might not be needed!!!
            uiController.getGUI().addPlayer(uiController.getGuiPlayer(i));
           // field.setCar(uiController.getGuiPlayer(i), true);

        }

        //Tanke.. GUI_Player array - måske brugbart???
        /*for (GUI_Player guiplayerx : GuiPlayerArr) {
            //GUI_Player guiplayerx = new GUI_Player(player.getName(), player.wallet.getMoney());
            //GuiPlayerArr.add(guiplayerx);
            gui.addPlayer(guiplayerx);
        }*/


        while (!GameOver) {
            // for loop which counts and loops thru the amount of players
            for (int i = 0; i < playerList.length; i++) {
                //Maybe use showmessage to make sure the correct player rolls?
                //gui.showMessage(playerList.get(i).getName() + " has the die in his court");

                //Guibutton to read the next user input
                String ready = uiController.getGUI().getUserButtonPressed(uiController.getGuiPlayer(i).getName() + " press button to roll the die!", "Roll");
                // if statement to check if the user typed in throw
                if (ready.equals("Roll")) {
                    // function in Dice which rolls the dice
                    // add the dice value to the players points
                    uiController.getGUI().setDie(die.rollDie());
                    playerList[i].setPosition(+die.getFaceValue());
                    //Methods for setting the player money and to show gui money
                    //playerList.get(i).wallet.setMoney(+die.getFaceValue());
                    //GuiPlayerArr.atIndex(i).setBalance(playerList.get(i).wallet.getMoney());


                    // !!!!VIRKER, MEN OPTIMATION?!!!!
                    // gets player position/field and removes the car from the current field
                   // field = uiController.getGUI().getFields()[playerList[i].getPosition()];
                    //field.setCar(uiController.getGuiPlayer(i), false);
                    //playerList.get(i).setPosition(+die.getFaceValue());
                    uiController.updateGUIPlayerPos(playerList[i],playerList[i].getOldposition(), playerList[i].getPosition());
                    // gets player position/field and adds the car to the current field
                    //field = uiController.getGUI().getFields()[playerList.get(i).getPosition()];
                    //field.setCar(GuiPlayerArr.atIndex(i), true);

                    //!!!Skal ændres!!!
                    if (playerList[i].getMoney() <= endGameIf)
                    {
                        System.out.println("Rolls: " + die.getFaceValue());
                        System.out.println(playerList[i].getName() + " has reached " +endGameIf);
                        GameOver = true;
                        uiController.getGUI().showMessage("Gameover "+ playerList[i].getName() + " lost");
                        break;

                    }
                    else {
                        System.out.println("Rolls: " + die.getFaceValue());
                        System.out.println(playerList[i].getName() + " now has " + playerList[i].getMoney() + " M!");
                    }
                }
            }
        }
    }
}
