package oop.ue03;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
/*
 * Klasse von DeNoiser
 * Enrausch von die geteilte Nachrichten
 */

public class DeNoiser
{
	
	/*
	 * @param messgae  die gegebene UrNachrichten 
	 * @param repeats  die Anzahl der Wiederholung
	 * @return String 
	 */
	
  public String denoise(String message,int repeats) throws IOException
  {    
	  DeRepeater dr = new DeRepeater();
	  int[] count = new int[message.length()/repeats];
	  int[] maxcount = new int[message.length()/repeats];
	  char[] max= new char[message.length()/repeats];
	  
	  
//	 fuer jeder Reiche gibt es eine maximal-malig widerholte Elemnt,
//	 dann bestimmten wir die Richtige Staben.
	  	  
	  for(int i=0;i<message.length()/repeats;i++)
	  {
	   count[i]= 1;
	   maxcount[i]= 0;		  
	    for(int k=0; k<repeats-1;k++)
	    {	    
	     if(dr.deRepeat(message,repeats)[i][k]==(dr.deRepeat(message,repeats)[i][k+1]))
	     {
	    	count[i]++;	 
	    	if(count[i] > maxcount[i])
	    	    {
	    		 maxcount[i]=count[i];
	    		 max[i]= dr.deRepeat(message,repeats)[i][k];
//	    System.out.println(maxcount[i]);
	    	    }     
	     }	
//	     System.out.println(max[i]); 
	   }
   }  
//	  stellen die Type Char[] zu String um.
	  String s1 = new String(max);
	  System.out.println(s1);
	  return s1;   
  }
  }