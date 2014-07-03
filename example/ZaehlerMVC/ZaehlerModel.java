// ZaehlerModel                                 MM 2007
// MVC-Model

import java.util.*;                       // Observable

/**
 * Zaehler modulo 10,
 * Version Konsole/Tastatur.
 */
public class ZaehlerModel
  extends Observable
{
                                            // coreData
/**
 * Zaehler.
 */
  private int count = 0;

/* ------------------------------------------------- */
                                     // getData-Methode
/**
 * Lesen des Zaehlers.
 * @return Zaehlerstand
 */
  public int getCount()
  {
    return count;
  } 

/* ------------------------------------------------- */
                                     // service-Methode
/**
 * Zaehlen.
 */
  public void next()
  {
    count = (count + 1) % 10;  // Wert wurde veraendert

    setChanged();                 // Aenderung anzeigen
    notifyObservers( new Integer( count));
  }
}
