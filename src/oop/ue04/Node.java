package oop.ue04;

import java.util.ArrayList;

class Node {

    /////////////////////////////// PUBLIC ///////////////////////////////////////
    
    public static void main(String[] args) {

        ArrayList<Integer> test = new ArrayList<Integer>();

        System.out.println(test);
        
    }
    
    /* ============================ LIFECYCLE ================================= */

    public Node(int id) {
        this.setId(id);
        this.neighbours = new ArrayList<Node>();
    }
    
    /* ============================ ACCESS ==================================== */

    public int getId() { return this.id; }
    
    public Node setId(int v) { this.id = v; return this; }

    public ArrayList<Node> getNeighbours() { return this.neighbours; }
    
    /* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -*/
    
    /* ============================ OPERATIONS ================================ */
    
    /* ============================ INQUIRY =================================== */
            
    /* ============================ OPERATORS ================================= */
    
    /////////////////////////////// PRIVATE //////////////////////////////////////
    
    int id;
    ArrayList<Node> neighbours;
}

