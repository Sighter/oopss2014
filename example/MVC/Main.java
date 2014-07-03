// Main.java                                    MM 2007
// MVC-Main-Grundstruktur, einfache Variante

/**
 * Initialisieren eines Model mit einem View.
 */
public class Main
{
/**
 * Starten eines Programms mit MVC-Architektur,
 * Initialisiere Modelmit einem View.
 */
  public static void main( String args[])
  {
    View view = new View( new Model(), "Titel");
  }
}
