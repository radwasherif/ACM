package geometry;

public class Point implements Comparable<Point> {

	static final double EPS = 1e-9;
	double x, y; 
	public Point(double x, double y) {this.x = x; this.y = y;}
	@Override
	/**
	 * compares with x first and then y 
	 */
	public int compareTo(Point p) { 
		if(Math.abs(x - p.x) > EPS) return (x > p.x) ? 1: -1; //if(x != p.x)  
		if(Math.abs(y - p.y) > EPS) return (y > p.y) ? 1: -1; //if(y != p.y) 
		return 0; 
	}
	
	static double sq(double x) {return x*x;}
	
	public double dist(Point p) {
		return Math.sqrt(sq(x - p.x) + sq(y - p.y)); 
	}
	
	public Point rotate(double theta) {
		double sin = Math.sin(theta); 
		double cos = Math.cos(theta); 
		
		return new Point(x*cos - y*sin, x*sin + y*cos); 
	}
	public Point rotate(double theta, Point p) {
		Vector v = new Vector(p, new Point(0, 0)); 
		return this.translate(v).rotate(theta).translate(v.reverse()); 
	}	
	
	public Point translate(Vector v) { return new Point(x + v.x, y + v.y); }
	
	Point reflect(Line l) {
		Point p = l.closestPoint(this); 
		Vector v = new Vector(this, p); 
		return this.translate(v).translate(v); 
	}
	
	boolean between(Point p, Point q) {
		return x < Math.max(p.x, q.x) + EPS && x + EPS > Math.min(p.x, q.x)
				&& y < Math.max(p.y, q.y) + EPS && y + EPS > Math.min(p.y, q.y);
		
	}
	
	/*
	 * distance between point p and straight line defined by a and b,
	 * c = a + projection vector of v(ap) on v(ab)
	 * c = a + ((ab).(ap) / ||ab||) * (v(ab) / ||ab||)
	 * let u = ( ab.ap ) / ||ab||^2
	 * so c = a + v(av) * a  
	 */
	
	static double distToLine(Point p, Point a, Point b) {
		if(a.compareTo(b) == 0) return a.dist(p); 
		Vector ab = new Vector(a, b), ap = new Vector(a, p); 
		double u = ab.dot(ap) / ab.normSqr(); 
		Point c = a.translate(ab.scale(u)); 
		return c.dist(p); 
	}
	
	static double distToSegment(Point p, Point a, Point b) {
		if(a.compareTo(b) == 0) return a.dist(p); 
		Vector ab = new Vector(a, b), ap = new Vector(a, p); 
		double u = ab.dot(ap) / ab.normSqr(); 
		if(u < 0.0) return a.dist(p); // obtuse angle, p is closer to a
		if(u > 1.0) return b.dist(p);//projection is longer than line segment
		return distToLine(p, a, b); 
	}
	
	static double angle (Point a, Point o, Point b) { //returns value in radian
		Vector oa = new Vector(o, a), ob = new Vector(o, b); 
		return Math.acos(oa.dot(ob) / Math.sqrt(oa.normSqr() * ob.normSqr())); 
	}
	
	/*
	 * Counter-clockwise test, returns true if r is to the left of pq, 
	 * if pq x pr > 0
	 */
	static boolean ccw(Point p, Point q, Point r) {
		Vector pq = new Vector(p, q), pr = new Vector(p, r);
		return pq.cross(pr) > 0; 
	}
	
	static boolean collinear(Point p, Point q, Point r) {
		Vector pq = new Vector(p, q), pr = new Vector(p, r);
		return pq.cross(pr) < EPS; 
	}

	@Override
	public String toString() {
	
		return String.format("(%f , %f)", x, y);
	}

}
