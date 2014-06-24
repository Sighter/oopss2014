package oop.ue04;

import java.util.ArrayList;
import java.util.List;

public class Maze 
{
	private Node startNode  ;
	private Node targetNode ;
	private List<Node> allNodes = new ArrayList<Node>(); 
    List<Way> allWays = new ArrayList<Way>();		
    Way newWay = new Way();
    
   
	public Maze(List<Node> nodes,Node startNode,Node targetNode)
	{
		this.allNodes = (ArrayList<Node>) nodes;
		this.startNode = startNode;
		this.targetNode = targetNode;
	}
		
	public Node findWayRec(Node current,Node target)
	{	
	    Node found = null;
		if(current == target)
		  {  
			return current;			  
		  }		    
		  else
		  {
		   for(Node n:current.getNeighbours())
			{			 
		     if(this.findNodeInWays(n)==false)
			 {	
		     this.newWay.push(n);
			 found=findWayRec(n,target);
			    if(found!=null)
			    {			    
			    return found; 
			    }
			    else 
			    {
                this.newWay.pop();
			    }
			 }	
		  }	
         }	
	  return null;		
	 }
	
//////////////////////////////////////////////////////////////////////////////////////////////////	
	/*
	 * Die Methoden peek(),serch(), und pop() sind nur fuer Testten.
	 */
	public void peek()
	{
	  System.out.println("the first element in Stack is " +this.newWay.peek());
	}	
	public int search(Node n) 
	{
	   return this.newWay.search(n);
	}
	public void pop()
	{
		this.newWay.pop();
	}
	
	public Way path()
	{
	  return this.newWay;
	}
//////////////////////////////////////////////////////////////////////////////////////////////////	
	  
	
	public boolean findNodeInWays(Node node)
	{ 
	  this.allWays.add(this.newWay);
	  for(Way way:this.allWays)
	   {
	   if(way.nodeExists(node)==true)
	   {
		 return true;
	   }
	   else return false;
	   }
		return false;
	}
	
	
	public List<Way> findAllWays ()
	{   	 
	 Way last=this.allWays.get(this.allWays.size()-1);
	 this.newWay= last;
	 return this.allWays;
	}
	
	
	public String toString()
	{
	return "" + this.findWayRec(this.startNode, this.targetNode)+""+this.newWay
			+""+ this.findAllWays();
	}
 
	
}
