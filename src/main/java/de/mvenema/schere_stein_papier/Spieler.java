/**
 * 
 */
package de.mvenema.schere_stein_papier;

import org.apache.commons.lang.StringUtils;

/**
 * Spieler.
 * @author michi
 *
 */
public class Spieler {

	/**
	 * Name.
	 */
	private final String name;
	/**
	 * Die konkrete Strategie.
	 */
	private final AbstractStrategie strategie;

	/**
	 * Konstruktor.
	 * @param p_name Name
	 * @param p_strategie Strategie
	 */
	public Spieler(final String p_name, final AbstractStrategie p_strategie) {
		if (!StringUtils.isEmpty(p_name)) {
			this.name = p_name;
		} else {
			throw new IllegalArgumentException("Parameter Name darf nicht leer sein.");
		}
		if (p_strategie != null) {
			this.strategie = p_strategie;
		} else {
			throw new IllegalArgumentException("Parameter Strategie darf nicht NULL sein.");
		}
	}

	/**
	 * Liefert den Namen.
	 * @return Name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Liefert das Symbol für den nächsten Wurf.
	 * @return Symbol für den nächsten Wurf
	 */
	public Spielzug.Symbol getWurf() {
		return this.strategie.getNaechstenWurf();
	}
	
	/**
	 * Liefert die Strategie.
	 * @return die Strategie
	 */
	public AbstractStrategie getStrategie() {
		return this.strategie;
	}

}
