package oop.ue05;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;

import oop.ue05.FracModel;
import oop.ue05.FracMainView;

public class FracMainController implements Observer, ActionListener {

    /////////////////////////////// PUBLIC ///////////////////////////////////////
    
    /* ============================ LIFECYCLE ================================= */

    public FracMainController(FracMainView view, FracModel fracModel) {
        this.fracMainView = view;
        this.fracModel = fracModel;

        this.init();
    }

    public void init() {

        this.fracMainView.getRecalcButton().addActionListener(this);
    }


    /* ============================ DEPENDENCIES ============================== */
    
    /* ============================ ACCESS ==================================== */
    
    /* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -*/
    
    /* ============================ OPERATIONS ================================ */

    /* ============================ EVENTS ==================================== */

    public void actionPerformed(ActionEvent e) {
        Number dn1r = 0.0, dn1i = 0.0, dn2r = 0.0, dn2i = 0.0, ddepth = 0.0;

        System.out.println("action event");
        if (e.getActionCommand() == "recalc")
            System.out.println("Got recalc in Controller");

        /* parse the values */
        
        NumberFormat format = this.fracMainView.getNumberFormat();
        String n1r = this.fracMainView.getCnum1re().getText();
        String n1i = this.fracMainView.getCnum1im().getText();
        String n2r = this.fracMainView.getCnum2re().getText();
        String n2i = this.fracMainView.getCnum2im().getText();
        String depth = this.fracMainView.getDepth().getText();

        System.out.format("Got Numbers: |%s|%s|%s|%s|%s|\n", n1r, n1i, n2r, n2i, depth);

        try {
            dn1r = format.parse(n1r);
            dn1i = format.parse(n1i);
            dn2r = format.parse(n2r);
            dn2i = format.parse(n2i);
            ddepth = format.parse(depth);
        } catch (ParseException exc) {
            System.out.format("Some of the input numbers could not be read properly!");
        }

        System.out.format("Got Numbers: |%s|%s|%s|%s|%s|\n", dn1r, dn1i, dn2r, dn2i, ddepth);

        /* set the model and recalc */
        this.fracModel.setBorderNumber1(new ComplexNumber(dn1r.doubleValue(), dn1i.doubleValue()));
        this.fracModel.setBorderNumber2(new ComplexNumber(dn2r.doubleValue(), dn2i.doubleValue()));
        this.fracModel.setIterationDepth(ddepth.intValue());
        this.fracModel.calculateFrameBuffer();
    }

    public void update(Observable o, Object arg) {

        System.out.println("FracMainController update!");

    }
    
    /* ============================ INQUIRY =================================== */
            
    /* ============================ OPERATORS ================================= */
    
    /////////////////////////////// PRIVATE //////////////////////////////////////
    
    FracModel fracModel;
    FracMainView fracMainView;

}