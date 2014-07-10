package oop.ue05;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.NumberFormat;
import java.util.Observer;
import java.util.Observable;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import oop.ue05.FracModel;

public class FracMainView extends JFrame implements Observer {

    /////////////////////////////// PUBLIC ///////////////////////////////////////

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //FracMainView ex = new FracMainView();
                //ex.setVisible(true);
            }
        });
    }

    /* ============================ LIFECYCLE ================================= */

    public FracMainView(FracModel model) {
        this.fracModel = model;
        this.initComponents();
    }
    
    /* ============================ DEPENDENCIES ============================== */
    
    /* ============================ ACCESS ==================================== */

    public JPanel getRootPanel() {
        return this.rootPanel;
    }

    public JPanel getButtonContainer() {
        return this.buttonContainer;
    }

    public JButton getQuitButton() {
        return this.quitButton;
    }

    public JButton getRecalcButton() {
        return this.recalcButton;
    }

    public JFormattedTextField getCnum1re() {
        return this.cnum1re;
    }

    public JFormattedTextField getCnum1im() {
        return this.cnum1im;
    }

    public JFormattedTextField getCnum2re() {
        return this.cnum2re;
    }

    public JFormattedTextField getCnum2im() {
        return this.cnum2im;
    }

    public JLabel getLabel1re() {
        return this.label1re;
    }

    public JLabel getLabel1im() {
        return this.label1im;
    }

    public JLabel getLabel2re() {
        return this.label2re;
    }

    public JLabel getLabel2im() {
        return this.label2im;
    }

    public void setRootPanel(JPanel rootPanel) {
        this.rootPanel = rootPanel;
    }

    public void setButtonContainer(JPanel buttonContainer) {
        this.buttonContainer = buttonContainer;
    }

    public void setQuitButton(JButton quitButton) {
        this.quitButton = quitButton;
    }

    public void setRecalcButton(JButton recalcButton) {
        this.recalcButton = recalcButton;
    }

    public void setCnum1re(JFormattedTextField cnum1re) {
        this.cnum1re = cnum1re;
    }

    public void setCnum1im(JFormattedTextField cnum1im) {
        this.cnum1im = cnum1im;
    }

    public void setCnum2re(JFormattedTextField cnum2re) {
        this.cnum2re = cnum2re;
    }

    public void setCnum2im(JFormattedTextField cnum2im) {
        this.cnum2im = cnum2im;
    }

    public void setLabel1re(JLabel label1re) {
        this.label1re = label1re;
    }

    public void setLabel1im(JLabel label1im) {
        this.label1im = label1im;
    }

    public void setLabel2re(JLabel label2re) {
        this.label2re = label2re;
    }

    public void setLabel2im(JLabel label2im) {
        this.label2im = label2im;
    }

    public FracDrawingPanel getFracDrawingPanel() {
        return this.fracDrawingPanel;
    }

    public void setFracDrawingPanel(FracDrawingPanel fracDrawingPanel) {
        this.fracDrawingPanel = fracDrawingPanel;
    }

    public NumberFormat getNumberFormat() {
        return this.numberFormat;
    }
    
    public FracMainView setNumberFormat(NumberFormat v) {
        this.numberFormat = v; return this;
    }

    public JFormattedTextField getDepth() {
        return this.depth;
    }
    
    /* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -*/
    
    /* ============================ OPERATIONS ================================ */

    public void update( Observable m, Object o) {

        System.out.println("View update!");

        //this.getFracDrawingPanel().repaint();

    }
    
    /* ============================ INQUIRY =================================== */
            
    /* ============================ OPERATORS ================================= */
    
    /////////////////////////////// PRIVATE //////////////////////////////////////
    

    NumberFormat numberFormat =  NumberFormat.getNumberInstance();

    private JPanel rootPanel = new JPanel();
    private JPanel buttonContainer = new JPanel();

    private JButton quitButton = new JButton("Quit");
    private JButton recalcButton;
    private JFormattedTextField cnum1re = new JFormattedTextField(numberFormat);
    private JFormattedTextField cnum1im = new JFormattedTextField(numberFormat);
    private JFormattedTextField cnum2re = new JFormattedTextField(numberFormat);
    private JFormattedTextField cnum2im = new JFormattedTextField(numberFormat);
    private JFormattedTextField depth = new JFormattedTextField(numberFormat);

    private JLabel label1re = new JLabel("C1 = ");
    private JLabel label1im = new JLabel("i");
    private JLabel label2re = new JLabel("C2 = ");
    private JLabel label2im = new JLabel("i");
    private JLabel labelDepth = new JLabel("Depth");

    private FracDrawingPanel fracDrawingPanel = null;

    private FracModel fracModel = null;

    /** 
     * main function to configure and arrange all components
     */
    private void initComponents() {

        this.fracDrawingPanel = new FracDrawingPanel(this.fracModel);
        this.fracModel.addObserver(this.fracDrawingPanel);

        this.recalcButton = new JButton("Recalculate");

        /* configure components */

        this.setTitle("This is my title");
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.rootPanel.setLayout(new BorderLayout());
        this.buttonContainer.setLayout( new BoxLayout(buttonContainer, BoxLayout.LINE_AXIS));

        this.cnum1re.setColumns(10);
        this.cnum1im.setColumns(10);
        this.cnum2re.setColumns(10);
        this.cnum2im.setColumns(10);
        this.depth.setColumns(10);

        /* configure event handlers */
        
        this.quitButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent event) {
               System.exit(0);
          }
        });

        /* compose */

        this.getContentPane().add(rootPanel);

        this.buttonContainer.add(Box.createRigidArea(new Dimension(20, 0)));
        this.buttonContainer.add(this.label1re);
        this.buttonContainer.add(this.cnum1re);
        this.buttonContainer.add(this.cnum1im);
        this.buttonContainer.add(this.label1im);
        this.buttonContainer.add(Box.createRigidArea(new Dimension(20, 0)));

        this.buttonContainer.add(this.label2re);
        this.buttonContainer.add(this.cnum2re);
        this.buttonContainer.add(this.cnum2im);
        this.buttonContainer.add(this.label2im);
        this.buttonContainer.add(this.labelDepth);
        this.buttonContainer.add(this.depth);

        this.buttonContainer.add(Box.createRigidArea(new Dimension(100, 0)));

        this.buttonContainer.add(Box.createHorizontalGlue());

        this.buttonContainer.add(this.recalcButton);
        this.buttonContainer.add(this.quitButton);
        this.rootPanel.add(this.buttonContainer, BorderLayout.PAGE_END);
        this.rootPanel.add(this.fracDrawingPanel, BorderLayout.CENTER);

        // this.recalcButton.addActionListener(new ActionListener() {
        //    @Override
        //    public void actionPerformed(ActionEvent event) {
        //        System.exit(0);
        //   }
        // });

    }
}