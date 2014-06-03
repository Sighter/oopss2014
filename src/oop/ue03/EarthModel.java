package oop.ue03;

import java.io.IOException;
import java.util.Scanner;

/*
 * Klasse von EarthModel 
 */
public class EarthModel 
{	
	/*
	 * private Variable definiert
	 */	  
	  private String outputMsg;
	  private String inputMsg;		  
	  private int repeats;	 
	  
	  
	  DeNoiser dn = new DeNoiser();
	  DeRepeater dr = new DeRepeater();
	  FileReader fr = new FileReader();
	  FileWriter fw =new FileWriter();	 
	 
	  public EarthModel(){}
	  
	  /*
	   * Methode EarthMode 
	   * Control the Message reading ,decrypting and sending.
	   */
	  public void EarthModel() throws IOException
	  {		
		    FileWriter fw = new FileWriter();
		    FileReader fr = new FileReader();
		    DeNoiser dn = new DeNoiser();
		    System.out.println("Wie viel mal wiederholt die Nachrichten?");
	        Scanner input1 =new Scanner(System.in); 
		    int a=input1.nextInt();
		    System.out.println("Bitte geben Sie die input FilePath");	
			Scanner input2 =new Scanner(System.in);		  
			String s1 =input2.nextLine();
			System.out.println("Bitte geben Sie die output FilePath");
			Scanner input3 =new Scanner(System.in);		  
			String s2= input2.nextLine();		
	        fw.writeMsgToFile(s2, dn.denoise(fr.readMsgFromFile(s1),a));
	  }
	  	  
	  public void readMsg() throws IOException {}	  
   	  public void decrypt() throws IOException {}  
	  public void sendMsg() throws IOException {}
	  
}
