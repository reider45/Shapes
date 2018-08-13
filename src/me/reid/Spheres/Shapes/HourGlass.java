package me.reid.Spheres.Shapes;

import org.bukkit.Location;
import org.bukkit.Particle;

public class HourGlass extends Shape {

	public HourGlass(Location loc) {
		super(loc);
	}

	// Amount of rings for hourglass
	final int maxLayers = 20;

	// Spacing between rings
	final double yStep = .1;

	public void drawShape() {

		// y-position
		double y = 0;

		for (int currentLayer = 0; currentLayer < maxLayers; currentLayer++) {
			double radius = ((maxLayers / 2) - currentLayer) * .1;
			for (int degree = 0; degree < 360; degree++) {
				double radians = Math.toRadians(degree);
				double x = Math.sin(radians) * radius;
				double z = Math.cos(radians) * radius;

				// Spawn the particle
				super.getLoc().getWorld().spawnParticle(Particle.FLAME, super.getLoc().add(x, y, z), 1, 0, 0, 0, 0);
				super.getLoc().subtract(x, y, z);
			}
			y += yStep;
		}

	}

}
