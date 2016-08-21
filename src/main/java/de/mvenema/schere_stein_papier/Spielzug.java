package de.mvenema.schere_stein_papier;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

public class Spielzug {

	public enum Symbol {

	}
	
	private HashMap<Spieler, Spielzug.Symbol> spielzugMap = new HashMap<Spieler, Spielzug.Symbol>();

	public Spielzug(final ArrayList<Spieler> p_spielerList) {
		if (p_spielerList != null && p_spielerList.size() == 2 && p_spielerList.get(0) != null && p_spielerList.get(1) != null) {
			this.spielzugMap.put(p_spielerList.get(0), null);
			this.spielzugMap.put(p_spielerList.get(1), null);
		} else {
			throw new IllegalArgumentException("Die Spielerliste muss genau 2 Spieler enthalten");
		}
	}

	public HashMap<Spieler, Spielzug.Symbol> getWuerfe() {
		// TODO Auto-generated method stub
		return null;
	}

}
