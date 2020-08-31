package domain;

import common.Generators;

public abstract class CelestialBody {
	
	public String Name;
	
	public CelestialBody() {
		// Generate random name
		this.Name = Generators.generateName();
	}
	
	public void rename(String name) {
		this.Name = name;
	}
	
}
