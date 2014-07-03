// ZaehlerController.java                       MM 2007
// MVC-Controller

import java.awt.event.*;             // Listener, Event

/**
 * Controller zum ZaehlerView.
 */
public class ZaehlerController
  extends WindowAdapter
  implements ActionListener
{
/* ------------------------------------------------- */
                                                 // MVC
/**
 * Mathematisches Modell,
 * enthaelt Funktionalitaet des Zaehlers.
 */
  private ZaehlerModel model;

/**
 * Zum Controller gehoeriger View.
 */
  private ZaehlerView view;

/* ------------------------------------------------- */
                                    // MVC-Installation
/**
 * Konstruktor, initialisiert Model und View.
 * @param model Mathematisches Modell
 * @param view zum Controller gehoeriger View
 */
  public ZaehlerController
    ( ZaehlerModel model, ZaehlerView view)
  {
    this.model = model;
    this.view = view;
  }

/* ------------------------------------------------- */
                                  // MVC-Deinstallation
/**
 * Freigabe des Controllers,
 * setzt Model und View zurück.
 */
  public void release()
  {
    model = null;
    view = null;
  }

/* --------------------------------------------------*/
                                 // handleEvent-Methode
/**
 * ActionListener,
 * Ereignisverarbeitung Betaetigen eines Button.
 */
  public void actionPerformed( ActionEvent ae)
  {
    String command = ae.getActionCommand();

// Zaehlen durch Button 'Next'
    if( command.equals( ZaehlerView.ACTION_NEXT))
      model.next();             // Weiterzaehlen

// Programmabbruch durch Button 'Quit'
    if( command.equals( ZaehlerView.ACTION_QUIT))
      view.release();              // Programm  beenden
  }

/**
 * WindowAdapter,
 * Ereignisverarbeitung Schliessen des Fensters,
 * Programm wird beendet.
 */
  public void windowClosing( WindowEvent we)
  {
    view.release();
  }
}
