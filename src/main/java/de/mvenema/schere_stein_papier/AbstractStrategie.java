/**
 * 
 */
package de.mvenema.schere_stein_papier;

/**
 * Abstrakte Basisklasse für Spielstrategien.
 * @author michi
 *
 */
public abstract class AbstractStrategie {
	
	/**
	 * Liefert das Symbol für den nächsten Wurf.
	 * @return das Symbol für den nächsten Wurf
	 */
	public abstract Spielzug.Symbol getNaechstenWurf();
}
