// ZaehlerController.java                       MM 2007
// MVC-Controller

import Tools.IO.*;                  // Tastatureingaben

/**
 * Controller zum ZaehlerView.
 */
public class ZaehlerController
{
/* ------------------------------------------------- */
                                                 // MVC
/**
 * Mathematisches Modell,
 * enthaelt Funktionalitaet des Zaehler.
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

/* ------------------------------------------------- */
                                 // handleEvent-Methode
/**
 * Verarbeiten der Tastatureingaben.
 */
  public void start()
  { 
    String s = "";
    do
    {
      s = IOTools.readLine();
      if( s.equals( "j")) model.next();
      if( s.equals( "n")) break;
    }
    while( true);
    view.release();
  }
}
