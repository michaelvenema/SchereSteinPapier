package de.mvenema.schere_stein_papier;

import de.mvenema.schere_stein_papier.Spielzug.Symbol;

/**
 * Konkrete Implementierung für die 'Strategie', immer Schere zu spielen.
 * @author michi
 *
 */
public class StrategieImmerSchere extends AbstractStrategie{

	@Override
	public Symbol getNaechstenWurf() {
		return Spielzug.Symbol.SCHERE;
	}
}
