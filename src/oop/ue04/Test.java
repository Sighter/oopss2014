package oop.ue04;

import java.util.ArrayList;

public class Test 
{	 
	 public static void main(String[] args)
	  {
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
	    System.out.println("the last Node we have found is "+m.findWayRec(a,h) );
	    m.peek();
	    System.out.println("the Index of " + a +" in Stack is "+ m.search(a));	    
	    System.out.println("the Index of " + c +" in Stack is "+ m.search(c));
	    System.out.println("the Index of " + d +" in Stack is "+ m.search(d));
	    System.out.println("the Index of " + b +" in Stack is "+ m.search(b));
	    System.out.println("the Index of " + e +" in Stack is "+ m.search(e));
	    System.out.println("the Index of " + f +" in Stack is "+ m.search(f));
	    System.out.println("the Index of " + g +" in Stack is "+ m.search(g));
	    System.out.println("the Index of " + h +" in Stack is "+ m.search(h));
	    System.out.println("the Way from "+a+" to " + h +" is " + m.path());
	}
}
