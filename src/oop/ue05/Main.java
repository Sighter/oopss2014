package oop.ue05;

import java.awt.Dimension;
import javax.swing.SwingUtilities;

import oop.ue05.ComplexNumber;
import oop.ue05.FracMainController;
import oop.ue05.FracMainView;
import oop.ue05.FracModel;


public class Main implements Runnable {

    FracMainView mainView;
    FracMainController controller;

    public static void main(String[] args) {

        ComplexNumber n1 = new ComplexNumber(-0.7672,0.0999);
        ComplexNumber n2 = new ComplexNumber(-0.7652,0.1016);
        int iterationDepth = 150;

        FracModel model = new FracModel(n1, n2, iterationDepth, 800, 800);

        FracMainView v = new FracMainView(model);
        FracMainController c = new FracMainController(v, model);

        model.setWidth(600);
        model.setHeight(600);

        model.addObserver(v);
        model.calculateFrameBuffer();

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