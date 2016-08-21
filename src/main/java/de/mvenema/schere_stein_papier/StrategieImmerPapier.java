package de.mvenema.schere_stein_papier;

import de.mvenema.schere_stein_papier.Spielzug.Symbol;

/**
 * Konkrete Implementierung für die 'Strategie', immer Papier zu spielen.
 * @author michi
 *
 */
public class StrategieImmerPapier extends AbstractStrategie{

	@Override
	public Symbol getNaechstenWurf() {
		return Spielzug.Symbol.PAPIER;
	}
}
