package oop.ue04;

import java.util.Stack;


/**
 * Klass von Way
 * es wird als ein Stack von Node definiert
 */
public class Way 
{
    private Stack<Node> nodeList = new Stack<Node>();
    
	public Way(){
		
	}
	
	public Way setStack(Stack<Node> s) {
		this.nodeList = s;
		return this;
	}
	
	public Stack<Node> getStack() {
		return this.nodeList;
	}
		
	////////////////////////////////////////////////////////////////////////////////////		
	public Node peek() {
		return this.nodeList.peek();
	}
	
	public int search(Node n) {
		return this.nodeList.search(n);
	}
	
	public Way getCopy() {
		Stack<Node> newStack = new Stack<Node>();
		
		for(Node n : this.getStack()) {
			newStack.push(n);
		}
		
		Way newWay = new Way();
		newWay.setStack(newStack);
		
		return newWay;
	}
	///////////////////////////////////////////////////////////////////////////////////	
	
	

	/**
	 * push node  in Stack 
	 * @param node  
	 */
	public void push(Node node)
	{
		this.nodeList.push(node);
	}
	
	/**
	 * pop node aus Stack 
	 * @param node  
	 */
	public void  pop()
	{
		this.nodeList.pop();
	}
	
	/**
	 * entscheiden node ob in Stack ist 
	 * @param node   
	 */
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
}
