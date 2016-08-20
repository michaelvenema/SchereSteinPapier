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
		softly.assertThat(
				new Spielzug(spielerList))
				.isInstanceOf(Spielzug.class);
		softly.assertAll();
	}
}
