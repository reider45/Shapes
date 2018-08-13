package me.reid.Spheres.Shapes;

import org.bukkit.Location;

public abstract class Shape {

	private Location loc;

	public Shape(Location loc) {
		this.loc = loc;
	}

	public abstract void drawShape();

	public Location getLoc() {
		return loc;
	}

}
