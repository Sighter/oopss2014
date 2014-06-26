package oop.ue04;

import java.util.ArrayList;
import java.util.List;

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
	public Node findWayRec(Node current,Node target,Way currentway)
	{	
		Node found = null;
		if(current == target)
		{  
			return current;			  
		}		    
		else
		{
			//System.out.println("processing node: " + current);
			for(Node n:current.getNeighbours())
			{				 
				if(this.findNodeInWays(n) == false && n != null)
				{	
					currentway.push(n);
					this.allWays.add(currentway);
					found=findWayRec(n,target,currentway);
					if(found!=null)
					{			    
						return found; 
					}
					else 
					{
						currentway.pop();
					}
				}	
			}	
		}	
		return null;		
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	/*
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
	
	
	public List<Way> findAllWays ()
	{ 
//	 ?????  viellechte verschreibte ich hier . 
//	 Way last=this.allWays.get(this.allWays.size()-1); 
//	 this.newWay= last; 


		Way w = new Way();
		w.push(this.startNode);

		this.findWayRec(this.startNode, this.targetNode, w);

		return this.allWays;
	}
	
	public String toString()
	{
		return "" + this.findWayRec(this.startNode, this.targetNode,this.newWay)+""+this.newWay
		+""+ this.findAllWays();
	}

	
}
