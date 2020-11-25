import Fields.*;
import Player.Player;
import ViewLayer.UIController;

import java.awt.*;

/*
//**************************************************!!!TANKER!!!********************************************************
- Optimer funktionen der tjekker om 2 brugere har samme navn??? se linje 34-44
- Property value int i player for at nemmere at kunne tjekke når der er en der vinder?
- Måske gør så man kan se hvem der betaler til hvem i.e. Jens Betaler 1M Til Mads for at blive natten over.
- Enten gør valget af sprog usynligt eller færdiggør det.
- Gør så 2 spillere ikke kan have samme farve. - Vigtigt
- Justér farve på felter i Gui så det ikke er de samme
- Opdel gameboard i flere metoder? se steder med mange ****
- Optimer hele gameboard??

//**********************************************************************************************************************
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
    FieldChance fieldChance = (FieldChance) myFields[3];


    public void Game() {
        ((FieldChance)myFields[3]).mixCards();
        uiController = new UIController(myFields);
        GameOver = false;
        lang = uiController.getGUI().getUserButtonPressed("", "WIP English", "Dansk");
        Language langSelector = new Language(lang);
        currentLang = langSelector.returnLang();
        playerList = new Player[SetPlayerAmount()];

        fieldChance.mixCards();
        PlayerCreator();
        uiController.addPlayers(playerList);

        ChooseColor();

        //Fast way to test jail functionality
        //playerList[3].setInJail(true);
        //playerList[3].setJailCard(true);

        GameFlow();

    }

    private int SetPlayerAmount(){
        numberOfPlayers = uiController.getGUI().getUserInteger(currentLang[0]);
        while (numberOfPlayers > 4 || numberOfPlayers < 2) {
            uiController.getGUI().showMessage(currentLang[1]);
            numberOfPlayers = uiController.getGUI().getUserInteger(currentLang[0]);
        } return numberOfPlayers;
    }

    private void PlayerCreator(){
        uiController.getGUI().showMessage(currentLang[26]);
        //sets player name and sets start money amount
        for (int i = 1; i < numberOfPlayers + 1; i++) {
            Player player = new Player(uiController.getGUI().getUserString(currentLang[2] + i));
            //Made fast to check if name is already taken
            /*if (i == 2) {
                while (player.getName().equals(playerList[0].getName())) {
                    player.setName(uiController.getGUI().getUserString(currentLang[19] + 2));
                }
            } else if (i == 3) {
                while (player.getName().equals(playerList[0].getName()) || player.getName().equals(playerList[1].getName())) {
                    player.setName(uiController.getGUI().getUserString(currentLang[19] + 3));
                }
            } else if (i == 4) {
                while (player.getName().equals(playerList[0].getName()) || player.getName().equals(playerList[1].getName()) || player.getName().equals(playerList[2].getName())) {
                    player.setName(uiController.getGUI().getUserString(currentLang[19] + 4));
                }
            }*/
            //Sets the players money according the rules
            switch (numberOfPlayers) {
                case 2 -> player.setMoney(20);
                case 3 -> player.setMoney(18);
                case 4 -> player.setMoney(16);
            }
            playerList[i - 1] = player;
            playerList[i-1].setName(playerList[i-1].getName() + currentLang[i+21]);
        }
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
        for (int g = 0; g < playerList.length; g++) {
            uiController.getGuiPlayer(g).getCar().setPrimaryColor(Color.darkGray);
        }
        for (int i = 0; i < playerList.length; i++) {
            while(uiController.getGuiPlayer(i).getPrimaryColor() == Color.darkGray ||
                i > 0 && uiController.getGuiPlayer(i).getPrimaryColor() == uiController.getGuiPlayer(0).getPrimaryColor()||
                i > 1 && uiController.getGuiPlayer(i).getPrimaryColor() == uiController.getGuiPlayer(1).getPrimaryColor()||
                i > 2 && uiController.getGuiPlayer(i).getPrimaryColor() == uiController.getGuiPlayer(2).getPrimaryColor()){
                String color = uiController.getGUI().getUserSelection(uiController.getGuiPlayer(i).getName()+currentLang[3],currentLang[4],
                        currentLang[5],currentLang[6],currentLang[7],currentLang[8],currentLang[9],currentLang[10],currentLang[11]);
                ColorSwitch(color,i);
            }

            // we update GUIPLAYERPOS here to set player at start
            uiController.updateGUIPlayerPos(playerList[i],playerList[i].getOldposition(), playerList[i].getPosition());
        }
    }


    private void ColorSwitch(String color, int i){
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
        } else if(lang.equals("Dansk")) {
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
    }
    private void GameFlow(){
        while (!GameOver) {
            // Change turn loop
            for (int i = 0; i < playerList.length; i++) {
                // Gotta update Money here to make sure the gui displays the correct amount.
                for (int j = 0; j < playerList.length; j++) {
                    uiController.getGuiPlayer(j).setBalance(playerList[j].getMoney());
                }
                //**********************************************JAIL**********************************************
                if(playerList[i].getInJail() && !playerList[i].getJailCard())
                {
                    playerList[i].SetinJail(false);
                    uiController.getGUI().showMessage(playerList[i].getName() + currentLang[20]);
                    playerList[i].setMoney(+-1);
                    uiController.getGuiPlayer(i).setBalance(playerList[i].getMoney());
                    //break;
                } else if(playerList[i].getInJail() && playerList[i].getJailCard())
                {
                    playerList[i].setJailCard(false);
                    playerList[i].SetinJail(false);
                    uiController.getGUI().showMessage(playerList[i].getName() + currentLang[21]);
                }//*********************************************JAIL**********************************************

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

                }
                //Part 1 of landOnField test see part 2
                System.out.println(playerList[i].getName() + " before landing on field: " + playerList[i].getMoney());

                //**********************checks is player is on a chancefield if so he draws a card**********************
                if(myFields[playerList[i].getPosition()] instanceof FieldChance){
                    boolean draw = true;
                    //Loop that draws cards until the last drawn card has drawAgain == false
                    while(draw) {
                        uiController.getGUI().displayChanceCard(fieldChance.getCards().getLast().getCardText());
                        fieldChance.takeChanceCard(playerList, i, myFields, uiController.getGuiInput(fieldChance.nextCard()));
                        draw = fieldChance.getCards().atIndex(0).getDrawAgain();
                    }
                } else if(myFields[playerList[i].getPosition()] instanceof Properties){
                        ((Properties) myFields[playerList[i].getPosition()]).landOnField(playerList,i, myFields);
                } else{
                    myFields[playerList[i].getPosition()].landOnField(playerList, i);
                } //****************************************************************************************************

                //here we update the player position again to make sure it's correct if a chancecard has been used
                uiController.updateGUIPlayerPos(playerList[i],playerList[i].getOldposition(), playerList[i].getPosition());
                //Checks if player lands on Property and updates GUI with owner
                if(myFields[playerList[i].getPosition()] instanceof Properties) { uiController.updateGUIFieldOwner(playerList, myFields, playerList[i].getPosition()); }

                //Part 2 of landOnField test
                System.out.println(playerList[i].getName() + " after landing on field: " + playerList[i].getMoney());

                //we use set balance here to update the gui
                uiController.getGuiPlayer(i).setBalance(playerList[i].getMoney());
            }
        }

        //*********************************************Restart game?!!**************************************************
        if(uiController.getGUI().getUserLeftButtonPressed(currentLang[16], currentLang[17], currentLang[18])){
            uiController.getGUI().close();
            Game();
        } else uiController.getGUI().close();
        //*********************************************Restart game?!!**************************************************
    }
}
