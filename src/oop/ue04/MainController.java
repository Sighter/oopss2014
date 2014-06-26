package oop.ue04;

import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

public class MainController {
    
    /////////////////////////////// PUBLIC ///////////////////////////////////////
    
    public static void main(String[] args) {
        //Scanner staticScanner = new Scanner("test1.mace\n");
        //Scanner staticScanner = new Scanner("altjesnitz-1994.mace\n");
        //Scanner staticScanner = new Scanner("altjesnitz-1845.mace\n");
        
        MainController mc = new MainController();
        //mc.setInputScanner(System.in);

        mc.runOnce();
    }

    /* ============================ LIFECYCLE ================================= */

    /**
     * constructor
     */
    public MainController() {
        this.inputScanner = null;

    }

    /* ============================ DEPENDENCIES ============================== */

    public Scanner getInputScanner() {
        if (this.inputScanner == null) {
            this.inputScanner = new Scanner(System.in);
            return this.inputScanner;
        } else
            return this.inputScanner;
    }
    
    public MainController setInputScanner(Scanner v) { this.inputScanner = v; return this; }


    /* ============================ OPERATIONS ================================ */

    /**
     * run the main maze programm, this asks the user to put in a new filepath to read
     * a maze from
     */
    public void runOnce() {

        String path;
        ArrayList<Node> nodelist;

        System.out.println("\nWilkommen\n");
        path = this.askForMazeFilePath();

        try {
            NodeReader reader = new NodeReader(path);
            nodelist = reader.read();
        } catch (FileNotFoundException e) {
            System.err.println("Datei nicht gefunden: " + e.getMessage());
            return;
        } catch (IOException e) {
            System.err.println("IOException ist aufgetreten: " + e.getMessage());
            return;
        }

        /* make a new maze and calculate best way */

        System.out.println("Folgende Wege wurden gefunden");

        Node startNode = nodelist.get(0);
        Node targetNode = nodelist.get(nodelist.size() - 1);
        Maze maze = new Maze(nodelist, startNode, targetNode);
        List<Way> waylist = maze.findAllWays();

        /* print it */
        
        int wayCount = 1;
        for (Way w: waylist) {
            System.out.print("Weg " + wayCount +" => ");
            int nodeCount = 0;
            for (Node n: w.getStack()) {
                nodeCount++;
                System.out.print(n.getId());
                if (nodeCount < w.getStack().size())
                    System.out.print(" -> ");
            }
            System.out.println();
            wayCount++;
        }

    }
    
    /////////////////////////////// PRIVATE //////////////////////////////////////
    
    private Scanner inputScanner;

    private String askForMazeFilePath() {
        while (true) {
            try {
                System.out.print("Bitte geben sie des Einzulesenden Labyrinths an: > ");
                String line = this.getInputScanner().nextLine();
                return line;
            } catch (InputMismatchException e) {
            }
        }
    }
}