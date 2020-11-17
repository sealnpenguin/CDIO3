import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

import java.util.ArrayList;
import java.util.List;

/* !!!TANKER!!!
- FIX SÅ PROGRAMMET IKKE STOPPER VED FOR STOR INT I NUMBEROFPLAYERS
- DET SAMME KAN GØRES FOR STRING
- SKAL GUI REFERERER OG KØRES HERFRA? - RET NÅR JAN HAR OPSAT GUI
- PLAYER.HASTURN? - HAR INDSAT EVENTUELT BRUG ANDEN LØSNING????
- MÅSKE PLAYER SKAL HAVE EN GUI_PLAYER OBJECT I SIG FOR AT NEMMERE TILGÅ DEM?
- BENYT MARTINS ARRAYLISTE!
*/

public class GameBoard {
    static void Game() {
        int endGame = 0;
        //int numberOfPlayers;
        List<Player> playerList = new ArrayList<>();
        Die die = new Die(1); // One die is instantiated with new Dice(int X);
        GUI gui = new GUI();
        Arraylist <GUI_Player> GuiPlayerArr = new Arraylist<>();
        GUI_Field field = gui.getFields()[0];



        int numberOfPlayers = gui.getUserInteger("Enter the number of players ranging from 2-4");
        while (numberOfPlayers > 4 || numberOfPlayers < 2) {
            gui.showMessage("Please try again in the range of 2-4");
            numberOfPlayers = gui.getUserInteger("Please enter the number of players ranging from 2-4");
        }
        // Create player objects as per the playerdefined numberOfPlayers int.
        for (int i = 1; i < numberOfPlayers + 1; i++) {
            Player player = new Player(gui.getUserString("Enter name for player " + i));
            //Sets the players money according the rules
            switch (numberOfPlayers) {
                case 2:
                    player.wallet.setMoney(20);
                    break;
                case 3:
                    player.wallet.setMoney(18);
                    break;
                case 4:
                    player.wallet.setMoney(16);
                    break;
            }
            playerList.add(player);
        }

        //Initialize and Add players to gui
        for (Player player : playerList) {
            GUI_Player guiplayerx = new GUI_Player(player.getName(), player.wallet.getMoney());
            GuiPlayerArr.add(guiplayerx);
            gui.addPlayer(guiplayerx);
            field.setCar(guiplayerx, true);
        }

        //Tanke.. GUI_Player array??
        /*for (GUI_Player guiplayerx : GuiPlayerArr) {
            //GUI_Player guiplayerx = new GUI_Player(player.getName(), player.wallet.getMoney());
            //GuiPlayerArr.add(guiplayerx);
            gui.addPlayer(guiplayerx);
        }*/


        while (true) {
            // for loop which counts and loops thru the amount of players
            for (int i = 0; i < playerList.size(); i++) {
                //Maybe use showmessage to make sure the correct player rolls?
                //gui.showMessage(playerList.get(i).getName() + " has the die in his court");

                //Guibutton to read the next user input
                String ready = gui.getUserButtonPressed(playerList.get(i).getName() + " press button to roll the die!", "Roll");
                // if statement to check if the user typed in throw
                if (ready.equals("Roll")) {
                    // function in Dice which rolls the dice
                    // add the dice value to the players points
                    gui.setDie(die.rollDie());
                    //playerList.get(i).wallet.setMoney((+die.getFaceValue()));

                    // !!!!VIRKER, MEN OPTIMATION?!!!!
                    // gets player position/field and removes the car from the current field
                    field = gui.getFields()[playerList.get(i).getPosition()];
                    field.setCar(GuiPlayerArr.atIndex(i), false);
                    playerList.get(i).setPosition(+die.getFaceValue());

                    // gets player position/field and adds the car to the current field
                    field = gui.getFields()[playerList.get(i).getPosition()];
                    field.setCar(GuiPlayerArr.atIndex(i), true);

                    //!!!Skal ændres!!!
                    if (playerList.get(i).wallet.getMoney() <= endGame)
                    {
                        System.out.println("Rolls: " + die.getFaceValue());
                        System.out.println(playerList.get(i).getName() + " has reached " +endGame);
                    }
                    else {
                        System.out.println("Rolls: " + die.getFaceValue());
                        System.out.println(playerList.get(i).getName() + " now has " + playerList.get(i).wallet.getMoney() + " M!");
                    }
                }
            }
        }
    }
}
