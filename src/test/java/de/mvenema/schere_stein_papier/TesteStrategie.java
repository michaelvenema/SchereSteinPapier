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
public class TesteStrategie {

	@Test
	public void testeInitStrategieErwarteInstanzAlsSubclass() {
		SoftAssertions softly = new SoftAssertions();
		StrategieImmerStein strategie = new StrategieImmerStein();
		softly.assertThat(strategie).isExactlyInstanceOf(StrategieImmerStein.class);
		softly.assertThat(strategie).isInstanceOf(AbstractStrategie.class);
		softly.assertAll();
	}

	@Test
	public void testeStrategieImmerStein() {
		SoftAssertions softly = new SoftAssertions();
		StrategieImmerStein strategie = new StrategieImmerStein();
		for (int i = 0; i < 100; i++) {
			softly.assertThat(strategie.getNaechstenWurf()).isEqualTo(Spielzug.Symbol.STEIN);
		}
		softly.assertAll();
	}
}
