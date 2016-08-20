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
		Spiel spiel = new Spiel();
		softly.assertThat(spiel).isNotNull();
		softly.assertThat(spiel).isInstanceOf(Spiel.class);
		softly.assertAll();		
	}
}
