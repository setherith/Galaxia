package tests;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import common.Generators;

class GeneratorsTests {

	private Generators g;
	
	public GeneratorsTests() {
		g = new Generators();
	}
	
	@Test
	void OneHundredNames() {
		for (int i = 0; i < 100; i++) {
			String result = g.generateName();
			System.out.println(result);
		}
	}

}
