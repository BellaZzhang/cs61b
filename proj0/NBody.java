public class NBody {

	public static void main(String[] args) {
		Double T = Double.parseDouble(args[0]);
		Double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		Planet[] planets = readPlanets(filename);
		StdDraw.setScale(-readRadius(filename), readRadius(filename));
		StdDraw.enableDoubleBuffering();
		for (double t = 0.0; t < T; t+= dt) {
			Double[] xForces = new Double[planets.length];
			Double[] yForces = new Double[planets.length];
			for (int i = 0; i< planets.length; i++){
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
			}
			for (int i = 0; i< planets.length; i++){
				planets[i].update(dt, xForces[i], yForces[i]);
			}
			StdDraw.picture(0, 0, "images/starfield.jpg");
			for (Planet p : planets) {
				p.draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
		}
		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", readRadius(filename));
		for (int i = 0; i < planets.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
            planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
            planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
		}
	}
	
	public static double readRadius(String file) {
		In in = new In(file);
		int numberOfPlanets = in.readInt();
		double radius = in.readDouble();
		return radius;
	}

	public static Planet[] readPlanets(String file) {
		In in = new In(file);
		int numberOfPlanets = in.readInt();
		double radius = in.readDouble();
		Planet[] planets = new Planet[numberOfPlanets];
		for (int i = 0; i<numberOfPlanets; i++) {
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();
			String img = in.readString();
			planets[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, img);
		}
		return planets;

	}

}