/**
 * 
 */
package de.mvenema.schere_stein_papier;

import java.util.ArrayList;

import org.assertj.core.api.SoftAssertions;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Test;

/**
 * @author michi
 *
 */
public class TesteSpielzug {

	@Test
	public void testeInitEwarteInstanz() {
		SoftAssertions softly = new SoftAssertions();
		ArrayList<Spieler> spielerList = new ArrayList<>();
		spielerList.add(new Spieler(TesteSpieler.NAME_SPIELER1));
		spielerList.add(new Spieler(TesteSpieler.NAME_SPIELER2));
		softly.assertThat(new Spielzug(spielerList)).isInstanceOf(Spielzug.class);
		softly.assertAll();
	}

	@Test
	public void testeInitMit1SpielerErwarteException() {
		SoftAssertions softly = new SoftAssertions();
		ArrayList<Spieler> spielerList = new ArrayList<>();
		spielerList.add(new Spieler(TesteSpieler.NAME_SPIELER1));
		softly.assertThatThrownBy(() -> new Spielzug(spielerList)).isInstanceOf(IllegalArgumentException.class);
		softly.assertAll();
	}

	@Test
	public void testeInitMit3SpielerErwarteException() {
		SoftAssertions softly = new SoftAssertions();
		ArrayList<Spieler> spielerList = new ArrayList<>();
		spielerList.add(new Spieler(TesteSpieler.NAME_SPIELER1));
		spielerList.add(new Spieler(TesteSpieler.NAME_SPIELER2));
		spielerList.add(new Spieler(TesteSpieler.NAME_SPIELER1));
		softly.assertThatThrownBy(() -> new Spielzug(spielerList)).isInstanceOf(IllegalArgumentException.class);
		softly.assertAll();
	}

//	@Test
//	public void testeHoleWuerfeErwarteSize2() {
//		SoftAssertions softly = new SoftAssertions();
//		ArrayList<Spieler> spielerList = new ArrayList<>();
//		spielerList.add(new Spieler(TesteSpieler.NAME_SPIELER1));
//		spielerList.add(new Spieler(TesteSpieler.NAME_SPIELER2));
//		Spielzug spielzug = new Spielzug(spielerList);
//		softly.assertThat(spielzug.getWuerfe()).size().isEqualTo(2);
//		softly.assertAll();
//	}
}
