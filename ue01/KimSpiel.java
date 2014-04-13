import java.util.Arrays;

public class KimSpiel {

    private int digits;
    private int[] lastNumber;

    public KimSpiel() {
        this.digits = 2;
    }

    public int getDigits() {
        return this.digits;
    }

    public int[] getNextNumber() {
        int[] numberArray = {
            1, 4, 5
        };

        this.lastNumber = numberArray;

        return numberArray;
    }

    public boolean validateLastNumber(int[] number) {
        return (Arrays.equals(number, this.lastNumber));
    }
}