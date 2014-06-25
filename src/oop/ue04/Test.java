package oop.ue04;

import java.util.ArrayList;

public class Test 
{	 
	 public static void main(String[] args)
	  {
//  Beispile:
//		 
//		 
//                          g (7)-------------- h (8)
//                            |
//                            |
//                            |
//     a (1)                b (2)-------------- e (3)
//       |                    |                  |
//       |                    |                  |
//       |                    |                  |
//     c (4) ---------------d (5)-------------- f (6) 
//		 
//		 
	 		 
	    ArrayList<Node> test = new ArrayList<Node>();
	    Node a=new Node(1);
	    Node b=new Node(2);
	    Node c=new Node(4);
	    Node d=new Node(5);
	    Node e=new Node(3);
	    Node f=new Node(6);
	    Node g=new Node(7);
	    Node h=new Node(8);
	    a.getNeighbours().add(c);
	    b.getNeighbours().add(d);
	    b.getNeighbours().add(e);
	    b.getNeighbours().add(g);
	    c.getNeighbours().add(a);
	    c.getNeighbours().add(d);
	    d.getNeighbours().add(b);
	    d.getNeighbours().add(c);
	    d.getNeighbours().add(f);
	    e.getNeighbours().add(b);
	    e.getNeighbours().add(f);
	    f.getNeighbours().add(e);
	    f.getNeighbours().add(d);
	    g.getNeighbours().add(b);
	    g.getNeighbours().add(h);
	    h.getNeighbours().add(g);
	     test.add(a);
	     test.add(b);
	     test.add(c);
	     test.add(d);
	     test.add(e);
	     test.add(f);
	     test.add(g);
	     test.add(h);
	    System.out.println("this NodeList is "+test);
	    for(Node n:test)
	    {
	    System.out.println(n+"'s Neighbour are"+n.getNeighbours());
	    }
	    Maze m= new Maze(test,a,f);
	    Way w = new Way();
	    System.out.println("the last Node we have found is "+m.findWayRec(a,f,w) );	
//	    System.out.println("the newWay is "+m.path() );	
	    System.out.println("all Ways are  "+m.findAllWays());	
	}
}
