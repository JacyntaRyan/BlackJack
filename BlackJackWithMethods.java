
import java.util.Scanner;
import java.util.Random;

public class BlackJackWithMethods {

    public static void main(String[] args) {
        int i = 2;

        rules();
        int playerHand[] = assignCardsToPlayerOne();
        dealPlayerOne(playerHand);

        boolean stick = hitOrStick();

        if (stick == true) {
            int playerOneScore = playerOneScore(playerHand);
            System.out.println("your score is " + playerOneScore);
        } else {
            do {
                playerHand = hit(playerHand, i);
                i++;
                stick = hitOrStick();
            } while (stick == false);
            int playerOneScore = playerOneScore(playerHand);
            System.out.println("your score is " + playerOneScore);
        }
        //---------------player two------------------
        int playerHand2[] = assignCardsToPlayerTwo();
        dealPlayerTwo(playerHand2);
        stick = hitOrStick();
        if (stick == true) {
            int playerTwoScore = playerTwoScore(playerHand2);
            System.out.println("your score is " + playerTwoScore);
        } else {
            do {
                playerHand2 = hit(playerHand2, i);
                i++;
                stick = hitOrStick();
            } while (stick == false);
            int playerTwoScore = playerTwoScore(playerHand2);
            System.out.println("your score is " + playerTwoScore);
        }
        int player2Score = playerTwoScore(playerHand2);
        int player1Score = playerOneScore(playerHand);
        getWinner(player1Score, player2Score);

    }//endmain

    public static void rules() {
        System.out.println("The rules are:there are 2 players,\n if you get 21 you win if you go over 21 you are bust \n the person closest to 21 wins \n ace can be counted as 11 or 1 at anytime");
        System.out.println("\n LETS BEGIN!!");
    }

    public static int[] assignCardsToPlayerOne() {
        int playerHand[] = new int[10];
        Random rand = new Random();
        playerHand[0] = rand.nextInt(9) + 1;
        playerHand[1] = rand.nextInt(9) + 1;
        return playerHand;
    }

    public static void dealPlayerOne(int[] playerHand) {
        System.out.println("Player One");
        System.out.println("Your cards are");
        System.out.println(playerHand[0] + " " + playerHand[1]);
    }

    public static boolean hitOrStick() {
        boolean stick;
        Scanner scan = new Scanner(System.in);
        System.out.println("would u like to 1.stick or 2.hit ");
        int choice = scan.nextInt();
        if (choice == 1) {
            stick = true;
        } else {
            stick = false;
        }
        return stick;

    }

    public static boolean stick() {
        boolean stick = true;
        return stick;
    }

    public static int[] hit(int[] playerHand, int x) {
        int i = x;
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        int ace = 11;
        playerHand[i] = rand.nextInt(9) + 1;
        if (playerHand[i] == 1) {
            System.out.println("You have an ace would you like to set it as 1.Ace or 2.One? ");
            int userChoice = scan.nextInt();
            if (userChoice == 1) {
                playerHand[i] = ace;
                System.out.println("your new card is: " + playerHand[i]);
            }
        }//end if
        else {
            System.out.println("your new card is: " + playerHand[i]);
        }

        return playerHand;
    }

    public static int playerOneScore(int[] playerHand) {
        Scanner scan = new Scanner(System.in);
        int ace = 11;
        int player1 = 0;
        for (int index = 0; index < playerHand.length; index++) {
            if (playerHand[index] == 1) {
                System.out.println("Before you stick would you like to change your Ace to 1.Ace or 2.One? ");
                int userChoice = scan.nextInt();
                if (userChoice == 1) {
                    playerHand[index] = ace;
                }
            }//endif

            player1 = player1 + playerHand[index];
        }//end for
        return player1;
    }
    //------------------player two============================

    public static int[] assignCardsToPlayerTwo() {
        int playerHand2[] = new int[10];
        Random rand = new Random();
        playerHand2[0] = rand.nextInt(9) + 1;
        playerHand2[1] = rand.nextInt(9) + 1;
        return playerHand2;
    }

    public static void dealPlayerTwo(int[] playerHand2) {
        System.out.println("Player Two");
        System.out.println("Your cards are");
        System.out.println(playerHand2[0] + " " + playerHand2[1]);
    }

    public static int playerTwoScore(int[] playerHand2) {
        Scanner scan = new Scanner(System.in);
        int ace = 11;
        int player2 = 0;
        for (int index = 0; index < playerHand2.length; index++) {
            if (playerHand2[index] == 1) {
                System.out.println("Before you stick would you like to change your Ace to 1.Ace or 2.One? ");
                int userChoice = scan.nextInt();
                if (userChoice == 1) {
                    playerHand2[index] = ace;
                }
            }//endif

            player2 = player2 + playerHand2[index];
        }//end for
        return player2;
    }

    public static void getWinner(int player1, int player2) {

        System.out.println("Player One has " + player1 + " Player Two has " + player2);

        if (player1 > 21) {
            System.out.println("\nplayer Two wins");
        } else if (player2 > 21) {
            System.out.println("\nplayer One wins");
        } else if (player1 > player2) {
            System.out.println("player One wins");
        } else if (player1 < player2) {
            System.out.println("\nplayer Two wins");
        } else {
            System.out.println("draw");
        }

    }
}//end
