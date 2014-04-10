
import Tools.IO.*;
import java.io.*;

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

        System.out.println("Sie haben ein neues Kimspiel gestartet.");
        
        this.game = new KimSpiel();

        int number = this.game.getNextNumber();
        int digits = this.game.getDigits();

        System.out.println("Merken sie sich folgende " + digits +"-stellige Nummer: " + number);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }
        for (int i = 0; i < 200; ++i) System.out.println();
        System.out.println("Bitte geben sie jetzt die Zahl ein");
        
        

        return true;
    }

    public void loopPlay() {

    }
    
    private void showNumber(int number) {

    }
    
    private boolean readNumber() {

        return true;

    }
}