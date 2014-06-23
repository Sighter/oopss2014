package oop.ue04;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import oop.ue04.Node;

class NodeReader {
    
    /////////////////////////////// PUBLIC ///////////////////////////////////////
    
    public static void main(String[] args) throws FileNotFoundException {

        NodeReader r = new NodeReader("test1.mace");
        r.read();
        
    }
    
    /* ============================ LIFECYCLE ================================= */

    public NodeReader(String filePath) throws FileNotFoundException {

        this.fileReader= new BufferedReader(new FileReader(filePath));

    }
    
    /* ============================ ACCESS ==================================== */
    
    /* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -*/
    
    /* ============================ OPERATIONS ================================ */

    public ArrayList<Node> read() {

        ArrayList<Node> list = new ArrayList<Node>();
        Scanner parentScanner = new Scanner(this.fileReader);

        while (parentScanner.hasNext()) {

            Node n = new Node(this.readNextParentId(parentScanner));

            list.add(n);

            System.out.println("Read node " + n);
        }

        return list;
    }

    /* ============================ INQUIRY =================================== */
            
    /* ============================ OPERATORS ================================= */
    
    /////////////////////////////// PRIVATE //////////////////////////////////////
    
    private String filePath;
    private Scanner fileScanner;
    private BufferedReader fileReader;

    private int readNextParentId(Scanner s) {

        int id = s.nextInt();

        for (int idx = 0; idx < Node.NEIGHBOUR_COUNT; idx++) {
            s.nextInt();
        }

        return id;
    }

    private void linkNextChilds(Scanner s, ArrayList<Node> list, Node currentNode) {
        
    }
}