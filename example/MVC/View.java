// View                                         MM 2007
// MVC-View-Grundstruktur, einfache Variante

import java.util.*;                         // Observer

/**
 * View-Grundstruktur,
 * stellt Model dar, installiert Controller.
 */
public class View
  implements Observer
{
/* ------------------------------------------------- */
                                                 // MVC
/**
 * Mathematisches Modell,
 * enthaelt Funktionalitaet des Problems.
 */
  private Model model;

/**
 * Zum View gehoeriger Controller.
 */
  private Controller controller;

/* ------------------------------------------------- */
                                    // MVC-Installation
/**
 * Konstruktor, setzt Ueberschrift und installiert MVC.
 * @param model Model, welches dargestellt werden soll
 * @param titel Ueberschrift
 */
  public View( Model model, String titel)
  {
// Titelzeile
    // ...
// Model
    this.model = model;
    this.model.addObserver( this);      // Ueberwachung
// Controller
    controller = makeController();
// View
    makeView();
  }

/**
 * Erzeugt Controller, Empfaenger fuer Ereignisse.
 * @return Controller fuer View
 */
  private Controller makeController()
  {
    Controller controller
    = new Controller( model, this);
    // ...
    return controller;
  }

/**
 * Erzeugt View, baut die Oberflaeche auf.
 */
  private void makeView()
  {
    // ...
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
    if( model != m) return;
    if( o == null)
    {
      // Model wird neu dargestellt
    }
    else
    {
      // Objekt wird neu dargestellt
    }
  }
}
