package oop.ue03;

import java.lang.Math;
import java.lang.IllegalArgumentException;
import java.lang.StringBuilder;
import java.lang.Character;

import oop.ue03.Noiser;


public class Noiser {

    /////////////////////////////// PUBLIC ///////////////////////////////////////

    public static void main(String[] args) {

        System.out.println("Some examples to print out:");

        Noiser n = new Noiser();

        //n.noisify("Hello there", 105);


        for (int i = 0; i < 10; i++) {
            String message = "Hello There!Hello There!Hello There!";
            double c = 40;
            String noisedMessage = n.noisify(message, c);
            int count = n.getLastNoisedCharCount();

            System.out.format(
                "%s%% %d/%d R:%.3f%%: %s => %s\n",
                c,
                count, message.length(),
                (double)count / (double)message.length() * 100,
                message, noisedMessage
            );
        }

    }
    
    /* ============================ LIFECYCLE ================================= */

    /**
     * standart constructor sets the ascii intevall which is used
     * between 126 and 33 decimal
     */
    public Noiser() {
        this.setAsciiValueMax(126);
        this.setAsciiValueMin(33);
    }

    /* ============================ OPERATIONS ================================ */

    /**
     * this function pushes noise into a string
     * the chance is the porximity, with which every single
     * character gets randomized
     * 
     * @param  message
     * @param  chance a value from 0 to 100
     * @return string with noise
     */
    public String noisify(String message, double chance) {

        this.setLastNoisedCharCount(0);

        /* check whether chance is valid value */
        if (chance < 0 || chance > 100)
            throw new IllegalArgumentException(
                "Invalid Chance. Must be value between 0 and 100. Was: " + chance
            );

        chance = chance / 100;

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);

            if (Math.random() <= chance) {
                c = this.createRandomAsciiChar(
                    this.getAsciiValueMin(),
                    this.getAsciiValueMax()
                );
                this.lastNoisedCharCount++;
            }

            stringBuilder.append(c);
        }

        return stringBuilder.toString();
    }

    /* ============================ ACCESS ==================================== */

    public int getAsciiValueMax() { return this.asciiValueMax; }
    
    public Noiser setAsciiValueMax(int v) { this.asciiValueMax = v; return this; }

    public int getAsciiValueMin() { return this.asciiValueMin; }
    
    public Noiser setAsciiValueMin(int v) { this.asciiValueMin = v; return this; }

    /**
     * retrieve the count of characters, which really hav been randomized
     * @return count
     */
    public int getLastNoisedCharCount() { return this.lastNoisedCharCount; }
    
    private Noiser setLastNoisedCharCount(int v) { this.lastNoisedCharCount = v; return this; }
    
    /* ============================ INQUIRY =================================== */
            
    /* ============================ OPERATORS ================================= */
    
    /////////////////////////////// PRIVATE //////////////////////////////////////
    
    private int asciiValueMax;

    private int asciiValueMin;

    private int lastNoisedCharCount;

    /**
     * create a random integer number between min and max value
     * @param  min intervall minimum
     * @param  max intervall maximum
     * @return the randomized number
     */
    private int randomWithRange(int min, int max) {
       int range = (max - min) + 1;
       return (int)(Math.random() * range) + min;
    }

    /* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -*/

    /**
     * create a random ascii charater inside the given intervall
     * @param  min ascii decimal code
     * @param  max ascii decimal code
     * @return the randomized charater
     */
    private char createRandomAsciiChar(int min, int max) {
        int asciiNumber = this.randomWithRange(min, max);
        char newChar = (char)asciiNumber;

        //System.out.format("created: %d => %s\n",asciiNumber, Character.toString(newChar));

        return newChar;
    }

}