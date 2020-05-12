package hutchison.grant;

public class Circle extends Shape2D<Circle> implements Comparable<Circle> {
	private double radius;
	private double area;

	Circle(double radius) {
		this.radius = radius;
		setArea();
	}

	private void setArea() {
		area = Math.PI * Math.pow(radius, 2.0);
	}

	public double getArea() {
		return area;
	}

	@Override
	public String toString() {
		return String.format("Circle has radius %.1f and area of %.1f", radius, area);
	}

	@Override
	public int compareTo(Circle c) {
		if (area>c.getArea()) {
			return 1;
		}
		else if (area<c.getArea()) {
			return -1;
		}
		return 0;

	}
	

}
