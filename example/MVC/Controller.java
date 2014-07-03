// Controller.java                              MM 2007
// MVC-Controller-Grundstruktur, einfache Variante

/**
 * Controller-Grundstruktur,
 * installiert und deinstalliert Controller,
 * als Ereignisverarbeiter.
 */
public class Controller
{
/* ------------------------------------------------- */
                                                 // MVC
/**
 * Mathematisches Modell,
 * enthaelt Funktionalitaet des Problems.
 */
  private Model model;

/**
 * Zum Controller gehoeriger View.
 */
  private View view;

/* ------------------------------------------------- */
                                    // MVC-Installation
/**
 * Konstruktor, initialisiert Model und View.
 * @param m Mathematisches Modell
 * @param v zum Controller gehoeriger View
 */
  public Controller( Model m, View v)
  {
    model = m;
    view = v;
  }

/* ------------------------------------------------- */
                                  // MVC-Deinstallation
/**
 * Deinstalliert MVC,
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
 * Verarbeiten von Eingaben.
 */
  public void handleEventMethoden()
  {
    // ...
  }
}
