import java.util.Arrays;

public class KimSpiel {

    private int digits;
    private int maxDigits;
    private int[] lastNumber;

    public KimSpiel() {
        this.digits = 2;
        this.maxDigits = 5;
    }

    public int getDigits() {
        return this.digits;
    }

    public int getMaxDigits() {
        return this.maxDigits;
    }

    public int[] getNextNumber() {
        int[] numberArray = new int[this.getDigits()];

        for (int idx = 0; idx < this.getDigits(); idx++) {
            numberArray[idx] = 2;
        }

        this.lastNumber = numberArray;
        this.digits += 1;

        return numberArray;
    }

    public boolean validateLastNumber(int[] number) {
        return (Arrays.equals(number, this.lastNumber));
    }
}