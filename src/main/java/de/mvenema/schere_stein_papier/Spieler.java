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

	public Spieler(final String p_name) {
		if (!StringUtils.isEmpty(p_name)) {
			this.name = p_name;
		} else {
			throw new IllegalArgumentException("Parameter Name darf nicht leer sein.");
		}

	}

	public String getName() {
		return this.name;
	}

}
