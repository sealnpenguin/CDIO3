import java.awt.*;
import java.util.Arrays;
import Cards.*;
import Fields.*;
import Player.*;

/* !!!TANKER!!!
- Optimer funktionen der tjekker om 2 brugere har samme navn??? se linje 34-44
- SE VÆLG FARVE
- Property value int i player for at nemmere at kunne tjekke når der er en der vinder?
- Se gameflow jail løsning - skal rettes til når chance kort er på plads!
*/

public class GameBoard {
    private boolean GameOver = false;
    private String lang;
    private final Die die = new Die(1); // One die is instantiated with new Dice(int X);
    private int numberOfPlayers = 0;
    private Player[] playerList = new Player[0];

    private final FieldsOnBoard f1 = new FieldsOnBoard();
    private final Field[] myFields = f1.getFieldArr();
    private UIController uiController;
    private String[] currentLang;

    public void Game() {
        uiController = new UIController(myFields);
        GameOver = false;
        lang = uiController.getGUI().getUserButtonPressed("", "English", "Dansk");
        Language langSelector = new Language(lang);
        currentLang = langSelector.returnLang();
        playerList = new Player[SetPlayerAmount()];


        //sets player name and sets start money amount
        for (int i = 1; i < numberOfPlayers + 1; i++) {
            Player player = new Player(uiController.getGUI().getUserString(currentLang[2] + i));
            //Made fast to check if name is already taken
            if (i == 2 ){
                while(player.getName().equals(playerList[0].getName())) {
                    player.setName(uiController.getGUI().getUserString(currentLang[19] + 2));}
            } else if (i == 3) {
                while(player.getName().equals(playerList[0].getName()) || player.getName().equals(playerList[1].getName())) {
                    player.setName(uiController.getGUI().getUserString(currentLang[19] + 3));}
            } else if (i == 4){
                while(player.getName().equals(playerList[0].getName()) || player.getName().equals(playerList[1].getName()) || player.getName().equals(playerList[2].getName())) {
                    player.setName(uiController.getGUI().getUserString(currentLang[19] + 4));}
            }
            //Sets the players money according the rules
            switch (numberOfPlayers) {
                case 2 -> player.setMoney(20);
                case 3 -> player.setMoney(18);
                case 4 -> player.setMoney(16);
            }
            playerList[i - 1] = player;
        }
        uiController.addPlayers(playerList);

        ChooseColor();

        //Fast way to test jail functionality
        //playerList[3].SetinJail(true);
        GameFlow();

    }

    private int SetPlayerAmount(){
        numberOfPlayers = uiController.getGUI().getUserInteger(currentLang[0]);
        while (numberOfPlayers > 4 || numberOfPlayers < 2) {
            uiController.getGUI().showMessage(currentLang[1]);
            numberOfPlayers = uiController.getGUI().getUserInteger(currentLang[0]);
        } return numberOfPlayers;
    }

    private void EndGame() {
        int endGameIf = 0;
        for (int k = 0; k < numberOfPlayers; k++) {
            if (uiController.getGuiPlayer(k).getBalance() <= endGameIf) {
                int[] a = new int[numberOfPlayers];
                int max = 0;
                GameOver = true;
                uiController.getGUI().showMessage("Gameover! " + uiController.getGuiPlayer(k).getName() + currentLang[12]);

                //first loop to check for game winner
                for (int j = 0; j < numberOfPlayers; j++) {
                    a[j] = uiController.getGuiPlayer(j).getBalance();
                    if (a[j] > max) {
                        max = a[j];
                    }
                }
                // second loop to announce winner
                for (int j = 0; j < a.length; j++) {
                    if (uiController.getGuiPlayer(j).getBalance() == max)
                        uiController.getGUI().showMessage(currentLang[13] + uiController.getGuiPlayer(j).getName() + " !!!");
                }
                break;
            }
        }
    }

    private void ChooseColor(){
        for (int i = 0; i < playerList.length; i++) {
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
    }

    private void GameFlow(){
        while (!GameOver) {
            // Change turn loop
            for (int i = 0; i < playerList.length; i++) {
                if(playerList[i].GetinJail() && !playerList[i].getJailCard())
                {
                    playerList[i].SetinJail(false);
                    break;
                } else if(playerList[i].GetinJail() && playerList[i].getJailCard())
                {
                    playerList[i].setJailCard(false);
                }

                //loop to check if a player as reached 0
                EndGame();
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
        //*******************************Restart game?!!***************************************************
        if(uiController.getGUI().getUserLeftButtonPressed(currentLang[16], currentLang[17], currentLang[18])){
            uiController.getGUI().close();
            Game();
        } else uiController.getGUI().close();
        //**************************************************************************************************
    }
}
