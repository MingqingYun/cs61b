public class Planet {
	public double xxPos; /* current x position*/
	public double yyPos; /* current y position*/
	public double xxVel; /* current velocity in the x direction*/
	public double yyVel; /* current velocity in the y direction*/
	public double mass; /* its mass*/
	public String imgFileName;
	private static final double G = 6.67e-11;

	public Planet(double xP, double yP, double xV,
              double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Body p){
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet p){
		double dx = p.xxPos - xxPos;
		double dy = p.yyPos - yyPos;

		double distance = Math.sqrt(dx * dx + dy * dy);
		return distance;
	}

	public double calcForceExertedBy(Planet p){

		double distance = calcDistance(p);

		double F = (G * mass * p.mass) / (distance * distance);
		return F;
	}

	public double calcForceExertedByX(Planet p){
		double dx = p.xxPos - xxPos;
		double r=calcDistance(p);
		return calcForceExertedBy(p) * dx / r;
	}

	public double calcForceExertedByY(Planet p){
		double dy = p.yyPos - yyPos;
		double r = calcDistance(p);
		return calcForceExertedBy(p) * dy / r;
	}

	public double calcNetForceExertedByX(Planet[] allPlanets){
		double totalForce = 0;

		for (Planet planet: allPlanets){
			if (this.equals(planet)){
				continue;
			}
			totalForce += calcForceExertedByX(planet);
		}
		return totalForce;
	}

	public double calcNetForceExertedByY(Planet[] allPlanets){
		double totalForce = 0;
		for (Planet planet: allPlanets){
			if (this.equals(planet)){
				continue;
			}
			totalForce += calcForceExertedByY(planet);
		}
		return totalForce;
	}

	public void update(double dt, double fX, double fY){
		double ax = fX / mass;
		double ay = fY / mass;
		xxVel += dt * ax;
		yyVel += dt * ay;
		xxPos += xxVel * dt;
		yyPos += yyVel * dt;

	}

	public void draw(){
		StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
	}

}