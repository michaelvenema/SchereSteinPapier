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
	private int anzahlSpielZuege = 0;
	private ArrayList<Spielzug> spielZuege = new ArrayList<Spielzug>();
	
	public Spiel(final Spieler p_spieler1, final Spieler p_spieler2) {
		this.spielerList.add(p_spieler1);
		this.spielerList.add(p_spieler2);
	}

	public ArrayList<Spieler> getSpieler() {
		return this.spielerList;
	}

	public int getAnzahlSpielzuege() {
		return this.anzahlSpielZuege;
	}

	public void spieleSpiel() {
		this.anzahlSpielZuege = DEFAULT_ANZAHL_SPIELZUEGE;
	}

	public void spieleSpiel(final int p_anzahlSpielzuege) {
		this.anzahlSpielZuege = p_anzahlSpielzuege;		
	}

	public ArrayList<Spielzug> getGespielteZuege() {
		for (int i = 1; i <= this.anzahlSpielZuege; i++) {
			this.spielZuege.add(new Spielzug());
		}
		return this.spielZuege;
	}
}
