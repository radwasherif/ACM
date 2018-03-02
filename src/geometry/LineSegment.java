package geometry;

public class LineSegment {
	Point p, q; 
	LineSegment(Point p, Point q) {this.p = p; this.q = q;}
	
	boolean intersect(LineSegment l) {
		Line l1 = new Line(p, q), l2 = new Line(l.p, l.q); 
		if(l1.parallel(l2)) {
			if(l1.same(l2))
				return p.between(l.p, l.q) || q.between(l.p, l.q) ||
						l.p.between(p, q) || l.q.between(p, q); 
			return false; 
		}
		
		Point c = l1.intersect(l2); 

		return c.between(p, q) && c.between(l.p, l.q); 
	}
	
	public static void main(String[] args) {
		LineSegment l1 = new LineSegment(new Point(11, 13), new Point(16, 11)); 
		LineSegment l2 = new LineSegment(new Point(14.0, 14), new Point(14.0, 0)); 
		System.out.println(l1.intersect(l2));
	}
}
