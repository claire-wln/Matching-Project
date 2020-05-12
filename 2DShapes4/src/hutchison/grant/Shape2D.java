package hutchison.grant;

public abstract class Shape2D implements Comparable<Shape2D>
 {
	private double area;
	public abstract double getArea();
	@Override
	public int compareTo(Shape2D s) {
		if (area > s.getArea()) {
			return 1;
		} else if (area < s.getArea()) {
			return -1;
		}
		return 0;
	}
}
