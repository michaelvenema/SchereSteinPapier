package de.mvenema.schere_stein_papier;

import de.mvenema.schere_stein_papier.Spielzug.Symbol;

/**
 * Konkrete Implementierung für die 'Strategie', immer Stein zu spielen.
 * @author michi
 *
 */
public class StrategieImmerStein extends AbstractStrategie{

	@Override
	public Symbol getNaechstenWurf() {
		return Spielzug.Symbol.STEIN;
	}
}
