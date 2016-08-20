package de.mvenema.schere_stein_papier;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

public class TesteSpieler {
	
	protected static final String NAME_SPIELER1 = "Jane Doe";
	protected static final String NAME_SPIELER2 = "John Doe";
	
	@Test
	public void testeInitSpielerErwarteInstanz() {
		SoftAssertions softly = new SoftAssertions();
		Spieler spieler = new Spieler(NAME_SPIELER1);
		softly.assertThat(spieler).isNotNull();
		softly.assertThat(spieler).isInstanceOf(Spieler.class);
		softly.assertAll();
	}
	
	@Test
	public void testeInitSpielerErwarteName() {
		SoftAssertions softly = new SoftAssertions();
		Spieler spieler = new Spieler(NAME_SPIELER1);
		softly.assertThat(spieler.getName()).isEqualTo(NAME_SPIELER1);
		softly.assertAll();
	}
	
	@Test
	public void testeInitSpielerOhneNamenErwarteException() {
		SoftAssertions softly = new SoftAssertions();
		softly.assertThatThrownBy(() -> new Spieler("")).isInstanceOf(IllegalArgumentException.class);
		softly.assertThatThrownBy(() -> new Spieler(null)).isInstanceOf(IllegalArgumentException.class);		
		softly.assertAll();
	}
}
