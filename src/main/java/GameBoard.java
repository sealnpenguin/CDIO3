import Fields.*;
import Player.Player;
import ViewLayer.UIController;

import java.awt.*;
import java.util.Arrays;

/*
//**************************************************!!!TANKER!!!********************************************************
- Optimer funktionen der tjekker om 2 brugere har samme navn???
- Property value int i player for at nemmere at kunne tjekke når der er en der vinder?
- Måske gør så man kan se hvem der betaler til hvem i.e. Jens Betaler 1M Til Mads for at blive natten over.
- Enten gør valget af sprog usynligt eller færdiggør det.
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
            if (i == 2) {
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
            }
            //Sets the players money according the rules
            switch (numberOfPlayers) {
                case 2 -> player.setMoney(20);
                case 3 -> player.setMoney(18);
                case 4 -> player.setMoney(16);
            }
            playerList[i - 1] = player;

        }
        //Adds playerfigure at end of playerName
        for (int i = 1; i < numberOfPlayers + 1; i++) {
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
        String[] choiceArr = Arrays.copyOfRange(currentLang, 4, 11);
        String[] temp;
        String color;
        for (int i = 0; i < playerList.length; i++) {
            color = uiController.getGUI().getUserSelection(uiController.getGuiPlayer(i).getName()+currentLang[3], choiceArr);
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
            temp = new String[choiceArr.length-1];
            int tempCount = 0;
            for (int j = 0; j < choiceArr.length; j++) {
                if(!choiceArr[j].equals(color)) {
                    temp[tempCount] = choiceArr[j];
                    tempCount++;
                }
            }
            choiceArr = temp;
            // we update GUIPLAYERPOS here to set player at start
            uiController.updateGUIPlayerPos(playerList[i],playerList[i].getOldposition(), playerList[i].getPosition());
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
                //************************************JAIL************************************
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
                }//***********************************JAIL************************************
                //Check for if player has a player specific card and gives them the choice
                //if(playerList[i].hasPlayerSpecificCard()){



                //}

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



                    //checks is player is on a chancefield if so he draws a card
                    if(myFields[playerList[i].getPosition()] instanceof FieldChance){
                        boolean draw = true;
                        //Loop that draws cards until the last drawn card has drawAgain == false
                        while(draw) {
                            uiController.getGUI().displayChanceCard(fieldChance.getCards().getLast().getCardText());
                            fieldChance.takeChanceCard(playerList, i, myFields, uiController.getGuiInput(fieldChance.nextCard()));
                            draw = fieldChance.getCards().atIndex(0).getDrawAgain();
                        }
                    }
                    else if(myFields[playerList[i].getPosition()] instanceof Properties){
                        ((Properties) myFields[playerList[i].getPosition()]).landOnField(playerList,i, myFields);
                    }
                    else{
                        myFields[playerList[i].getPosition()].landOnField(playerList, i);
                    }

                    //here we update the player position again to make sure it's correct if a chancecard has been used
                    uiController.updateGUIPlayerPos(playerList[i],playerList[i].getOldposition(), playerList[i].getPosition());
                    //Checks if player lands on Property and updates GUI with owner
                    if(myFields[playerList[i].getPosition()] instanceof Properties) {
                    uiController.updateGUIFieldOwner(playerList, myFields, playerList[i].getPosition());
                    //Mulige måder at holde styr på spiller-ejet felter?
                    //uiController.getGUI().getFields()[1].setBackGroundColor(Color.blue);
                    //uiController.getGUI().getFields()[1].setForeGroundColor(Color.blue);

                    //Part 2 of landOnField test
                    System.out.println(playerList[i].getName() + " after landing on field: " + playerList[i].getMoney());

                    //we use set balance here to update the gui
                    uiController.getGuiPlayer(i).setBalance(playerList[i].getMoney());
                }
            }
        }
        //****************************************Restart game?!!*******************************************
        if(uiController.getGUI().getUserLeftButtonPressed(currentLang[16], currentLang[17], currentLang[18])){
            uiController.getGUI().close();
            Game();
        } else uiController.getGUI().close();
        //****************************************Restart game?!!*******************************************
    }
    //Hvis player has PlayerSpecific card at start of turn this needs to run.
    public void playerSpecificCardChoice(int player){
        int numberOfFreeFields = 0;
        String[] chooseFieldArray;
        int[] fieldsToChose;
        //Counters number of fields with no owner
        for (int j = 0; j < myFields.length; j++) {
            if(myFields[j] instanceof Properties){
                if(((Properties) myFields[j]).getOwnedBy() == -1){
                    numberOfFreeFields++;
                }
            }
        }
        //Checks if any free Properties exist
        if(numberOfFreeFields > 0) {
            fieldsToChose = new int[numberOfFreeFields];
            chooseFieldArray = new String[numberOfFreeFields];
            int freeFieldCounter = 0;
            //Builds int array of all the indecies of Properties with no owner(Used to change player position)
            //Also builds String array(Used for output to screen so player can choose)
            for (int j = 0; j < myFields.length; j++) {
                if (myFields[j] instanceof Properties) {
                    if (((Properties) myFields[j]).getOwnedBy() == -1) {
                        fieldsToChose[freeFieldCounter] = j;
                        chooseFieldArray[freeFieldCounter] = myFields[j].getFieldName();
                    }
                }
            }
            String choiceString = "";
            int choiceInt = -1;
            //Makes choice based on Propety names
            choiceString = uiController.getGUI().getUserButtonPressed("Vælg et frit felt", chooseFieldArray);
            //Looks through fields to find index of chosen field
            for (int j = 0; j < myFields.length; j++) {
                if (choiceString.equals(myFields[j].getFieldName())) {
                    choiceInt = j;
                }
            }
            //Updates playerPosition to chosen field and gives the money so they get field for free
            playerList[player].setSpecificPosition(choiceInt);
            playerList[player].setMoney(((Properties)myFields[playerList[player].getPosition()]).getPrice());
        }
        else{
            String choiceString = "";
            int choiceInt = -1;
            int otherPlayersFields = 0;
            int fieldChoiceCounter = 0;
            for (int i = 0; i < myFields.length; i++) {
                if(myFields[i] instanceof Properties){
                    if(((Properties)myFields[i]).getOwnedBy() != player){
                        otherPlayersFields++;
                    }
                }
            }
            fieldsToChose = new int[otherPlayersFields];
            chooseFieldArray = new String[otherPlayersFields];
            for (int i = 0; i < myFields.length; i++) {
                if(myFields[i] instanceof Properties){
                    if(((Properties)myFields[i]).getOwnedBy() != player){
                        fieldsToChose[fieldChoiceCounter] = i;
                        chooseFieldArray[fieldChoiceCounter] = myFields[i].getFieldName();
                        fieldChoiceCounter++;
                    }
                }
            }
            choiceInt = -1;
            String choice = uiController.getGUI().getUserButtonPressed("Vælg en anden spillers felt og køb det af personen", chooseFieldArray);
            //Looks through fields to find index of chosen field
            for (int j = 0; j < myFields.length; j++) {
                if (choiceString.equals(myFields[j].getFieldName())) {
                    choiceInt = j;
                }
            }
            playerList[player].setPosition(choiceInt);
            playerList[player].setMoney(-((Properties)myFields[choiceInt]).getPrice());
            playerList[((Properties)myFields[choiceInt]).getOwnedBy()].setMoney(((Properties)myFields[choiceInt]).getPrice());
            ((Properties)myFields[choiceInt]).setOwnedBy(player);
        }

        ((Properties)myFields[playerList[player].getPosition()]).landOnField(playerList, player, myFields);
    }
}
