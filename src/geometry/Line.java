package geometry;

public class Line {
	static final double EPS = 1e-9;
	double a, b, c;

	Line(Point p, Point q) {
		if (Math.abs(p.x - q.x) < EPS) {
			a = 1; b = 0.0; c = -p.x;
		} else {
			a = (p.y - q.y) / (q.x - p.x);
			b = 1.0;
			c = -(a * p.x + p.y);
		}
	}
	
	Line(Point p, double m) {
		a = -m; b = 1.0; c = -(a * p.x + p.y); 
	}
	static double abs (double x) {return Math.abs(x); }
	
	boolean parallel(Line l) { return abs(a - l.a) < EPS && abs(b - l.b) < EPS; }
	
	boolean same(Line l) { return parallel(l) && abs(c - l.c) < EPS; }
	
	Point intersect(Line l) {
		if(parallel(l))
			return null; 
		double x = (b * l.c - l.b * c) / (a * l.b - l.a * b);
		double y; 
		if(abs(b) < EPS) //if (b == 0), first line is vertical, substitute in second line equation
			y = -l.c - l.a * x;  
		else //only one of the two lines can be vertical
			y = -c - a * x;
		
		return new Point(x, y); 
	}
	
	Point closestPoint(Point p) {
		if(abs(b) < EPS) return new Point(-c, p.y); //line is x = -c
		if(abs(a) < EPS) return new Point(p.x, -c);// line is y = -c
		
		return intersect(new Line(p, 1/a)); //since for perpendicular lines m1 = -1/m2 and m1 = -a, then m2 = 1/a 
	}
	
	boolean onSameSide(Point p, Point q) {
		boolean posP = a * p.x + b* p.y + c > 0.0; 
		boolean posQ = a * q.x + b * q.y + c > 0.0;
		return !(posP ^ posQ); 
	}
	
	@Override
	public String toString() {
		return a + "*x + " + b + "*y + " + c + " = 0";
	}
	
		
}
