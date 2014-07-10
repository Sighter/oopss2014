package oop.ue05;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import java.text.NumberFormat;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import oop.ue05.FracModel;


/**
 * view class to draw the fractal
 */

public class FracDrawingPanel extends JPanel implements Observer, ComponentListener {

    private FracModel fracModel = null;

    /**
     * constructor
     * 
     * @param  model the model the panel should get its draw data from
     */
    
    public FracDrawingPanel(FracModel model) {
        this.fracModel = model;
        this.initComponents();
        this.addComponentListener(this);
    }

    /**
     * calculate the current real size we can draw in
     */
    
    Dimension getRealDrawingDimensions() {

        Dimension size = getSize();
        System.out.format("Dimension; " + size + "\n");

        Insets insets = getInsets();

        int w = size.width - insets.left - insets.right;
        int h = size.height - insets.top - insets.bottom;

        Dimension realSize = new Dimension(w, h);

        return realSize;
    }

    /**
     * update function gets called on model update
     */
    public void update( Observable m, Object o) {
        System.out.println("View update received in FracDrawingPanel!, drawing");
        this.repaint();
    }

    /*
     * event handler for component event
     */

    public void componentHidden(ComponentEvent e) {
        System.out.println((e.getComponent().getClass().getName() + " --- Hidden"));
    }

    public void componentMoved(ComponentEvent e) {
        System.out.println((e.getComponent().getClass().getName() + " --- Moved"));
    }

    public void componentResized(ComponentEvent e) {
    }

    public void componentShown(ComponentEvent e) {
        System.out.println((e.getComponent().getClass().getName() + " --- Shown"));
    }
    
    /**
     * initialize components
     */
    
    private void initComponents() {
        this.setOpaque(true);
        this.setBackground(Color.BLACK);  
    }
    
    /**
     * main function to draw the screen from the model's framebuffer
     * 
     */
    
    private void doDrawing(Graphics g) {

        if (this.fracModel == null)
            return;

        int [][] buffer = this.fracModel.getFrameBuffer();
        int width = this.fracModel.getWidth();
        int height = this.fracModel.getHeight();

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.WHITE);

        for (int x = 0; x < width; x++ ) {
            for (int y = 0; y < width; y++ ) {
                if (buffer[x][y] == -1) {
                    g2d.setColor(Color.WHITE);
                    g2d.drawLine(x, y, x, y);
                } else {
                    Color c = new Color(0, 0, buffer[x][y] % 255);
                    g2d.setColor(c);
                    g2d.drawLine(x, y, x, y);
                }
            }            
        }
    }

    /**
     * overwritten method to control component painting
     */

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.drawString("BLAH", 20, 20);
        this.doDrawing(g);
    }
}