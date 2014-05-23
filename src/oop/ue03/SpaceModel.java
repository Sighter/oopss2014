package oop.ue03;

import oop.ue03.Noiser;
import oop.ue03.Repeater;

public class SpaceModel {

    /////////////////////////////// PUBLIC ///////////////////////////////////////
    
    public static void main(String[] args) {
        /* put a SpaceModel together */

        Noiser n = new Noiser();
        Repeater r = new Repeater(5);

        SpaceModel sm = new SpaceModel(10, n, r);

        System.out.println(sm);

        String message = "Welcome Earth!";

        String out = sm.sendThrough(message);

        System.out.format("%s => %s", message, out);

    }
    
    /* ============================ LIFECYCLE ================================= */
    
    public SpaceModel(double prox, Noiser noiser, Repeater repeater) {

        this.setNoiseProximity(prox);
        this.setNoiser(noiser);
        this.setRepeater(repeater);

    }
    
    /* ============================ ACCESS ==================================== */

    public Noiser getNoiser() { return this.noiser; }
    
    public SpaceModel setNoiser(Noiser v) { this.noiser = v; return this; }

    public Repeater getRepeater() { return this.repeater; }
    
    public SpaceModel setRepeater(Repeater v) { this.repeater = v; return this; }

    public double getNoiseProximity() { return this.noiseProximity; }
    
    public SpaceModel setNoiseProximity(double v) { this.noiseProximity = v; return this; }

    /* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -*/

    public String toString() {

        String s = String.format("[Wide Open Space. Your Messages will take %.3f%% jamming.]",
            this.getNoiseProximity()
        );

        return s;
    }
    
    /* ============================ OPERATIONS ================================ */

    /**
     * send a message through space
     * @param  message
     * @param  repeats how often the message should be repeated before sending
     * @return the jammed message
     */
    public String sendThrough(String message) {

        String repeatedMsg = this.getRepeater().repeat(message);

        return this.getNoiser().noisify(repeatedMsg, this.noiseProximity);

    }
    
    /* ============================ INQUIRY =================================== */
            
    /* ============================ OPERATORS ================================= */
    
    /////////////////////////////// PRIVATE //////////////////////////////////////
  
    private double noiseProximity;

    private Noiser noiser;

    private Repeater repeater;
}