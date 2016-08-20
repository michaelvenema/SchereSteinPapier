/**
 * 
 */
package de.mvenema.schere_stein_papier;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

/**
 * @author michi
 *
 */
public class TesteSpiel {

	@Test
	public void testeInitSpielErwarteInstanz() {
		SoftAssertions softly = new SoftAssertions();
		Spieler spieler1 = new Spieler(TesteSpieler.NAME_SPIELER1);
		Spieler spieler2 = new Spieler(TesteSpieler.NAME_SPIELER2);
		Spiel spiel = new Spiel(spieler1, spieler2);
		softly.assertThat(spiel).isNotNull();
		softly.assertThat(spiel).isInstanceOf(Spiel.class);
		softly.assertAll();
	}

	@Test
	public void testeInitSpielErwarteAnzahlSpieler2() {
		SoftAssertions softly = new SoftAssertions();
		Spieler spieler1 = new Spieler(TesteSpieler.NAME_SPIELER1);
		Spieler spieler2 = new Spieler(TesteSpieler.NAME_SPIELER2);
		Spiel spiel = new Spiel(spieler1, spieler2);
		softly.assertThat(spiel.getSpieler()).size().isEqualTo(2);
		softly.assertAll();
	}

	@Test
	public void testeInitSpielErwarte2DefinierteSpieler() {
		SoftAssertions softly = new SoftAssertions();
		Spieler spieler1 = new Spieler(TesteSpieler.NAME_SPIELER1);
		Spieler spieler2 = new Spieler(TesteSpieler.NAME_SPIELER2);
		Spiel spiel = new Spiel(spieler1, spieler2);
		softly.assertThat(spiel.getSpieler()).containsExactly(spieler1, spieler2);
		softly.assertAll();
	}
	
	@Test
	public void testeInitSpielErwarteAnzahlSpielzuege0() {
		SoftAssertions softly = new SoftAssertions();
		Spieler spieler1 = new Spieler(TesteSpieler.NAME_SPIELER1);
		Spieler spieler2 = new Spieler(TesteSpieler.NAME_SPIELER2);
		Spiel spiel = new Spiel(spieler1, spieler2);
		softly.assertThat(spiel.getAnzahlSpielzuege()).isEqualTo(0);
		softly.assertAll();
	}
	
//	@Test
//	public void starteSpielDefaultErwarteAnzahlSpielzuegeDefault() {
//		SoftAssertions softly = new SoftAssertions();
//		Spieler spieler1 = new Spieler(TesteSpieler.NAME_SPIELER1);
//		Spieler spieler2 = new Spieler(TesteSpieler.NAME_SPIELER2);
//		Spiel spiel = new Spiel(spieler1, spieler2);
//		spiel.starteSpiel();
//		softly.assertThat(spiel)
//		softly.assertAll();
//	}
}
