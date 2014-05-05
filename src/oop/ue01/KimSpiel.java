import java.util.Arrays;


/**
 * class für Einkapseln von  KimSpiel 
 */

public class KimSpiel {
	/**
	 * private variablen definiert
	 * 
	 * definiert eine Tupel von die zufälligen Zahlen
	 */
	private int digits;
	private int maxDigits;
	private int[] lastNumber;
	/**
	 * die zufälligen Zahlen ist von 2- bis 10- Stellig.
	 */

	public KimSpiel() {
		this.digits = 2;
		this.maxDigits = 10;
	}

	public int getDigits() {
		return this.digits;
	}

	public int getMaxDigits() {
		return this.maxDigits;
	}
	
	/**
	* Darstellen der Zufalligen Zahlen
	* Wuerfelsatz
	* difinierte eien new Tupel von Zufalligen Zahlen aus Wuerfel
	* @return ist die gengewärtig  Zufalligen Zahlen
	*/
	public int[] getNextNumber() {
		int[] numberArray = new int[this.getDigits()];

		Wuerfel dice = new Wuerfel(1,9);
		
		for (int idx = 0; idx < this.getDigits(); idx++) {

			dice.wuerfeln();
			numberArray[idx] = dice.getAugen();
		}

		this.lastNumber = numberArray;
		this.digits += 1;

		return numberArray;
	}

	/**
	 * beurteilen  den gemerkten Zahl ob richtig ist
	 */
	public boolean validateLastNumber(int[] number) {
		return (Arrays.equals(number, this.lastNumber));
	}
}