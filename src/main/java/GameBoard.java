import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameBoard {

    public static void Game() {
        int MinCash = 0;
        int numberOfPlayers;
        Scanner scanner = new Scanner(System.in);
        List<Player> playerList = new ArrayList<>();
        //Dice d1 = new Dice(1); // One die is instantiated with new Dice(int X);

        System.out.println("Please enter the number of players ranging from 2-4: ");
        numberOfPlayers = scanner.nextInt();
        while(numberOfPlayers > 4|| numberOfPlayers < 2) {
                    System.out.println("Please try again in the range of 2-4: ");
                    numberOfPlayers = scanner.nextInt();
        }
        // Create player objects as per numberOfPlayers int
        for(int i = 1; i < numberOfPlayers+1; i++){
            System.out.println("Please enter player " + i + "'s name: ");
            Player player = new Player(scanner.next(),i);
            playerList.add(player);
        }

        /*Printout playernames test
        for (Player player:
             playerList) {
            System.out.println(player.name);
        }*/

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
                            // sets the hasTurn boolean to false ending the turn.
                            if (playerList.get(0).hasTurn) {
                                playerList.get(1).setHasTurn(true);
                                playerList.get(0).setHasTurn(false);
                            } else if (playerList.get(1).hasTurn) {
                                playerList.get(2).setHasTurn(true);
                                playerList.get(1).setHasTurn(false);
                            } else if (playerList.get(2).hasTurn) {
                                playerList.get(3).setHasTurn(true);
                                playerList.get(2).setHasTurn(false);
                            } else if (playerList.get(3).hasTurn) {
                                playerList.get(0).setHasTurn(true);
                                playerList.get(3).setHasTurn(false);
                            }
                    }
                }
            }
        }*/
    }
}
