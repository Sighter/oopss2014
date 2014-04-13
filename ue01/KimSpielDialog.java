
import Tools.IO.*;
import java.io.*;
import java.util.Arrays;

public class KimSpielDialog {

    public static void main(String[] args) {
        System.out.println("Testing run once");

        KimSpielDialog dialog = new KimSpielDialog();
        dialog.runOnce();
    }

    private KimSpiel game;

    /**
     * constructor
     * @return [description]
     */
    public KimSpielDialog() {

    }

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
    
    private void showNumber(int [] number) {
         System.out.println("Merken sie sich folgende " + 
            number.length +"-stellige Nummer: " + this.getArrayAsString(number));
    }
    
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

    private void clearScreen() {
        for (int i = 0; i < 200; ++i) System.out.println();
    }

    private String getArrayAsString(int[] array) {

        String joinedString = "";

        for (int index = 0; index < array.length; index++)
            joinedString += array[index];

        return joinedString;
    }
}