/**
 * 
 */
package de.mvenema.schere_stein_papier;

import java.util.ArrayList;
import java.util.HashMap;

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

	@Test
	public void testeHoleWuerfeErwarteSize2() {
		SoftAssertions softly = new SoftAssertions();
		ArrayList<Spieler> spielerList = new ArrayList<>();
		spielerList.add(new Spieler(TesteSpieler.NAME_SPIELER1));
		spielerList.add(new Spieler(TesteSpieler.NAME_SPIELER2));
		Spielzug spielzug = new Spielzug(spielerList);
		softly.assertThat(spielzug.getWuerfe()).size().isEqualTo(2);
		softly.assertAll();
	}
	
	@Test
	public void testeHoleWuerfeErwarteHashMap() {
		SoftAssertions softly = new SoftAssertions();
		ArrayList<Spieler> spielerList = new ArrayList<>();
		spielerList.add(new Spieler(TesteSpieler.NAME_SPIELER1));
		spielerList.add(new Spieler(TesteSpieler.NAME_SPIELER2));
		Spielzug spielzug = new Spielzug(spielerList);
		softly.assertThat(spielzug.getWuerfe()).isInstanceOf(HashMap.class);
		softly.assertAll();
	}
	
	@Test
	public void testeHoleWuerfeErwarteSpieler() {
		SoftAssertions softly = new SoftAssertions();
		ArrayList<Spieler> spielerList = new ArrayList<>();
		Spieler spieler1 = new Spieler(TesteSpieler.NAME_SPIELER1);
		Spieler spieler2 = new Spieler(TesteSpieler.NAME_SPIELER2);
		spielerList.add(spieler1);
		spielerList.add(spieler2);
		Spielzug spielzug = new Spielzug(spielerList);
		HashMap<Spieler, Spielzug.Symbol> wuerfe = spielzug.getWuerfe();
		softly.assertThat(wuerfe.containsKey(spieler1));
		softly.assertThat(wuerfe.containsKey(spieler2));

		softly.assertAll();
	}
	
	@Test
	public void testeHoleWuerfeErwarteSymbole() {
		SoftAssertions softly = new SoftAssertions();
		ArrayList<Spieler> spielerList = new ArrayList<>();
		Spieler spieler1 = new Spieler(TesteSpieler.NAME_SPIELER1);
		Spieler spieler2 = new Spieler(TesteSpieler.NAME_SPIELER2);
		spielerList.add(spieler1);
		spielerList.add(spieler2);
		Spielzug spielzug = new Spielzug(spielerList);
		HashMap<Spieler, Spielzug.Symbol> wuerfe = spielzug.getWuerfe();
		softly.assertThat(wuerfe.get(spieler1)).isInstanceOf(Spielzug.Symbol.class);
		softly.assertThat(wuerfe.get(spieler2)).isInstanceOf(Spielzug.Symbol.class);
		softly.assertAll();
	}
}
