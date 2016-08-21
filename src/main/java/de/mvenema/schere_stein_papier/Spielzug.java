package de.mvenema.schere_stein_papier;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

public class Spielzug {

	public enum Symbol {
		SCHERE,
		STEIN,
		PAPIER;
	}
	
	private final ArrayList<Spieler> spielerList;
	private HashMap<Spieler, Spielzug.Symbol> spielzugMap = new HashMap<Spieler, Spielzug.Symbol>();

	public Spielzug(final ArrayList<Spieler> p_spielerList) {
		if (p_spielerList != null && p_spielerList.size() == 2 && p_spielerList.get(0) != null && p_spielerList.get(1) != null) {
			this.spielerList = p_spielerList;
			Spieler spieler1 = this.spielerList.get(0);
			Spieler spieler2 = this.spielerList.get(1);
			this.spielzugMap.put(spieler1, spieler1.getWurf());
			this.spielzugMap.put(spieler2, spieler2.getWurf());
		} else {
			throw new IllegalArgumentException("Die Spielerliste muss genau 2 Spieler enthalten");
		}
	}

	public HashMap<Spieler, Spielzug.Symbol> getWuerfe() {
		return this.spielzugMap;
	}

}
