/**
 * 
 */
package de.mvenema.schere_stein_papier;

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
		softly.assertThat(new Spielzug()).isInstanceOf(Spielzug.class);
		softly.assertAll();
	}
}
