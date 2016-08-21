package de.mvenema.schere_stein_papier;

import de.mvenema.schere_stein_papier.Spielzug.Symbol;

public class StrategieImmerSchere extends AbstractStrategie{

	public StrategieImmerSchere() {
		
	}

	@Override
	public Symbol getNaechstenWurf() {
		return Spielzug.Symbol.SCHERE;
	}
}
