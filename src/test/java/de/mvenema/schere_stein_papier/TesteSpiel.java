/**
 * 
 */
package de.mvenema.schere_stein_papier;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import de.mvenema.schere_stein_papier.Spiel.Spielergebnis;

/**
 * @author michi
 *
 */
public class TesteSpiel {

	@Test
	public void testeInitSpielErwarteInstanz() {
		SoftAssertions softly = new SoftAssertions();
		Spieler spieler1 = new Spieler(TesteSpieler.NAME_SPIELER1, new StrategieImmerStein());
		Spieler spieler2 = new Spieler(TesteSpieler.NAME_SPIELER2, new StrategieZufall());
		Spiel spiel = new Spiel(spieler1, spieler2);
		softly.assertThat(spiel).isNotNull();
		softly.assertThat(spiel).isInstanceOf(Spiel.class);
		softly.assertAll();
	}

	@Test
	public void testeInitSpielErwarteAnzahlSpieler2() {
		SoftAssertions softly = new SoftAssertions();
		Spieler spieler1 = new Spieler(TesteSpieler.NAME_SPIELER1, new StrategieImmerStein());
		Spieler spieler2 = new Spieler(TesteSpieler.NAME_SPIELER2, new StrategieZufall());
		Spiel spiel = new Spiel(spieler1, spieler2);
		softly.assertThat(spiel.getSpieler()).size().isEqualTo(2);
		softly.assertAll();
	}

	@Test
	public void testeInitSpielErwarte2DefinierteSpieler() {
		SoftAssertions softly = new SoftAssertions();
		Spieler spieler1 = new Spieler(TesteSpieler.NAME_SPIELER1, new StrategieImmerStein());
		Spieler spieler2 = new Spieler(TesteSpieler.NAME_SPIELER2, new StrategieZufall());
		Spiel spiel = new Spiel(spieler1, spieler2);
		softly.assertThat(spiel.getSpieler()).containsExactly(spieler1, spieler2);
		softly.assertAll();
	}
	
	@Test
	public void testeInitSpielErwarteAnzahlSpielzuege0() {
		SoftAssertions softly = new SoftAssertions();
		Spieler spieler1 = new Spieler(TesteSpieler.NAME_SPIELER1, new StrategieImmerStein());
		Spieler spieler2 = new Spieler(TesteSpieler.NAME_SPIELER2, new StrategieZufall());
		Spiel spiel = new Spiel(spieler1, spieler2);
		softly.assertThat(spiel.getAnzahlSpielzuege()).isEqualTo(0);
		softly.assertAll();
	}
	
	@Test
	public void starteSpielDefaultErwarteAnzahlSpielzuegeDefault() {
		SoftAssertions softly = new SoftAssertions();
		Spieler spieler1 = new Spieler(TesteSpieler.NAME_SPIELER1, new StrategieImmerStein());
		Spieler spieler2 = new Spieler(TesteSpieler.NAME_SPIELER2, new StrategieZufall());
		Spiel spiel = new Spiel(spieler1, spieler2);
		spiel.spieleSpiel();
		softly.assertThat(spiel.getAnzahlSpielzuege()).isEqualTo(Spiel.DEFAULT_ANZAHL_SPIELZUEGE);
		softly.assertAll();
	}
	
	@Test
	public void starteSpielErwarteAnzahlSpielzuege() {
		int anzahlSpielzuege = 100;
		SoftAssertions softly = new SoftAssertions();
		Spieler spieler1 = new Spieler(TesteSpieler.NAME_SPIELER1, new StrategieImmerStein());
		Spieler spieler2 = new Spieler(TesteSpieler.NAME_SPIELER2, new StrategieZufall());
		Spiel spiel = new Spiel(spieler1, spieler2);
		spiel.spieleSpiel(anzahlSpielzuege);
		softly.assertThat(spiel.getAnzahlSpielzuege()).isEqualTo(anzahlSpielzuege);
		softly.assertAll();
	}
	
	@Test
	public void starteSpielErwarteAnzahlGespielterZuege() {
		int anzahlSpielzuege = 100;
		SoftAssertions softly = new SoftAssertions();
		Spieler spieler1 = new Spieler(TesteSpieler.NAME_SPIELER1, new StrategieImmerStein());
		Spieler spieler2 = new Spieler(TesteSpieler.NAME_SPIELER2, new StrategieZufall());
		Spiel spiel = new Spiel(spieler1, spieler2);
		spiel.spieleSpiel(anzahlSpielzuege);
		softly.assertThat(spiel.getGespielteZuege()).size().isEqualTo(anzahlSpielzuege);
		softly.assertAll();
	}
	
	@Test
	public void initialisiereSpielHoleSpielergebnisErwarteNull() {
		SoftAssertions softly = new SoftAssertions();
		Spieler spieler1 = new Spieler(TesteSpieler.NAME_SPIELER1, new StrategieImmerStein());
		Spieler spieler2 = new Spieler(TesteSpieler.NAME_SPIELER2, new StrategieZufall());
		Spiel spiel = new Spiel(spieler1, spieler2);
		softly.assertThat(spiel.getSpielergebnis()).isNull();
		softly.assertAll();
	}
	
	@Test
	public void spieleSpielHoleSpielergebnisErwarteInstanz() {
		int anzahlSpielzuege = 100;
		SoftAssertions softly = new SoftAssertions();
		Spieler spieler1 = new Spieler(TesteSpieler.NAME_SPIELER1, new StrategieImmerStein());
		Spieler spieler2 = new Spieler(TesteSpieler.NAME_SPIELER2, new StrategieZufall());
		Spiel spiel = new Spiel(spieler1, spieler2);
		spiel.spieleSpiel(anzahlSpielzuege);
		softly.assertThat(spiel.getSpielergebnis()).isInstanceOf(Spiel.Spielergebnis.class);
		softly.assertAll();
	}
	
	@Test
	public void starteSpielErwarteAnzahlGespielterZuegeAusSpielergebnis() {
		int anzahlSpielzuege = 100;
		SoftAssertions softly = new SoftAssertions();
		Spieler spieler1 = new Spieler(TesteSpieler.NAME_SPIELER1, new StrategieImmerStein());
		Spieler spieler2 = new Spieler(TesteSpieler.NAME_SPIELER2, new StrategieZufall());
		Spiel spiel = new Spiel(spieler1, spieler2);
		spiel.spieleSpiel(anzahlSpielzuege);
		softly.assertThat(spiel.getSpielergebnis().getGespielteZuege()).size().isEqualTo(anzahlSpielzuege);
		softly.assertAll();
	}
	
	@Test
	public void starteSpielErwarteSpielerAusSpielergebnis() {
		int anzahlSpielzuege = 100;
		SoftAssertions softly = new SoftAssertions();
		Spieler spieler1 = new Spieler(TesteSpieler.NAME_SPIELER1, new StrategieImmerStein());
		Spieler spieler2 = new Spieler(TesteSpieler.NAME_SPIELER2, new StrategieZufall());
		Spiel spiel = new Spiel(spieler1, spieler2);
		spiel.spieleSpiel(anzahlSpielzuege);
		Spielergebnis spielergebnis = spiel.getSpielergebnis();
		softly.assertThat(spielergebnis.getSpieler()).containsExactly(spieler1, spieler2);
		softly.assertAll();
	}
	
	@Test
	public void starteSpielErwarteSiegeSpieler1AusSpielergebnis() {
		int anzahlSpielzuege = 100;
		SoftAssertions softly = new SoftAssertions();
		Spieler spieler1 = new Spieler(TesteSpieler.NAME_SPIELER1, new StrategieImmerStein());
		Spieler spieler2 = new Spieler(TesteSpieler.NAME_SPIELER2, new StrategieZufall());
		Spiel spiel = new Spiel(spieler1, spieler2);
		spiel.spieleSpiel(anzahlSpielzuege);
		Spielergebnis spielergebnis = spiel.getSpielergebnis();
		softly.assertThat(spielergebnis.getSiege(spieler1)).isBetween(20, 50);
		softly.assertAll();
	}
	
	@Test
	public void starteSpielErwarteSiegeSpieler2AusSpielergebnis() {
		int anzahlSpielzuege = 100;
		SoftAssertions softly = new SoftAssertions();
		Spieler spieler1 = new Spieler(TesteSpieler.NAME_SPIELER1, new StrategieImmerStein());
		Spieler spieler2 = new Spieler(TesteSpieler.NAME_SPIELER2, new StrategieZufall());
		Spiel spiel = new Spiel(spieler1, spieler2);
		spiel.spieleSpiel(anzahlSpielzuege);
		Spielergebnis spielergebnis = spiel.getSpielergebnis();
		softly.assertThat(spielergebnis.getSiege(spieler2)).isBetween(20, 50);
		softly.assertAll();
	}
	
	@Test
	public void starteSpielErwarteUnentschiedenAusSpielergebnis() {
		int anzahlSpielzuege = 100;
		SoftAssertions softly = new SoftAssertions();
		Spieler spieler1 = new Spieler(TesteSpieler.NAME_SPIELER1, new StrategieImmerStein());
		Spieler spieler2 = new Spieler(TesteSpieler.NAME_SPIELER2, new StrategieZufall());
		Spiel spiel = new Spiel(spieler1, spieler2);
		spiel.spieleSpiel(anzahlSpielzuege);
		Spielergebnis spielergebnis = spiel.getSpielergebnis();
		softly.assertThat(spielergebnis.getUnentschieden()).isBetween(20, 50);
		softly.assertAll();
	}
	
	@Test
	public void starteSpielErwarteSummeWieAnzahlZuege() {
		int anzahlSpielzuege = 100;
		SoftAssertions softly = new SoftAssertions();
		Spieler spieler1 = new Spieler(TesteSpieler.NAME_SPIELER1, new StrategieImmerStein());
		Spieler spieler2 = new Spieler(TesteSpieler.NAME_SPIELER2, new StrategieZufall());
		Spiel spiel = new Spiel(spieler1, spieler2);
		spiel.spieleSpiel(anzahlSpielzuege);
		Spielergebnis spielergebnis = spiel.getSpielergebnis();
		int siegeSpieler1 = spielergebnis.getSiege(spieler1);
		int siegeSpieler2 = spielergebnis.getSiege(spieler2);
		int unentschieden = spielergebnis.getUnentschieden();
		int summe = siegeSpieler1 + siegeSpieler2 + unentschieden;
		softly.assertThat(summe).isEqualTo(anzahlSpielzuege);
		System.out.println(siegeSpieler1);
		System.out.println(siegeSpieler2);
		System.out.println(unentschieden);
		System.out.println(summe);
		softly.assertAll();
	}
	
	
}
