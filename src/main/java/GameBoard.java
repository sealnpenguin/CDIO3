import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameBoard {

    public static void Game() {
        int MinCash = 0;
        Scanner scanner = new Scanner(System.in);
        List<Player> playerList = new ArrayList<>();

        int numberOfPlayers = scanner.nextInt();
        for(int i = 0; i < numberOfPlayers; i++){
            Player player = new Player(scanner.next(),i);
            playerList.add(player);
        }
        System.out.println(playerList);
        //creates x new players from the players class
        /*System.out.println("Player 1 please enter name: ");
        Player Player_1 = new Player(scanner.next(),1);
        System.out.println("Player 2 please enter name: ");
        Player Player_2 = new Player(scanner.next(),2);
        //creates 2 new dice from the Dice class
        Dice d1 = new Dice(1); // One die is instantiated with new Dice(int X);
        //Array list containing all the players.
        //Adds the players to the arraylist
        playerList.add(Player_1);
        playerList.add(Player_2);


        //Sets player 1 hasTurn variable to turn so that the game can start
        playerList.get(0).setHasTurn(true);

        while (true) {
            // for loop which counts and loops thru the amount of players
            for (int i = 0; i < playerList.toArray().length; i++) {
                //test
                //System.out.println("Player " + playerList.get(i) + " has the dice in his court");

                //if statement which checks if the current player has the boolean hasTurn set to true.
                if (playerList.get(i).hasTurn) {
                    System.out.println();
                    System.out.println(playerList.get(i).Name + " has the dice in his court");
                    System.out.println("Enter 'throw' to roll");

                    //Scanner to read the next user input
                    String ready = scanner.next();

                    // if statement to check if the user typed in throw
                    if (ready.equals("throw")) {
                        // function in Dice which rolls the dice
                            // add the dice value to the players points
                            playerList.get(i).setPoint(+d1.rollDice());
                            if (playerList.get(i).getPoint() <= MinCash)
                            {
                                System.out.println("Rolls: " + d1.getFaceValue());
                                System.out.println(playerList.get(i).Name + " has reached " +MinCash);
                            }
                            else {
                                System.out.println("Rolls: " + d1.getFaceValue());
                                System.out.println(playerList.get(i).Name + " now has " + playerList.get(i).getPoint() + " points!");
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
