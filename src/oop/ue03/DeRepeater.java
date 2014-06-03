package oop.ue03;

import java.io.IOException;
import java.util.Arrays;

/*
 * Klasse von DeRepeater
 * Verteilt die UrNachrichten in bestimmte Teilen.
 */
public class DeRepeater
{
 
	/*
	 * @param messgae  die gegebene UrNachrichten 
	 * @param repeats  die Anzahl der Wiederholung
	 * @return char[][]
	 */
   public char[][] deRepeat(String message,int repeats) throws IOException
  {   	

	 int j=-1;
	 char[] messagearr =message.toCharArray();
	 char[][] str = new char[repeats][message.length()/repeats];
	 char[][] str1=new char[message.length()/repeats][repeats];
	 char[][] temp=new char[message.length()/repeats][repeats];
	
// 	 Verteilt die Nachrichten in "repeats" mal, eine Matrix von repeats*(length/repeats)
	 for(int k=0; k< repeats;k++)
	 {
		 for (int i=0 ; i< message.length()/repeats; i++) 
	     { 
		   j++;
		   if(j<message.length())
	       str[k][i] = messagearr[j];		  		   
	 	 }	  
	 }  
	 
//  Transport die verteile Nachrichten 	 
	 for (int m=0 ; m< message.length()/repeats; m++) 
	 {
		 for(int n=0; n< repeats;n++)
	     { 
		   temp[m][n]= 0;
	       temp[m][n]=str[n][m] ;
	       str1[m][n]=temp[m][n];
	 	 }			 		 
		 Arrays.sort(str1[m]);
//		 System.out.println(str1[m]);
   	 } 
	 	

//	 System.out.println(str1[9][5]); 
	 return str1;
  }
}