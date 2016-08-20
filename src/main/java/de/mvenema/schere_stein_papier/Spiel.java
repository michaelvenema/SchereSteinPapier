/**
 * 
 */
package de.mvenema.schere_stein_papier;

import java.nio.file.Path;
import java.util.ArrayList;

/**
 * @author michi
 *
 */
public class Spiel {	

	protected static final int DEFAULT_ANZAHL_SPIELZUEGE = 10;
	private final ArrayList<Spieler> spielerList = new ArrayList<Spieler>();
	
	public Spiel(final Spieler p_spieler1, final Spieler p_spieler2) {
		this.spielerList.add(p_spieler1);
		this.spielerList.add(p_spieler2);
	}

	public ArrayList<Spieler> getSpieler() {
		return this.spielerList;
	}
}
