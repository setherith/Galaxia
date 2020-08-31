package tests;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import common.Generators;

class GeneratorsTests {

	@Test
	void OneHundredNames() {
		for (int i = 0; i < 100; i++) {
			String result = Generators.generateName();
			System.out.println(result);
			if (result.length() < 4) fail("Not long enough");
		}
	}

}
