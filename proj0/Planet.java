public class Planet {
	
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	final static double gConstant = 6.67e-11;

	public Planet(double xP, double yP, double xV, double yV, double m, String img) {
		this.xxPos = xP;
		this.yyPos = yP;
		this.xxVel = xV;
		this.yyVel = yV;
		this.mass = m;
		this.imgFileName = img;
	}

	public Planet(Planet p) {
		this(p.xxPos, p.yyPos ,p.xxVel, p.yyVel, p.mass, p.imgFileName);
	}

	public double calcDistance(Planet p) {
		double xDifference = Math.abs(this.xxPos - p.xxPos);
		double yDifference = Math.abs(this.yyPos - p.yyPos);
		return Math.sqrt((xDifference * xDifference) + (yDifference * yDifference));
	}

	public double calcForceExertedBy(Planet p) {
		return (gConstant * this.mass * p.mass) / (calcDistance(p) * calcDistance(p));
	}

	public double calcForceExertedByX(Planet p){
		return calcForceExertedBy(p) * (p.xxPos - this.xxPos) / calcDistance(p);
	}

	public double calcForceExertedByY(Planet p){
		return calcForceExertedBy(p) * (p.yyPos - this.yyPos) / calcDistance(p);
	}

	public double calcNetForceExertedByX(Planet[] allPlanets) {
		double sum = 0;
		for (Planet p : allPlanets) {
			if (!this.equals(p)) {
				sum += calcForceExertedByX(p);
			}
		}
		return sum;
	}

	public double calcNetForceExertedByY(Planet[] allPlanets) {
		double sum = 0;
		for (Planet p : allPlanets) {
			if (!this.equals(p)) {
				sum += calcForceExertedByY(p);
			}
		}
		return sum;
	}

	public double calcAccelerationExertedByX(double fX) {
		return fX / mass;
	}

	public double calcAccelerationExertedByY(double fY) {
		return fY / mass;
	}

	public void calcNewVelocityX(double dt, double fX) {
		xxVel += calcAccelerationExertedByX(fX) * dt;
	}

	public void calcNewVelocityY(double dt, double fY) {
		yyVel += calcAccelerationExertedByY(fY) * dt;
	}

	public void calcNewPositionX(double dt) {
		xxPos += dt * xxVel;
	}

	public void calcNewPositionY(double dt) {
		yyPos += dt * yyVel;
	}

	public void update(double dt, double fX, double fY) {
		calcAccelerationExertedByX(fX);
		calcAccelerationExertedByY(fY);
		calcNewVelocityX(dt, fX);
		calcNewVelocityY(dt, fY);
		calcNewPositionX(dt);
		calcNewPositionY(dt);
	}

	public void draw() {
		StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
	}

}