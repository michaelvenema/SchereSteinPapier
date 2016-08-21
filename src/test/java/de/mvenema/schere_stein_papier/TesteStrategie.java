/**
 * 
 */
package de.mvenema.schere_stein_papier;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import de.mvenema.schere_stein_papier.Spielzug.Symbol;

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

	@Test
	public void testeStrategieZufall() {
		// Der Test wird jetzt ein bisschen silly, sollte es aber erst einmal tun
		SoftAssertions softly = new SoftAssertions();
		StrategieZufall strategie = new StrategieZufall();
		int scheren = 0;
		int steine = 0;
		int papiere = 0;
		for (int i = 0; i < 100; i++) {
			Spielzug.Symbol wurf = strategie.getNaechstenWurf();
			softly.assertThat(wurf).isInstanceOf(Spielzug.Symbol.class);
			if (wurf.equals(Spielzug.Symbol.SCHERE)) {
				scheren += 1;
			} else if (wurf.equals(Spielzug.Symbol.STEIN)) {
				steine += 1;
			} else if (wurf.equals(Spielzug.Symbol.PAPIER)) {
				papiere += 1;
			}
		}
		softly.assertThat(scheren).isBetween(10, 50);
		softly.assertThat(steine).isBetween(10, 50);
		softly.assertThat(papiere).isBetween(10, 50);
		softly.assertAll();
	}
}
