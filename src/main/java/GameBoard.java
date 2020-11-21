import java.awt.*;
import java.util.Arrays;
import java.util.Arrays;
import Cards.*;
import Fields.*;
import Player.*;


/* !!!TANKER!!!
- Sørg for at bruger ikke kan taste samme navn ind
- SE VÆLG FARVE
*/

public class GameBoard {
    static void Game() {
        int endGameIf = 0;
        boolean GameOver = false;
        String lang;
        Die die = new Die(1); // One die is instantiated with new Dice(int X);


        FieldsOnBoard f1 = new FieldsOnBoard();
        Field[] myFields = f1.getFieldArr();
        UIController uiController = new UIController(myFields);

        lang = uiController.getGUI().getUserButtonPressed("" ,"English", "Dansk");
        Language langSelector = new Language(lang);
        String[] currentLang = langSelector.returnLang();




        int numberOfPlayers = uiController.getGUI().getUserInteger(currentLang[0]);
        while (numberOfPlayers > 4 || numberOfPlayers < 2) {
            uiController.getGUI().showMessage(currentLang[1]);
            numberOfPlayers = uiController.getGUI().getUserInteger(currentLang[0]);
        }
        Player[] playerList = new Player[numberOfPlayers];
        // Create player objects as per the playerdefined numberOfPlayers int.

        for (int i = 1; i < numberOfPlayers+1; i++) {
            Player player = new Player(uiController.getGUI().getUserString(currentLang[2] + i));
            //Sets the players money according the rules
            switch (numberOfPlayers) {
                case 2 -> player.setMoney(20);
                case 3 -> player.setMoney(18);
                case 4 -> player.setMoney(16);
            }
            playerList[i-1] = player;
        }
        uiController.addPlayers(playerList);
        //Initialize and Add players to gui
        for (int i = 0; i < playerList.length; i++) {
            //
            String color = uiController.getGUI().getUserSelection(uiController.getGuiPlayer(i).getName()+currentLang[3],currentLang[4], currentLang[5],currentLang[6],currentLang[7],currentLang[8],currentLang[9],currentLang[10],currentLang[11]);
            if(lang.equals("English")) {
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
            }
            if(lang.equals("Dansk")) {
                switch (color) {
                    case "RØD" -> uiController.getGuiPlayer(i).getCar().setPrimaryColor(Color.RED);
                    case "SORT" -> uiController.getGuiPlayer(i).getCar().setPrimaryColor(Color.BLACK);
                    case "BLÅ" -> uiController.getGuiPlayer(i).getCar().setPrimaryColor(Color.BLUE);
                    case "MAGENTA" -> uiController.getGuiPlayer(i).getCar().setPrimaryColor(Color.MAGENTA);
                    case "ROSE" -> uiController.getGuiPlayer(i).getCar().setPrimaryColor(Color.PINK);
                    case "CYAN" -> uiController.getGuiPlayer(i).getCar().setPrimaryColor(Color.CYAN);
                    case "GUL" -> uiController.getGuiPlayer(i).getCar().setPrimaryColor(Color.YELLOW);
                    case "HVID" -> uiController.getGuiPlayer(i).getCar().setPrimaryColor(Color.WHITE);
                }
            }
            // we update GUIPLAYERPOS here to set player at start
            uiController.updateGUIPlayerPos(playerList[i],playerList[i].getOldposition(), playerList[i].getPosition());
        }





        while (!GameOver) {
            // Change turn loop
            for (int i = 0; i < playerList.length; i++) {
                //loop to check if a player as reached 0
                for (int k = 0; k < playerList.length; k++) {
                    if (playerList[k].getMoney() <= endGameIf)
                    {
                        GameOver = true;
                        uiController.getGUI().showMessage("Gameover! "+ playerList[k].getName() + currentLang[12]);
                        int[] a = new int[numberOfPlayers];
                        int max = 0;

                        //first loop to check for game winner
                        for (int j = 0; j < playerList.length; j++) {
                            a[j] = playerList[j].getMoney();
                            if(a[j] > max)
                            {
                                max = a[j];
                            }
                        }
                        // second loop to announce winner
                        for (int j = 0; j < a.length; j++) {
                            if(playerList[j].getMoney() == max) uiController.getGUI().showMessage(currentLang[13]+ playerList[j].getName() + " !!!");
                        }
                        break;
                    }
                }
                if(GameOver) break;
                //Maybe use showmessage to make sure the correct player rolls?
                //gui.showMessage(playerList.get(i).getName() + " has the die in his court");

                //Guibutton to read the next user input
                String ready = uiController.getGUI().getUserButtonPressed(uiController.getGuiPlayer(i).getName() + currentLang[14], currentLang[15]);
                // if statement to check if the user typed in throw
                if (ready.equals(currentLang[15])) {
                    //Change die on in gui to reflect new roll and update player position
                    uiController.getGUI().setDie(die.rollDie());
                    playerList[i].setPosition(+die.getFaceValue());

                    //updates gui player position
                    uiController.updateGUIPlayerPos(playerList[i],playerList[i].getOldposition(), playerList[i].getPosition());

                    //temp for testing
                    //Set money for both the logical and gui parts of the game
                    playerList[i].setMoney(+-die.getFaceValue());
                    uiController.getGuiPlayer(i).setBalance(playerList[i].getMoney());
                }
            }
        }
    }
}
