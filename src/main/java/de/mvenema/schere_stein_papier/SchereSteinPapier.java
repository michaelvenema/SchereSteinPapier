package de.mvenema.schere_stein_papier;

import de.mvenema.schere_stein_papier.Spiel.Spielergebnis;

public class SchereSteinPapier {

	public static void main(String[] args) {
		int anzahlSpielzuege = 100;
		Spieler spieler1 = new Spieler("Jane Doe", new StrategieImmerStein());
		Spieler spieler2 = new Spieler("John Doe", new StrategieZufall());
		Spiel spiel = new Spiel(spieler1, spieler2);
		spiel.spieleSpiel(anzahlSpielzuege);
		Spielergebnis spielergebnis = spiel.getSpielergebnis();
		int siegeSpieler1 = spielergebnis.getSiege(spieler1);
		int siegeSpieler2 = spielergebnis.getSiege(spieler2);
		int unentschieden = spielergebnis.getUnentschieden();
		int summe = siegeSpieler1 + siegeSpieler2 + unentschieden;
		StringBuilder sb = new StringBuilder();
		sb.append("Es wurden ");
		sb.append(summe);
		sb.append(" Spielzüge gespielt.");
		System.out.println(sb.toString());
		sb = new StringBuilder();
		sb.append("Spieler 1 ");
		sb.append(spieler1.getName());
		sb.append(" hat mit der Strategie ");
		sb.append(spieler1.getStrategie().getClass().getSimpleName());
		sb.append(" ");
		sb.append(siegeSpieler1);
		sb.append(" Spielzüge gewonnen.");		
		System.out.println(sb.toString());
		sb = new StringBuilder();
		sb.append("Spieler 2 ");
		sb.append(spieler2.getName());
		sb.append(" hat mit der Strategie ");
		sb.append(spieler2.getStrategie().getClass().getSimpleName());
		sb.append(" ");
		sb.append(siegeSpieler2);
		sb.append(" Spielzüge gewonnen.");		
		System.out.println(sb.toString());
		sb = new StringBuilder();
		sb.append("Unentschieden endeten ");
		sb.append(unentschieden);
		sb.append(" Spielzüge.");
		System.out.println(sb.toString());
	}

}
