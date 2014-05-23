package oop.ue03;

/**
 * class for repeating things
 */
public class Repeater {

    public Repeater(int times) {
        this.setTimes(times);
    }

    public Repeater() {
        this.setTimes(0);
    }

    public int getTimes() { return this.times; }
    
    public Repeater setTimes(int v) { this.times = v; return this; }

    /**
     * repeat a given message n times
     * @param  message
     * @param  times
     * @return the connected string containing the message
     */
    public String repeat(String message, int times) {
        String out = "";

        for (int i = 0; i < times; i++) {
            out += message;
        }

        return out;
    }

    /**
     * repeat method which uses the set repeatcount of the object
     * @param  message
     * @return message repeated n times
     */
    public String repeat(String message) {
        return repeat(message, this.getTimes());
    }

    int times;
    
}