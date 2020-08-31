package common;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generators {

	private static Random r;

	public Generators() {
		r = new Random();
	}

	public static String generateName() {
		
		List<String> sections = new ArrayList<String>();

		// how many parts...
		int parts = r.nextInt(4) + 2;

		// build part...
		for (int part = 0; part < parts; part++) {
			sections.add(formSection());
		}

		return String.join("-", sections);
	}

	private static String formSection() {

		StringBuilder section = new StringBuilder();

		// how long...
		int length = r.nextInt(4) + 2;

		for (int l = 0; l < length; l++) {

			// letter or number...
			if (r.nextBoolean()) {
				// letter
				char c = (char) (r.nextInt(26) + 65);
				section.append(c);
			} else {
				// number
				section.append((char) (r.nextInt(10) + 48));
			}
			
		}
		
		return section.toString();
	}
}
