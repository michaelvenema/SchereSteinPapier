/**
 * 
 */
package de.mvenema.schere_stein_papier;

import java.nio.file.Path;
import java.util.ArrayList;

/**
 * Ein Spiel.
 * @author michi
 *
 */
public class Spiel {

	/**
	 * Innere Klasse, kapselt das Spielergebnis.
	 * @author michi
	 *
	 */
	public class Spielergebnis {

		/**
		 * Liefert die Spielzüge des Spiels.
		 * @return die Spielzüge des Spiels
		 */
		public ArrayList<Spielzug> getGespielteZuege() {
			return Spiel.this.spielZuege;
		}

		/**
		 * Liefert die Mitspieler.
		 * @return die Mitspieler
		 */
		public ArrayList<Spieler> getSpieler() {
			return Spiel.this.spielerList;
		}

		/**
		 * Wie oft hat der übergebene Spieler gewonnen?
		 * @param p_spieler der Spieler
		 * @return Anzahl Siege
		 */
		public int getSiege(final Spieler p_spieler) {
			int result = 0;
			for (Spielzug spielzug : Spiel.this.spielZuege) {
				if (spielzug.werIstSieger().size() > 0 && spielzug.werIstSieger().get(0).equals(p_spieler)) {
					result += 1;
				}
			}
			return result;
		}

		/**
		 * Wie oft ist ein Spielzug unentschieden ausgegangen?
		 * @return Anzahl unentschieden
		 */
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

	/**
	 * Default-Wert für die Anzahl der Spielzüge.
	 */
	protected static final int DEFAULT_ANZAHL_SPIELZUEGE = 10;
	/**
	 * Liste der Spieler.
	 */
	private final ArrayList<Spieler> spielerList = new ArrayList<Spieler>();
	/**
	 * Anzahl der zu spielenden Züge
	 */
	private int anzahlSpielZuege = 0;
	/**
	 * Die gespielten Züge.
	 */
	private ArrayList<Spielzug> spielZuege = new ArrayList<Spielzug>();
	/**
	 * Das Spielergebnis.
	 */
	private Spielergebnis spielergebnis = null;

	/**
	 * Konstruktor.
	 * @param p_spieler1 Spieler 1
	 * @param p_spieler2 Spieler 2
	 */
	public Spiel(final Spieler p_spieler1, final Spieler p_spieler2) {
		this.spielerList.add(p_spieler1);
		this.spielerList.add(p_spieler2);
	}

	/**
	 * Liefert die Liste der Spieler.
	 * @return
	 */
	public ArrayList<Spieler> getSpieler() {
		return this.spielerList;
	}

	/**
	 * Liefert die Anzahl der zu spielenden Züge.
	 * @return Anzahl der zu spielenden Züge
	 */
	public int getAnzahlSpielzuege() {
		return this.anzahlSpielZuege;
	}

	/**
	 * Spielt das Spiel mit der Default-Anzahl Spielzüge.
	 */
	public void spieleSpiel() {
		this.spieleSpiel(DEFAULT_ANZAHL_SPIELZUEGE);
	}

	/**
	 * Spielt das Spiel mit der übergebenen Anzahl Spielzüge.
	 * @param Anzahl Spielzüge.
	 */
	public void spieleSpiel(final int p_anzahlSpielzuege) {
		this.anzahlSpielZuege = p_anzahlSpielzuege;
		for (int i = 1; i <= this.anzahlSpielZuege; i++) {
			this.spielZuege.add(new Spielzug(this.spielerList));
		}
		this.spielergebnis = new Spielergebnis();
	}

	/**
	 * @deprecated use Spielergebnis.getGespielteZuege instead
	 * @return
	 */
	@Deprecated
	public ArrayList<Spielzug> getGespielteZuege() {
		return this.spielZuege;
	}

	/**
	 * Liefert das Spielergebnis.
	 * @return Spielergebnis
	 */
	public Spielergebnis getSpielergebnis() {
		return this.spielergebnis;
	}
}
