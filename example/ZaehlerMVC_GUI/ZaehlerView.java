// ZaehlerView.java                             MM 2007
// MVC-View

import java.util.*;                         // Observer
import javax.swing.*; //JFrame, JPanel, JLabel, JButton

/**
 * View zum Zaehler modulo 10,
 * Version mit Benutzeroberflaeche.
 */
public class ZaehlerView
  extends JFrame
  implements Observer
{
/* ------------------------------------------------- */
                                                 // GUI
/**
 * Konstante, Zaehlen.
 */
  public static final String ACTION_NEXT = "Next";

/**
 * Konstante, Beenden des Programms.
 */
  public static final String ACTION_QUIT = "Quit";

/**
 * Label, fuer Zahl.
 */
  private JLabel lbZahl;

/* ------------------------------------------------- */
                                                 // MVC
/**
 * Mathematisches Modell,
 * enthaelt Funktionalitaet des Zaehlers.
 */
  private ZaehlerModel model;

/**
 * Zum View gehoeriger Controller.
 */
  private ZaehlerController controller;

/* ------------------------------------------------- */
                                    // MVC-Installation
/**
 * Konstruktor, setzt Ueberschrift und installiert MVC.
 * @param model Model, welches dargestellt werden soll
 * @param titel Ueberschrift
 */
  public ZaehlerView( ZaehlerModel model, String titel)
  {
// Titelzeile
    super( titel);
// Model
    this.model = model;
    this.model.addObserver( this);
// Controller
    controller = makeController();
// View
    makeView();
  }

/**
 * Erzeugt Controller,
 * Empfaenger fuer Ereignisse.
 * @return Controller fuer View
 */
  private ZaehlerController makeController()
  {
    return new ZaehlerController( model, this);
  }

/**
 * Erzeugt View,
 * baut die grafische Oberflaeche auf,
 * Controller verarbeitet Fensterereignisse.
 */
  private void makeView()
  {
// ContentPane
    setContentPane( createContentPane());

// Fenster mit Controller als Listener
    addWindowListener( controller);
    pack();
    setVisible( true);
  }

/**
 * Erzeugt Darstellungsbereich mit Steuerbuttons
 * und Label fuer Zaehler,
 * Controller verarbeitet Buttonereignisse.
 */
  private JPanel createContentPane()
  {
    JPanel contentPane = new JPanel();

             // Button Next mit Controller als Listener
    JButton btNext = new JButton( ACTION_NEXT);
    contentPane.add( btNext);
    btNext.addActionListener( controller);

    lbZahl = new JLabel( "0");       // Label Augenzahl
    contentPane.add( lbZahl);

             // Button Quit mit Controller als Listener
    JButton btQuit = new JButton( ACTION_QUIT);
    contentPane.add( btQuit);
    btQuit.addActionListener( controller);

    return contentPane;
  }

/* ------------------------------------------------- */
                                  // MVC-Deinstallation
/**
 * Entfernt Fenster, deinstalliert MVC.
 */
  public void release()
  {
// View (Fenster)
    dispose();
// Controller
    controller.release();
    controller = null;
// Model
    model.deleteObserver( this);
    model = null;
  }

/* --------------------------------------------------*/
                                    // Observer-Methode
/**
 * Ueberschreibt Interfacemethode,
 * legt Reaktion auf Aenderungen fest.
 * @param m Model, welches Aenderungen meldet
 * @param o geaenderte Objekte
 */
  public void update( Observable m, Object o)
  {
    if( model == m)
      lbZahl.setText( "" + model.getCount());
  }
}
