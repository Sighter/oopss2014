package oop.ue04;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

public class MainController {
    
    /////////////////////////////// PUBLIC ///////////////////////////////////////
    
    public static void main(String[] args) {

        MainController mc = new MainController();

        mc.runOnce();
        
    }

    /* ============================ LIFECYCLE ================================= */

    /**
     * constructor
     */
    public MainController() {
        this.inputScanner = new Scanner(System.in);
    }

    /* ============================ OPERATIONS ================================ */

    /**
     * run the main maze programm, this asks the user to put in a new filepath to read
     * a maze from
     */
    public void runOnce() {

        String path;

        System.out.println("\nWilkommen\n");
        path = this.askForMazeFilePath();

        try {
            NodeReader reader = new NodeReader(path);
            ArrayList<Node> nodelist = reader.read();
        } catch (FileNotFoundException e) {
            System.err.println("Datei nicht gefunden: " + e.getMessage());
            return;
        } catch (IOException e) {
            System.err.println("IOException ist aufgetreten: " + e.getMessage());
            return;
        }
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