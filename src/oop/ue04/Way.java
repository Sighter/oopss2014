package oop.ue04;


import java.util.Stack;

public class Way 
{
    Stack<Node> nodeList = new Stack<Node>();
    
	public Way(){}
		
////////////////////////////////////////////////////////////////////////////////////		
	public Node peek()
	{
	 return this.nodeList.peek();
	}
	public int search(Node n)
	{
		return this.nodeList.search(n);
	}
///////////////////////////////////////////////////////////////////////////////////	
	
	
	
	public void push(Node node)
	{
		this.nodeList.push(node);
	}
	
	public void  pop()
	{
		this.nodeList.pop();
	}
	
	public boolean nodeExists(Node node)
	{
		if(this.nodeList.search(node) == -1)
		{
		return false;
		}
		else
		{
		return true;	  	
		}
	}
	
	public String toString()
	{
		return ""+this.nodeList;
	}

	public Stack<Node> getNodeList() {
		return this.nodeList;
	}
}
