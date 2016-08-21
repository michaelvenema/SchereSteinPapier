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

	public class Spielergebnis {

		public Spielergebnis() {
		}

		public ArrayList<Spielzug> getGespielteZuege() {
			return Spiel.this.spielZuege;
		}

		public ArrayList<Spieler> getSpieler() {
			return Spiel.this.spielerList;
		}

		public int getSiege(final Spieler p_spieler) {
			int result = 0;
			for (Spielzug spielzug : Spiel.this.spielZuege) {
				if (spielzug.werIstSieger().size() > 0 && spielzug.werIstSieger().get(0).equals(p_spieler)) {
					result += 1;
				}
			}
			return result;
		}

		public int getUnentschieden() {
			int result = 0;
			for (Spielzug spielzug : Spiel.this.spielZuege) {
				if (spielzug.werIstSieger().size() == 0) {
					result += 1;
				}
			}
			return result;
		}
	}

	protected static final int DEFAULT_ANZAHL_SPIELZUEGE = 10;
	private final ArrayList<Spieler> spielerList = new ArrayList<Spieler>();
	private int anzahlSpielZuege = 0;
	private ArrayList<Spielzug> spielZuege = new ArrayList<Spielzug>();
	private Spielergebnis spielergebnis = null;

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
		this.spieleSpiel(DEFAULT_ANZAHL_SPIELZUEGE);
	}

	public void spieleSpiel(final int p_anzahlSpielzuege) {
		this.anzahlSpielZuege = p_anzahlSpielzuege;
		for (int i = 1; i <= this.anzahlSpielZuege; i++) {
			this.spielZuege.add(new Spielzug(this.spielerList));
		}
		this.spielergebnis = new Spielergebnis();
	}

	/**
	 * @deprecated use Spielergebnis.getGespielteZuge instead
	 * @return
	 */
	@Deprecated
	public ArrayList<Spielzug> getGespielteZuege() {
		return this.spielZuege;
	}

	public Spielergebnis getSpielergebnis() {
		return this.spielergebnis;
	}
}
