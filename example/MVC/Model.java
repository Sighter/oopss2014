// Model                                        MM 2007
// MVC-Model-Grundstruktur, einfache Variante

import java.util.*;                       // Observable

/**
 * Model-Grundstruktur
 * (ttt steht fuer einen beliebigen Datentyp).
 */
public class Model
  extends Observable
{
/**
 * coreData.
 */
  private ttt coreData = value;

/* ------------------------------------------------- */
/**
 * getData-Methoden, Lesen von Daten.
 * @return coreData
 */
  public ttt getData()
  {
    return coreData;
  }

/* ------------------------------------------------- */
/**
 * service-Methoden, Aendern von Daten.
 */
  public void service( ttt args)
  {
    // ...                          // coreData aendern

    setChanged();                 // Aenderung anzeigen
    notifyObservers( coreDataObject);
  }
}
