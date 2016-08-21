package de.mvenema.schere_stein_papier;

import de.mvenema.schere_stein_papier.Spielzug.Symbol;

public class StrategieImmerStein extends AbstractStrategie{

	public StrategieImmerStein() {
		
	}

	@Override
	public Symbol getNaechstenWurf() {
		return Spielzug.Symbol.STEIN;
	}
}
