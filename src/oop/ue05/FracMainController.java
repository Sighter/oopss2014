package oop.ue05;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;

public class FracMainController implements Observer, ActionListener {

    /////////////////////////////// PUBLIC ///////////////////////////////////////
    
    /* ============================ LIFECYCLE ================================= */

    public FracMainController(FracMainView view, int fracModel) {
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
        System.out.println("action event");
        if (e.getActionCommand() == "recalc")
            System.out.println("Got recalc in Controller");
    }

    public void update(Observable o, Object arg) {

        System.out.println("FracMainController update!");

    }
    
    /* ============================ INQUIRY =================================== */
            
    /* ============================ OPERATORS ================================= */
    
    /////////////////////////////// PRIVATE //////////////////////////////////////
    
    int fracModel;
    FracMainView fracMainView;

}