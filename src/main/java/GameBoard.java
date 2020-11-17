import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* !!!TANKER!!!
- FIX SÅ PROGRAMMET IKKE STOPPER VED FOR STOR INT I NUMBEROFPLAYERS
- DET SAMME KAN GØRES FOR STRING
- SKAL GUI REFERERER OG KØRES HERFRA?
- PLAYER.HASTURN???
- MÅSKE PLAYER SKAL HAVE EN GUI_PLAYER OBJECT I SIG FOR AT NEMMERE TILGÅ DEM?
- BENYT MARTINS ARRAYLISTE!
*/

public class GameBoard {
    static void Game() {
        int endGame = 0;
        int numberOfPlayers;
        Scanner scanner = new Scanner(System.in);
        List<Player> playerList = new ArrayList<>();
        Die die = new Die(1); // One die is instantiated with new Dice(int X);
        GUI gui = new GUI();
        Arraylist <GUI_Player> GuiPlayerArr = new Arraylist<>();
        GUI_Field field = gui.getFields()[0];


        //System.out.println("Please enter the number of players ranging from 2-4: ");
        //numberOfPlayers = scanner.nextInt();
        numberOfPlayers = gui.getUserInteger("Enter the number of players ranging from 2-4");
        while (numberOfPlayers > 4 || numberOfPlayers < 2) {
            //System.out.println("Please try again in the range of 2-4: ");
            gui.showMessage("Please try again in the range of 2-4");
            //numberOfPlayers = scanner.nextInt();
            numberOfPlayers = gui.getUserInteger("Please enter the number of players ranging from 2-4");
        }
        // Create player objects as per the playerdefined numberOfPlayers int
        for (int i = 1; i < numberOfPlayers + 1; i++) {
            //System.out.println("Please enter player " + i + "'s name: ");
            //Player player = new Player(scanner.next(), i); old code :)
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
        //printout playernames test
         /*for (Player player:
                 playerList) {
             System.out.println(player.getName());
         }*/

        //Initialize and Add players to gui
        for (Player player :
                playerList) {
            GUI_Player guiplayerx = new GUI_Player(player.getName(), player.wallet.getMoney());
            GuiPlayerArr.add(guiplayerx);
            gui.addPlayer(guiplayerx);
            field.setCar(guiplayerx, true);
        }
        /*for (GUI_Player guiplayerx :
                GuiPlayerArr) {
            //GUI_Player guiplayerx = new GUI_Player(player.getName(), player.wallet.getMoney());
            //GuiPlayerArr.add(guiplayerx);
            gui.addPlayer(guiplayerx);
        }*/
        System.out.println(playerList.size());
        //System.out.println(gui.);
        //Sets player 1 hasTurn variable to turn so that the game can start
        //playerList.get(0).setHasTurn(true);

        while (true) {
            // for loop which counts and loops thru the amount of players
            for (int i = 0; i < playerList.size(); i++) {
                //test
                //System.out.println("Player " + playerList.get(i) + " has the dice in his court");

                //if statement which checks if the current player has the boolean hasTurn set to true.
                //if (playerList.get(i).hasTurn) {
                    System.out.println();
                    System.out.println(playerList.get(i).getName() + " has the dice in his court");
                    System.out.println("Enter 'throw' to roll");

                    //Scanner to read the next user input
                    String ready = gui.getUserButtonPressed("Press button to roll the die", "Roll");

                    // if statement to check if the user typed in throw
                    if (ready.equals("Roll")) {
                        // function in Dice which rolls the dice
                            // add the dice value to the players points
                            gui.setDie(die.rollDie());
                            //playerList.get(i).wallet.setMoney((+die.getFaceValue()));

                            // !!!!DETTE VIRKER IKKE I ØJEBLIKKET!!!!
                            // gets player position/field and removes the car from the current field
                            field = gui.getFields()[playerList.get(i).getPosition()];
                            field.setCar(GuiPlayerArr.atIndex(i), false);
                            playerList.get(i).setPosition(+die.getFaceValue());
                            // gets player position/field and adds the car to the current field
                            field = gui.getFields()[playerList.get(i).getPosition()];
                            field.setCar(GuiPlayerArr.atIndex(i), true);
                            // !!!!DETTE VIRKER IKKE I ØJEBLIKKET!!!!


                            if (playerList.get(i).wallet.getMoney() <= endGame)
                            {
                                System.out.println("Rolls: " + die.getFaceValue());
                                System.out.println(playerList.get(i).getName() + " has reached " +endGame);
                            }
                            else {
                                System.out.println("Rolls: " + die.getFaceValue());
                                System.out.println(playerList.get(i).getName() + " now has " + playerList.get(i).wallet.getMoney() + " M!");
                            }


                        // VIP SKIFT TUR BURDE VIRKE???
                        if(playerList.get(i).getHasTurn(true)) {
                            if(playerList.indexOf(playerList.get(i)) == playerList.size()) {
                                playerList.get(i).setHasTurn(false);
                                playerList.get(0).setHasTurn(true);
                            } else {
                                playerList.get(i).setHasTurn(false);
                                playerList.get(i+1).setHasTurn(true);
                            }
                        }
                    }
                }
            }
        }
        //scanner.close();
    }
