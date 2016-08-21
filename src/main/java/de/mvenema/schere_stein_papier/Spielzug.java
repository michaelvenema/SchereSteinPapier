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
		} else {
			throw new IllegalArgumentException("Die Spielerliste muss genau 2 Spieler enthalten");
		}
	}

	public HashMap<Spieler, Spielzug.Symbol> getWuerfe() {
		this.spielzugMap.put(this.spielerList.get(0), Symbol.PAPIER);
		this.spielzugMap.put(spielerList.get(1), Symbol.PAPIER);
		return this.spielzugMap;
	}

}
