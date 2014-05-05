
/**
 * main class
 */
public class Main {

    /**
     * simple main wrapper to start the game
     * @param args [description]
     */
    public static void main(String[] args) {

        play();

    }

    /**
     * this method starts the game
     */
    public static void play() {

        KimSpielDialog dialog = new KimSpielDialog(2000);

        dialog.loopPlay();

    }
}