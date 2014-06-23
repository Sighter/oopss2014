package oop.ue04;

import java.util.ArrayList;
import java.lang.StringBuilder;

class Node {

    /////////////////////////////// PUBLIC ///////////////////////////////////////
    
    public static void main(String[] args) {

        ArrayList<Integer> test = new ArrayList<Integer>();

        test.add(2);
        test.add(3);

        System.out.println(test);

        Node n = new Node(5);

        Node cn = new Node(3);
        Node cn2 = new Node(10);

        n.getNeighbours().set(3, cn);
        // n.getNeighbours().add(cn);

        System.out.println(n);
        
    }

    public static final int NEIGHBOUR_COUNT = 4;
    
    /* ============================ LIFECYCLE ================================= */

    public Node(int id) {
        this.setId(id);
        this.neighbours = new ArrayList<Node>(Node.NEIGHBOUR_COUNT);

        for (int idx = 0; idx < Node.NEIGHBOUR_COUNT; idx++) {
            this.neighbours.add(null);
        }
    }
    
    /* ============================ ACCESS ==================================== */

    public int getId() { return this.id; }
    
    public Node setId(int v) { this.id = v; return this; }

    public ArrayList<Node> getNeighbours() { return this.neighbours; }
    
    /* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -*/
    
    /* ============================ OPERATIONS ================================ */

    public String toString() {

        ArrayList<Node> n = this.getNeighbours();
        StringBuilder sb = new StringBuilder("<Node=");
        sb.append(this.getId());

        for (Node child : this.getNeighbours()) {
            sb.append(" | ");
            if (child == null)
                sb.append('x');
            else
                sb.append(child.getId());

        }

        sb.append(">");

        return sb.toString();
    }
    
    /* ============================ INQUIRY =================================== */
            
    /* ============================ OPERATORS ================================= */
    
    /////////////////////////////// PRIVATE //////////////////////////////////////
    
    int id;

    ArrayList<Node> neighbours;


}

