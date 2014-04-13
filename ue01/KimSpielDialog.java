
import Tools.IO.*;
import java.io.*;
import java.util.Arrays;


/**
 * class for incapsulating the cli-components of the KimSpiel
 * you can basicly play the game with this class
 */
public class KimSpielDialog {

    /**
     * main method of the class for the purpose of testing
     * @param args cli input arguments
     */
    public static void main(String[] args) {
        System.out.println("Testing run once");

        KimSpielDialog dialog = new KimSpielDialog();
        dialog.runOnce();
    }

    private KimSpiel game;

    /**
     * constructor
     * @return the object
     */
    public KimSpielDialog() {

    }

    /**
     * this method creates a new KimSpiel instance and guides
     * the player through the game
     * @return if the player has won true, otherwise false
     */
    public boolean runOnce() {

        this.game = new KimSpiel();
        int[] number = this.game.getNextNumber();
        int[] inputNumber = {};
        boolean inputFailed = true;

        System.out.println("Sie haben ein neues Kimspiel gestartet.");
        
        this.showNumber(number);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) { 
        }

        this.clearScreen();

        while(inputFailed) {
            try {
                inputNumber = this.readNumber(number.length);
                inputFailed = false;
            } catch (NumberFormatException e) {
                System.out.println("Die eingegebene Zahl hat ein ungültiges Format");
                inputFailed = true;
            }
        }
        
        if (this.game.validateLastNumber(inputNumber) == true) {
            System.out.println("Richtig");
            return true;
        } else {
            System.out.println("Falsch");
            return false;
        }
    }

    public void loopPlay() {
        // boolean playerWantsToPlayAgain = true;
        
        // while(playerWantsToPlayAgain) {

        //     boolean playerHasWon = this.runOnce();

        //     if (playerHasWon) 
        // }
    }
    
    /**
     * this method prints out the number on the screen
     * @param the number
     */
    private void showNumber(int [] number) {
         System.out.println("Merken sie sich folgende " + 
            number.length +"-stellige Nummer: " + this.getArrayAsString(number));
    }
    
    /**
     * this methods reads a number from the command line
     * and converts it into the right format
     * 
     * @param the maximum length in chars the method should read
     * @throws NumberFormatException Is thrown if the user enters non-digits
     * @return the array with the numbers in it
     */
    private int[] readNumber(int maxLength) {
        
        boolean inputCorrect = false;
        String input;
        int[] returnArray = new int[maxLength];

        input = IOTools.readString("Bitte geben sie jetzt die Zahl ein: ");
        
        for (int idx = 0; idx < input.length() && idx < maxLength; idx++) {
            String c;
            
            c = Character.toString(input.charAt(idx));    
                
            returnArray[idx] = Integer.parseInt(c);
        }

        return returnArray;
    }

    /**
     * clears the screen by shifting up 200 lines
     */
    private void clearScreen() {
        for (int i = 0; i < 200; ++i) System.out.println();
    }

    /**
     * joins an array together to a string representation
     * @param the array
     * @return the string
     */
    private String getArrayAsString(int[] array) {

        String joinedString = "";

        for (int index = 0; index < array.length; index++)
            joinedString += array[index];

        return joinedString;
    }
}