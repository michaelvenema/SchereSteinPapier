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
		spielerList.add(new Spieler(TesteSpieler.NAME_SPIELER1, new StrategieImmerStein()));
		spielerList.add(new Spieler(TesteSpieler.NAME_SPIELER2, new StrategieZufall()));
		softly.assertThat(new Spielzug(spielerList)).isInstanceOf(Spielzug.class);
		softly.assertAll();
	}

	@Test
	public void testeInitMit1SpielerErwarteException() {
		SoftAssertions softly = new SoftAssertions();
		ArrayList<Spieler> spielerList = new ArrayList<>();
		spielerList.add(new Spieler(TesteSpieler.NAME_SPIELER1, new StrategieImmerStein()));
		softly.assertThatThrownBy(() -> new Spielzug(spielerList)).isInstanceOf(IllegalArgumentException.class);
		softly.assertAll();
	}

	@Test
	public void testeInitMit3SpielerErwarteException() {
		SoftAssertions softly = new SoftAssertions();
		ArrayList<Spieler> spielerList = new ArrayList<>();
		spielerList.add(new Spieler(TesteSpieler.NAME_SPIELER1, new StrategieImmerStein()));
		spielerList.add(new Spieler(TesteSpieler.NAME_SPIELER2, new StrategieZufall()));
		spielerList.add(new Spieler(TesteSpieler.NAME_SPIELER1, new StrategieImmerStein()));
		softly.assertThatThrownBy(() -> new Spielzug(spielerList)).isInstanceOf(IllegalArgumentException.class);
		softly.assertAll();
	}

	@Test
	public void testeHoleWuerfeErwarteSize2() {
		SoftAssertions softly = new SoftAssertions();
		ArrayList<Spieler> spielerList = new ArrayList<>();
		spielerList.add(new Spieler(TesteSpieler.NAME_SPIELER1, new StrategieImmerStein()));
		spielerList.add(new Spieler(TesteSpieler.NAME_SPIELER2, new StrategieZufall()));
		Spielzug spielzug = new Spielzug(spielerList);
		softly.assertThat(spielzug.getWuerfe()).size().isEqualTo(2);
		softly.assertAll();
	}
	
	@Test
	public void testeHoleWuerfeErwarteHashMap() {
		SoftAssertions softly = new SoftAssertions();
		ArrayList<Spieler> spielerList = new ArrayList<>();
		spielerList.add(new Spieler(TesteSpieler.NAME_SPIELER1, new StrategieImmerStein()));
		spielerList.add(new Spieler(TesteSpieler.NAME_SPIELER2, new StrategieZufall()));
		Spielzug spielzug = new Spielzug(spielerList);
		softly.assertThat(spielzug.getWuerfe()).isInstanceOf(HashMap.class);
		softly.assertAll();
	}
	
	@Test
	public void testeHoleWuerfeErwarteSpieler() {
		SoftAssertions softly = new SoftAssertions();
		ArrayList<Spieler> spielerList = new ArrayList<>();
		Spieler spieler1 = new Spieler(TesteSpieler.NAME_SPIELER1, new StrategieImmerStein());
		Spieler spieler2 = new Spieler(TesteSpieler.NAME_SPIELER2, new StrategieZufall());
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
		Spieler spieler1 = new Spieler(TesteSpieler.NAME_SPIELER1, new StrategieImmerStein());
		Spieler spieler2 = new Spieler(TesteSpieler.NAME_SPIELER2, new StrategieZufall());
		spielerList.add(spieler1);
		spielerList.add(spieler2);
		Spielzug spielzug = new Spielzug(spielerList);
		HashMap<Spieler, Spielzug.Symbol> wuerfe = spielzug.getWuerfe();
		softly.assertThat(wuerfe.get(spieler1)).isInstanceOf(Spielzug.Symbol.class);
		softly.assertThat(wuerfe.get(spieler2)).isInstanceOf(Spielzug.Symbol.class);
		softly.assertAll();
	}
	
	@Test
	public void testeSchereGegenSchereErwarteUnentschieden() {
		SoftAssertions softly = new SoftAssertions();
		ArrayList<Spieler> spielerList = new ArrayList<>();
		Spieler spieler1 = new Spieler(TesteSpieler.NAME_SPIELER1, new StrategieImmerSchere());
		Spieler spieler2 = new Spieler(TesteSpieler.NAME_SPIELER2, new StrategieImmerSchere());
		spielerList.add(spieler1);
		spielerList.add(spieler2);
		Spielzug spielzug = new Spielzug(spielerList);
		softly.assertThat(spielzug.werIstSieger()).size().isEqualTo(0);
		softly.assertAll();
	}
	
	@Test
	public void testeSchereGegenSteinErwarteNiederlage() {
		SoftAssertions softly = new SoftAssertions();
		ArrayList<Spieler> spielerList = new ArrayList<>();
		Spieler spieler1 = new Spieler(TesteSpieler.NAME_SPIELER1, new StrategieImmerSchere());
		Spieler spieler2 = new Spieler(TesteSpieler.NAME_SPIELER2, new StrategieImmerStein());
		spielerList.add(spieler1);
		spielerList.add(spieler2);
		Spielzug spielzug = new Spielzug(spielerList);
		softly.assertThat(spielzug.werIstSieger()).containsExactly(spieler2);
		softly.assertAll();
	}
	
	@Test
	public void testeSchereGegenPapierErwarteSieg() {
		SoftAssertions softly = new SoftAssertions();
		ArrayList<Spieler> spielerList = new ArrayList<>();
		Spieler spieler1 = new Spieler(TesteSpieler.NAME_SPIELER1, new StrategieImmerSchere());
		Spieler spieler2 = new Spieler(TesteSpieler.NAME_SPIELER2, new StrategieImmerPapier());
		spielerList.add(spieler1);
		spielerList.add(spieler2);
		Spielzug spielzug = new Spielzug(spielerList);
		softly.assertThat(spielzug.werIstSieger()).containsExactly(spieler1);
		softly.assertAll();
	}
	
	@Test
	public void testeSteinGegenSteinErwarteUnentschieden() {
		SoftAssertions softly = new SoftAssertions();
		ArrayList<Spieler> spielerList = new ArrayList<>();
		Spieler spieler1 = new Spieler(TesteSpieler.NAME_SPIELER1, new StrategieImmerStein());
		Spieler spieler2 = new Spieler(TesteSpieler.NAME_SPIELER2, new StrategieImmerStein());
		spielerList.add(spieler1);
		spielerList.add(spieler2);
		Spielzug spielzug = new Spielzug(spielerList);
		softly.assertThat(spielzug.werIstSieger()).size().isEqualTo(0);
		softly.assertAll();
	}
	
	@Test
	public void testeSteinGegenPapierErwarteNiederlage() {
		SoftAssertions softly = new SoftAssertions();
		ArrayList<Spieler> spielerList = new ArrayList<>();
		Spieler spieler1 = new Spieler(TesteSpieler.NAME_SPIELER1, new StrategieImmerStein());
		Spieler spieler2 = new Spieler(TesteSpieler.NAME_SPIELER2, new StrategieImmerPapier());
		spielerList.add(spieler1);
		spielerList.add(spieler2);
		Spielzug spielzug = new Spielzug(spielerList);
		softly.assertThat(spielzug.werIstSieger()).containsExactly(spieler2);
		softly.assertAll();
	}
	
	@Test
	public void testePapierGegenPapierErwarteUnentschieden() {
		SoftAssertions softly = new SoftAssertions();
		ArrayList<Spieler> spielerList = new ArrayList<>();
		Spieler spieler1 = new Spieler(TesteSpieler.NAME_SPIELER1, new StrategieImmerPapier());
		Spieler spieler2 = new Spieler(TesteSpieler.NAME_SPIELER2, new StrategieImmerPapier());
		spielerList.add(spieler1);
		spielerList.add(spieler2);
		Spielzug spielzug = new Spielzug(spielerList);
		softly.assertThat(spielzug.werIstSieger()).size().isEqualTo(0);
		softly.assertAll();
	}
	
}
