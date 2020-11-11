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
- WALLET FÅ STYR PÅ VARIABLER BRUGT
*/

public class GameBoard {
     static void Game() {
        int MinCash_EndGame = 0;
        int numberOfPlayers;
        Scanner scanner = new Scanner(System.in);
        List<Player> playerList = new ArrayList<>();
        //Dice d1 = new Dice(1); // One die is instantiated with new Dice(int X);
        GUI gui = new GUI();



        //System.out.println("Please enter the number of players ranging from 2-4: ");
        //numberOfPlayers = scanner.nextInt();
        numberOfPlayers = gui.getUserInteger("Enter the number of players ranging from 2-4");
        while(numberOfPlayers > 4|| numberOfPlayers < 2) {
            //System.out.println("Please try again in the range of 2-4: ");
            gui.showMessage("Please try again in the range of 2-4");
            //numberOfPlayers = scanner.nextInt();
            numberOfPlayers = gui.getUserInteger("Please enter the number of players ranging from 2-4");
        }
        // Create player objects as per the playerdefined numberOfPlayers int
        for(int i = 1; i < numberOfPlayers+1; i++){
            //System.out.println("Please enter player " + i + "'s name: ");
            //Player player = new Player(scanner.next(), i); old code :)
            Player player = new Player(gui.getUserString("Enter name for player " + i),i);
            /* Sets the players money according the rules
            switch(numberOfPlayers) {
                case 2:
                    player.Wallet.SetMoney(20);
                    break;
                case 3:
                    player.Wallet.SetMoney(18);
                    break;
                case 4:
                    player.Wallet.SetMoney(16);
                    break;
            }*/
            playerList.add(player);
        }
         //printout playernames test
         for (Player player:
                 playerList) {
             System.out.println(player.name);
         }

        //printout playernames test
        for (Player player:
             playerList) {
            GUI_Player guiplayerx = new GUI_Player(player.name, 2000);
            gui.addPlayer(guiplayerx);
        }


        //Sets player 1 hasTurn variable to turn so that the game can start
        /*playerList.get(0).setHasTurn(true);

        while (true) {
            // for loop which counts and loops thru the amount of players
            for (int i = 0; i < playerList.size(); i++) {
                //test
                //System.out.println("Player " + playerList.get(i) + " has the dice in his court");

                //if statement which checks if the current player has the boolean hasTurn set to true.
                if (playerList.get(i).hasTurn) {
                    System.out.println();
                    System.out.println(playerList.get(i).name + " has the dice in his court");
                    System.out.println("Enter 'throw' to roll");

                    //Scanner to read the next user input
                    String ready = scanner.next();

                    // if statement to check if the user typed in throw
                    if (ready.equals("throw")) {
                        // function in Dice which rolls the dice
                            // add the dice value to the players points
                            playerList.get(i).Wallet.Money(+d1.rollDice());
                            if (playerList.get(i).Wallet.getMoney() <= MinCash)
                            {
                                System.out.println("Rolls: " + d1.getFaceValue());
                                System.out.println(playerList.get(i).name + " has reached " +MinCash);
                            }
                            else {
                                System.out.println("Rolls: " + d1.getFaceValue());
                                System.out.println(playerList.get(i).name + " now has " + playerList.get(i).Wallet.getMoney() + " M!");
                            }


                            // VIP SKIFT TUR BURDE VIRKE???
                            if(playerList.get(i).hasTurn) {
                                if(playerList.get(i) == playerList.Size()) {
                                    playerList.get(i).setHasTurn(false)
                                    playerList.get(0).setHasTurn(True)
                                } else {
                                    playerList.get(i).setHasTurn(false)
                                    playerList.get(i+1).setHasTurn(true)
                                }
                            }

                    }
                }
            }
        }*/
         scanner.close();
    }
}
