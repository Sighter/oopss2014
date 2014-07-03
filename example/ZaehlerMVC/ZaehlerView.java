// ZaehlerView                                  MM 2007
// MVC-View

import java.util.*;                         // Observer

/**
 * View zum Zaehler modulo 10,
 * Version Konsole/Tastatur.
 */
public class ZaehlerView
  implements Observer
{
/* ------------------------------------------------- */
                                                 // MVC
/**
 * Mathematisches Modell,
 * enthaelt Funktionalitaet des Zeahlers.
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
    System.out.println( titel);
// Model
    this.model = model;
    this.model.addObserver( this);      // Ueberwachung
// Controller
    controller = makeController();
// View
    makeView();
  }

/**
 * Erzeugt Controller.
 * @return Controller fuer View
 */
  private ZaehlerController makeController()
  {
    return new ZaehlerController( model, this);
  }

/**
 * Erzeugt View, startet Controller.
 */
  private void makeView()
  {
    System.out.println( "" + model.getCount());
    System.out.print( "Weiter (j/n): ");
    controller.start();
  }

/* ------------------------------------------------- */
                                  // MVC-Deinstallation
/**
 * Deinstalliert MVC,
 * setzt Model und Controller zurück.
 */
  public void release()
  {
// Controller
    controller.release();
    controller = null;
// Model
    model.deleteObserver( this);
    model = null;
  }

/* ------------------------------------------------- */
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
    {
      System.out.println( "" + model.getCount());
      System.out.print( "Weiter (j/n): ");
    }
  }
}
