package oop.ue04;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import oop.ue04.Node;

public class NodeReader {
    
    /////////////////////////////// PUBLIC ///////////////////////////////////////
    
    public static void main(String[] args) throws FileNotFoundException, IOException {

        NodeReader r = new NodeReader("test2.mace");
        ArrayList<Node> l = r.read();

        System.out.println("Read test1.mace");
        System.out.println("Size now at " + l.size());

        
    }

    /* ============================ LIFECYCLE ================================= */

    public NodeReader(String filePath) throws FileNotFoundException {

        this.filePath = filePath;

    }
    
    /* ============================ ACCESS ==================================== */
    
    /* ============================ OPERATIONS ================================ */

    /**
     * method which returns a list of nodes read from a file
     *
     * the file must contain a 5xn matrix which describes the releationships
     * in the maze graph. All nodes are identified by a key. First row in the matrix
     * describes all existent nodes in the mace. On each line all remaining numbers are
     * reference keys to the other nodes wich are connected to the first one.
     * Basicly its like a relational table.
     *
     * 
     * @return The list with nodes
     * @throws IOException
     */
    public ArrayList<Node> read() throws IOException {

        ArrayList<Node> list = new ArrayList<Node>();
        BufferedReader parentReader = new BufferedReader(new FileReader(filePath));
        BufferedReader childReader = null;
        Scanner parentScanner = new Scanner(parentReader);
        Scanner childScanner = null;


        while (parentScanner.hasNext()) {

            Node n = new Node(this.readNextParentId(parentScanner));

            list.add(n);

            //System.out.println("Read node " + n);
        }

        parentReader.close();

        childReader = new BufferedReader(new FileReader(filePath));
        childScanner = new Scanner(childReader);

        while (childScanner.hasNext()) {

            this.linkNextChilds(childScanner, list);
        }

        childReader.close();

        return list;
    }

    /* ============================ INQUIRY =================================== */
            
    /* ============================ OPERATORS ================================= */
    
    /////////////////////////////// PRIVATE //////////////////////////////////////
    
    private String filePath;

    private int readNextParentId(Scanner s) {

        int id = s.nextInt();

        for (int idx = 0; idx < Node.NEIGHBOUR_COUNT; idx++) {
            s.nextInt();
        }

        return id;
    }

    /* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -*/

    private void linkNextChilds(Scanner s, ArrayList<Node> list) {

        int id = s.nextInt();
        Node n = list.get(id - 1);

        for (int idx = 0; idx < Node.NEIGHBOUR_COUNT; idx++) {
            int childId = s.nextInt();
            
            if (childId == 0)
                continue;
            
            Node child = list.get(childId - 1);
            n.getNeighbours().set(idx ,child);
        }

        //System.out.println("Linked childs for: " + n);

    }
}