/**
 * 
 */
package de.mvenema.schere_stein_papier;

import org.apache.commons.lang.StringUtils;

/**
 * @author michi
 *
 */
public class Spieler {

	private final String name;
	private final AbstractStrategie strategie;

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

	public String getName() {
		return this.name;
	}

}
