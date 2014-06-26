package oop.ue04;

import java.util.ArrayList;
import java.util.List;

/**
 * Klass von Maze
 */
public class Maze 
{
	private Node startNode  ;
	private Node targetNode ;
	private List<Node> allNodes = new ArrayList<Node>(); 
    List<Way> allWays = new ArrayList<Way>();	
    List<Way> Ways = new ArrayList<Way>();	
    Way newWay = new Way();
    
   
	public Maze(List<Node> nodes,Node startNode,Node targetNode)
	{
		this.allNodes = (ArrayList<Node>) nodes;
		this.startNode = startNode;
		this.targetNode = targetNode;
	}
	
//	 ich schreibte die Attribute zum ersten public,um einfach zu sehen.
	
	/**
	 * Node findWayRec  mit rekusiv Methode
	 * @param current  jetzt die Node  haben wir gefunden
	 * @param target   die EndNode wir fuegten
	 * @param currentway  jetzt der Pfad wir haben gefunden 
	 * @return found  
	 */
	private Node findWayRec(Node current,Node target,Way currentway) {	
	    Node found = null;
		if(current == target) {  
			return found;			  
		} else {
			for(Node n:current.getNeighbours()) {				 
				if(this.findNodeInWays(n)==false&& n!= null&&currentway.search(n)== -1) {	
					currentway.push(n);
					this.allWays.add(currentway);
//				    if(currentway.search(n) == -1)
					found=findWayRec(n,target,currentway);					
				    if (currentway.peek() == target){
					this.Ways.add(currentway.getCopy());}
			
				//System.out.println(currentway);
             
				if(found!=null)
			    {	
			    return found; 
			    }
			    else 
			    {
			    currentway.pop();
			    }
			 }
		     else
		     {
		    	 this.allWays.remove(currentway);
		     }
		  }	
         }	
	  return found;		
	 }
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	/**
	 * Die Methoden peek(),serch(), pop() und path() sind nur fuer Testen.
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
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	/**
	 * findAllWays ist ein List von alle Pfad wir findeten
	 * @return allWays speicheren
	 */	
	public List<Way> findAllWays ()
	{ 	 	
		Way w = new Way();
		w.push(this.startNode);
		this.findWayRec(this.startNode, this.targetNode, w);
		this.allWays.add(this.newWay);
		return this.Ways;
	}
	
	/**
	 * entscheiden wir ob die Node was wir suchen  in  schon gefunden pfad ist
	 * @param node  entscheiden die Node
	 * @retrun false es ist nicht darin vom Anfang
	 */	
	public boolean findNodeInWays(Node node)
	{ 
	  for(Way way:this.allWays)
	   {
	   if(way.nodeExists(node)==true)
	   {
		 return true;
	   }
	   else 
	     return false;
	   }
	  return false;
	}
	
	
	public String toString()
	{
	return "" + this.findWayRec(this.startNode, this.targetNode,this.newWay)+""+this.newWay
			+""+ this.findAllWays();
	}
 
	
}
