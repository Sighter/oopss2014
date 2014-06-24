package oop.ue04;

import java.util.InputMismatchException;
import java.util.Scanner;

class MainController {
    
    /////////////////////////////// PUBLIC ///////////////////////////////////////
    
    public static void main(String[] args) {

        MainController mc = new MainController();

        mc.runOnce();
        
    }

    /* ============================ LIFECYCLE ================================= */

    public MainController() {
        this.inputScanner = new Scanner(System.in);
    }

    /* ============================ OPERATIONS ================================ */

    public void runOnce() {

        String path;

        System.out.println("\nWilkommen\n");
        path = this.askForMazeFilePath();

    }
    
    /////////////////////////////// PRIVATE //////////////////////////////////////
    
    private Scanner inputScanner;

    private String askForMazeFilePath() {
        while (true) {
            try {
                System.out.print("Bitte geben sie des Einzulesenden Labyrinths an: > ");
                String line = this.inputScanner.nextLine();
                return line;
            } catch (InputMismatchException e) {
            }
        }
    }
}