package de.mvenema.schere_stein_papier;

import de.mvenema.schere_stein_papier.Spielzug.Symbol;

public class StrategieImmerPapier extends AbstractStrategie{

	public StrategieImmerPapier() {
		
	}

	@Override
	public Symbol getNaechstenWurf() {
		return Spielzug.Symbol.PAPIER;
	}
}
