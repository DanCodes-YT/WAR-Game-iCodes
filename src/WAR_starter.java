import java.util.Random;
import java.util.Scanner;

public class WAR_starter {
    public static void main(String[] args) {
        String info = "\nPlay round: 1\nQuit: 2\n\nChoose your input: ";

        Scanner myScanner = new Scanner(System.in);
        boolean playing = true;

        while (playing) {
            System.out.print(info);
            
            int input = getInput(myScanner);

            switch (input) {
                case 1:
                    playRound();
                    break;
                
                case 2:
                    playing = false;
                    break;
                
                case 0:
                default:
                    System.out.println("That is not a valid input!");
                    break;
            }


        }

        myScanner.close();
    }

    public static int getInput(Scanner scanner) {
        int input = scanner.nextInt();

        return input;
    }

    public static void playRound() {
        // Generation of 2 random cards (1-52)
        Random rand = new Random();
        int computerCARDNUM = rand.nextInt(52);
        int userCARDNUM = rand.nextInt(52); 

        if (computerCARDNUM == 0) {
            computerCARDNUM += 1;
        }
        if (userCARDNUM == 0) {
            userCARDNUM += 1;
        }

        String computerCARD = calculateSuit(computerCARDNUM) + calculateType(computerCARDNUM);
        String userCARD = calculateSuit(userCARDNUM) + calculateType(userCARDNUM);
        String winnerText = "";

        //YOUR CODE GOES HERE
        if (computerCARDNUM == userCARDNUM) {
            winnerText = "WAR!";
        } else if (computerCARDNUM > userCARDNUM) {
            winnerText = "Computer wins!";
        } else {
            winnerText = "Player wins!";
        }
        //

        // Final send of 2 cards value (suit + value) to be outputted as ASCII cards
        printAsciiEval(computerCARD, userCARD);

        String bar = "";

        for (int i = 0; i < winnerText.length(); i++) {
            bar += "-";
        }

        System.out.println();
        System.out.println(bar);
        System.out.println(winnerText);
        System.out.println(bar);
    }

    public static void printAsciiEval(String computerCard, String userCard) {
        if (computerCard.length() == 2) {
            printAscii_2Char_card(computerCard);
        } else {
            printAscii_3Char_card(computerCard);
        }

        System.out.println("------------");
        System.out.println("--COMPUTER--");
        System.out.println("------------");
        System.out.println("-----VS-----");
        System.out.println("------------");
        System.out.println("----USER----");
        System.out.println("------------");

        if (userCard.length() == 2) {
            printAscii_2Char_card(userCard);
        } else {
            printAscii_3Char_card(userCard);
        }
    }

    public static void printAscii_2Char_card(String card){
        // Top of the computer card
        System.out.println("┌─────────┐");
        // Upper part of the card with the character
        System.out.println("│" + card + "       │"); // top-left corner of the card
        System.out.println("│         │");
        System.out.println("│         │");
        System.out.println("│    " + card + "   │"); // middle of the card
        System.out.println("│         │");
        System.out.println("│         │");
        // Bottom part of the card with the character mirrored
        System.out.println("│       " + card + "│"); // bottom-right corner of the card
        // Bottom of the card
        System.out.println("└─────────┘");
    }

    public static void printAscii_3Char_card(String card){
        // Top of the computer card
        System.out.println("┌──────────┐");
        // Upper part of the card with the character
        System.out.println("│" + card + "       │"); // top-left corner of the card
        System.out.println("│          │");
        System.out.println("│          │");
        System.out.println("│    " + card + "   │"); // middle of the card
        System.out.println("│          │");
        System.out.println("│          │");
        // Bottom part of the card with the character mirrored
        System.out.println("│       " + card + "│"); // bottom-right corner of the card
        // Bottom of the card
        System.out.println("└──────────┘");
    }

    private static char calculateSuit(int cardNumber) {
        char prefix = ' ';

        if (cardNumber <= 13) {
            prefix = 'C';
        } else if (cardNumber <= 26) {
            prefix = 'D';
        } else if (cardNumber <= 39) {
            prefix = 'H';
        } else {
            prefix = 'S';
        }

        return prefix;
    }

    private static String calculateType(int cardNumber) {
        String cardType = "";

        cardNumber = cardNumber % 13;
        
        switch (cardNumber) {
            case 0:
                cardType = "K";
                break;

            case 12:
                cardType = "Q";
                break;

            case 11:
                cardType = "J";
                break;
        
            default:
                cardType = Integer.toString(cardNumber);
                break;
        }

        return cardType;
    }
}
