public class TestPlanet {


	public static void main(String[] args) {
		checkPairwiseForce();
	}

	public static void checkPairwiseForce() {
		Planet p1 = new Planet(1.0e12, 2.0e11, 3.0, 4.0, 2.0e30, "jupiter.gif");
		Planet p2 = new Planet(2.3e12, 9.5e11, 3.0, 4.0, 6.0e26, "jupiter.gif");
		double force = p1.calcForceExertedBy(p2);
		checkForceEquals(3.6e22, force, "Pairwise force", 1.0e22);
	}

	public static void checkForceEquals(double expected, double actual, String label, double eps) {
		if (Math.abs(expected - actual) < eps) {
			System.out.println("PASS: " + label + ": Expected " + expected + " and you gave " + actual);
		} else {
			System.out.println("FAIL: " + label + ": Expected " + expected + " and you gave " + actual);
		}
	}

}