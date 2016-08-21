package de.mvenema.schere_stein_papier;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Stellt einen Spielzug innerhalb eines Spiels dar.
 * @author michi
 *
 */
public class Spielzug {

	/**
	 * Ergebnis. Wie kann es ausgehen?
	 * @author michi
	 *
	 */
	public enum Ergebnis {
		SCHLAEGT, UNENTSCHIEDEN, WIRD_GESCHLAGEN;
	}

	/**
	 * Die erlaubten Symbole.
	 * @author michi
	 *
	 */
	public enum Symbol {
		SCHERE, STEIN, PAPIER;

		public Spielzug.Ergebnis getErgebnis(final Spielzug.Symbol p_gegner) {
			Spielzug.Ergebnis result = null;
			if (this.equals(p_gegner)) {
				return Spielzug.Ergebnis.UNENTSCHIEDEN;
			} else if (this.equals(Symbol.SCHERE)) {
				if (p_gegner.equals(Symbol.STEIN)) {
					result = Spielzug.Ergebnis.WIRD_GESCHLAGEN;
				} else {
					result = Spielzug.Ergebnis.SCHLAEGT;
				}
			} else if (this.equals(Symbol.STEIN)) {
				if (p_gegner.equals(Symbol.SCHERE)) {
					result = Spielzug.Ergebnis.SCHLAEGT;
				} else {
					result = Spielzug.Ergebnis.WIRD_GESCHLAGEN;
				}
			} else if (this.equals(Symbol.PAPIER)) {
				if (p_gegner.equals(Symbol.SCHERE)) {
					result = Spielzug.Ergebnis.WIRD_GESCHLAGEN;
				} else {
					result = Spielzug.Ergebnis.SCHLAEGT;
				}
			}
			return result;
		}
	}

	/**
	 * Liste der Spieler.
	 */
	private final ArrayList<Spieler> spielerList;
	/**
	 * Alle Würfe des Spielzugs.
	 */
	private HashMap<Spieler, Spielzug.Symbol> spielzugMap = new HashMap<Spieler, Spielzug.Symbol>();

	/**
	 * Konstruktor.
	 * @param p_spielerList Liste der Spieler
	 */
	public Spielzug(final ArrayList<Spieler> p_spielerList) {
		if (p_spielerList != null && p_spielerList.size() == 2 && p_spielerList.get(0) != null
				&& p_spielerList.get(1) != null) {
			this.spielerList = p_spielerList;
			Spieler spieler1 = this.spielerList.get(0);
			Spieler spieler2 = this.spielerList.get(1);
			this.spielzugMap.put(spieler1, spieler1.getWurf());
			this.spielzugMap.put(spieler2, spieler2.getWurf());
		} else {
			throw new IllegalArgumentException("Die Spielerliste muss genau 2 Spieler enthalten");
		}
	}

	/**
	 * Liefert die Würfe des Spielzugs.
	 * @return Würfe des Spielzugs
	 */
	public HashMap<Spieler, Spielzug.Symbol> getWuerfe() {
		return this.spielzugMap;
	}

	/**
	 * Wer hat diesen Spielzug gewonnen?
	 * @return ArrayList mit dem Sieger ais einzigem Element oder ArrayList der Länge 0, wenn unentschieden
	 */
	public ArrayList<Spieler> werIstSieger() {
		ArrayList<Spieler> result = new ArrayList<>();
		Spieler spieler1 = this.spielerList.get(0);
		Spieler spieler2 = this.spielerList.get(1);
		if (this.spielzugMap.get(spieler1).getErgebnis(this.spielzugMap.get(spieler2)).equals(Ergebnis.SCHLAEGT)) {
			result.add(spieler1);
		} else if (this.spielzugMap.get(spieler1).getErgebnis(this.spielzugMap.get(spieler2)).equals(Ergebnis.WIRD_GESCHLAGEN)) {
			result.add(spieler2);
		}
		return result;
	}

}
