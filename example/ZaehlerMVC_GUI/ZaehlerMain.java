// ZaehlerMain.java                             MM 2007
// MVC-Main

/**
 * Simulation eines Zaehlers modulo 10.
 * Version mit Benutzeroberflaeche.
 */

public class ZaehlerMain
{
/**
 * Starten des Zaehlerprogramms mit MVC-Architektur,
 * Initialisiere Model mit einem View.
 */
  public static void main( String args[])
  {
// View, Uebergabe des Model
    ZaehlerView view = new ZaehlerView
            ( new ZaehlerModel(), "Zaehler modulo 10");
  }
}
