import java.awt.*;


/* !!!TANKER!!!
- Sørg for at bruger ikke kan taste samme navn ind
- SE VÆLG FARVE
*/
import Player.*;
public class GameBoard {
    static void Game() {
        int endGameIf = 0;
        boolean GameOver = false;
        Die die = new Die(1); // One die is instantiated with new Dice(int X);


        Field[] myFields = new Field[24];
        for (int i = 0; i < myFields.length; i++) {
            myFields[i] = new Properties();
        }
        UIController uiController = new UIController(myFields);




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

            uiController.getGUI().addPlayer(uiController.getGuiPlayer(i));

        }




        while (!GameOver) {
            // for loop which counts and loops thru the amount of players
            for (int i = 0; i < playerList.length; i++) {
                //Maybe use showmessage to make sure the correct player rolls?
                //gui.showMessage(playerList.get(i).getName() + " has the die in his court");

                //Guibutton to read the next user input
                String ready = uiController.getGUI().getUserButtonPressed(uiController.getGuiPlayer(i).getName() + " press button to roll the die!", "Roll");
                // if statement to check if the user typed in throw
                if (ready.equals("Roll")) {

                    uiController.getGUI().setDie(die.rollDie());
                    playerList[i].setPosition(+die.getFaceValue());

                    uiController.updateGUIPlayerPos(playerList[i],playerList[i].getOldposition(), playerList[i].getPosition());


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
