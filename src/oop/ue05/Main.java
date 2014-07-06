package oop.ue05;

import javax.swing.SwingUtilities;

import oop.ue05.FracMainView;
import oop.ue05.FracMainController;


public class Main implements Runnable {

    FracMainView mainView;
    FracMainController controller;

    public static void main(String[] args) {

        FracMainView v = new FracMainView();
        FracMainController c = new FracMainController(v, 10);

        Main m = new Main(v, c);

        SwingUtilities.invokeLater(m);
    }

    public Main(FracMainView v, FracMainController c) {
        this.mainView = v;
        this.controller = c;
    }

    public void run() {
        this.mainView.setVisible(true);
    }

}