package oop.ue03;

import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;
import javax.swing.border.EmptyBorder;
import java.nio.file.NoSuchFileException;

import oop.ue03.FileReader;
import oop.ue03.FileWriter;


/**
 * MainController class
 *
 * it handles user input and processing messages. It can noise or
 * denoise messages
 */

public class MainController 
{
	/////////////////////////////// PUBLIC ///////////////////////////////////////

	public static void main(String[] args) throws IOException {
		
		Scanner inputScanner = new Scanner(System.in);
		FileReader reader = new FileReader();
		FileWriter writer = new FileWriter();

		

        MainController con = new MainController(
        	inputScanner,
        	reader,
        	writer
        );


		con.mainLoop();
	}

	/* ============================ LIFECYCLE ================================= */

	public MainController(Scanner input, FileReader reader, FileWriter writer) {
		this.setInput(input);
		this.setReader(reader);
		this.setWriter(writer);
	}

	/* ============================ ACCESS ==================================== */

	public Scanner getInput() { return this.input; }
	
	public MainController setInput(Scanner v) { this.input = v; return this; }

	public FileReader getReader() { return this.reader; }
	
	public MainController setReader(FileReader v) { this.reader = v; return this; }

	public FileWriter getWriter() { return this.writer; }
	
	public MainController setWriter(FileWriter v) { this.writer = v; return this; }
	
	/* ============================ OPERATIONS ================================ */
	
	/**
	 * application main loop
	 * @throws IOException [description]
	 */
	public void mainLoop() throws IOException {

		while(true) {

			int choice = this.mainMenu();


			/* handle noise */
			
			if(choice == 1) {
				int reps = this.askForRepetitions();
				int prox = this.askForNoiseProximity();
				String inPath;
				String msg;
				String outMsg;

				/* read input file */

				inPath = this.askForInputMsgPath();

				try {
					msg = this.getReader().readMsgFromFile(inPath);
				} catch (NoSuchFileException e) {
					System.out.println("Datei Nicht gefunden!");
					continue;
				}

				System.out.println("Nachricht eingelesen: " + msg);

				String outPath = this.askForOutputMsgPath();

				Noiser n = new Noiser();
		        Repeater r = new Repeater(reps);
		        SpaceModel sm = new SpaceModel(prox, n, r);

		        outMsg = sm.sendThrough(msg);

		       	System.out.println("Nachricht wird gespeichert: " + outMsg);

		       	this.getWriter().writeMsgToFile(outPath, outMsg);
			}

			/* handle denoise */

			if(choice == 2) {   
				EarthModel em= new EarthModel();
				em.EarthModel();
				continue;
			}

		   	if(choice == 0) {
				System.out.println("Bye!");
			    break;
			}	        
		}

	}

	/////////////////////////////// PRIVATE //////////////////////////////////////
	
	/*
	 * class dependencies
	 */
	
	private Scanner input;
	private FileReader reader;
	private FileWriter writer;

	/**
	 * draw a main menu and let the user choose from various options
	 * @return [description]
	 */
	
	private int mainMenu() {

		System.out.println("\n");
		System.out.println("Moechten Sie Verrauschen oder Entrauschen?");
		System.out.println("1-----------------Verrauschen");
		System.out.println("2-----------------Entrauschen");
		System.out.println("0-----------------Quit");

		int choice;
		
		while (true) {
			
			System.out.print("> ");

			try {
				choice = this.input.nextInt();
			} catch (InputMismatchException e) {
				this.input.nextLine();
				continue;
			}

			if (choice > 2) {
				this.input.nextLine();
				continue;
			}

			return choice;
		}
	}

	/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -*/

	/**
	 * ask the user how many repetitions he wants to have in
	 * the message
	 * @return the count of repetitions
	 */
	private int askForRepetitions() {
		while (true) {
			try {
				System.out.print("Wie oft soll die Nachricht wiederholt werden?: > ");
				int reps = input.nextInt();
				this.input.nextLine();
				return reps;
			} catch (InputMismatchException e) {
				this.input.nextLine();
			}
		}
	}

	/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -*/

	/**
	 * ask the user for the proximity the signl gets noised with
	 * @return noise prximity
	 */
	private int askForNoiseProximity() {
		while (true) {
			try {
				System.out.print("Wie hoch soll das All-Rauschen sein (0-100) ?: > ");
				int noise = input.nextInt();

				if (noise < 0 || noise > 100)
					continue;

				this.input.nextLine();
				return noise;
			} catch (InputMismatchException e) {
				this.input.nextLine();
			}
		}
	}

	/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -*/

	/**
	 * ask the user for the path from  where the input message should be read
	 * @return imput message
	 */
	private String askForInputMsgPath() {
		while (true) {
			try {
		      	System.out.print("Bitte geben sie den Pfad der zu lesenden Nachricht an: > ");
				String line = input.nextLine();
				return line;
			} catch (InputMismatchException e) {
			}
		}
	}

	/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -*/

	/**
	 * ask the user for path, where the output message should be written
	 * @return output message
	 */
	private String askForOutputMsgPath() {
		while (true) {
			try {
		      	System.out.print("Bitte geben sie einen Pfad für die Ausgabedatei an: > ");
				String line = input.nextLine();
				return line;
			} catch (InputMismatchException e) {
			}
		}
	}
}