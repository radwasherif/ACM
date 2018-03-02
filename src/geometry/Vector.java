package geometry;

public class Vector {
	double x, y; 
	
	public Vector(double x, double y) {this.x = x; this.y = y; }
	
	public Vector(Point p, Point q) {this(q.x - p.x, q.y - p.y); }
	
	
	Vector scale(double s) { return new Vector(x * s, y * s); }
	
	double dot(Vector v) { return x * v.x + y * v.y; }
	
	double cross(Vector v) { return x * v.y - y * v.x; }
	
	double normSqr() { return x*x + y*y; }
	
	Vector reverse() { return new Vector(-x, -y ); }
	
	Vector normaize() { return scale(1/ (Math.sqrt(normSqr()))); }
	Vector rotate(double angle)
	{
		angle = degToRad(angle);
		double c = Math.cos(angle), s = Math.sin(angle);
		return new Vector(x * c - y * s, x * s + y * c);
	}
	
	static double degToRad(double deg)
	{
		return deg * Math.PI / 180.0;
	}
}
