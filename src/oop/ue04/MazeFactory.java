package oop.ue04;

import java.util.ArrayList;

import oop.ue04.Node;

class MazeFactory {

    /////////////////////////////// PUBLIC ///////////////////////////////////////
    
    /* ============================ LIFECYCLE ================================= */

    /**
     * construcor
     * @param a reader to use for reading nodes from the file
     * @return
     */
    public MazeFactory() {

    }

    /* ============================ ACCESS ==================================== */
    
    /* ============================ OPERATIONS ================================ */

    /**
     * create a maze by giving a list of nodes. The first
     * node in the list is the entrance point and the last one
     * the target node which has to be find.
     * 
     * @return a fresh maze
     */
    public Maze createMaze(ArrayList<Node> list) {
        return new Maze(list);
    }

    /* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -*/

    /**
     * create a fresh maze from a file
     * format is documented in the NodeReader class
     * @param path to the file
     * @return new maze
     */
    public Maze createMazeFromFile(String filePath) {

        NodeReader reader = new NodeReader(filePath);
        ArrayList<Node> list = reader.read();

        return createMaze(list)
    }
    
    /* ============================ INQUIRY =================================== */
            
    /* ============================ OPERATORS ================================= */
    
    /////////////////////////////// PRIVATE //////////////////////////////////////
}