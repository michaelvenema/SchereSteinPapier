/**
 * 
 */
package de.mvenema.schere_stein_papier;

import java.util.Random;

import de.mvenema.schere_stein_papier.Spielzug.Symbol;

/**
 * Konkrete Implementierung für eine zufallsbasierte Strategie.
 * @author michi
 *
 */
public class StrategieZufall extends AbstractStrategie {

	/* (non-Javadoc)
	 * @see de.mvenema.schere_stein_papier.AbstractStrategie#getNaechstenWurf()
	 */
	@Override
	public Symbol getNaechstenWurf() {
		Random random = new Random();
		int randomValue = random.nextInt(3);
		return Spielzug.Symbol.values()[randomValue];
	}

}
