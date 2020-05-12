package hutchison.grant;

public class Rectangle extends Shape2D<Rectangle> implements Comparable<Rectangle> 
{
	private double width;
	private double height;
	private double area;
	
	Rectangle (double w, double h){
		width = w;
		height = h;
		setArea();
	}
	
	private void setArea() {
		area = width * height;
	}
	
	public double getArea() {
		return area;
	}
	
	@Override
	public String toString() {
		return String.format("Rectangle has width of %.1f, height of %.1f, and area of %.1f", width, height, area);
	}

	@Override
	public int compareTo(Rectangle r) {
		if (area>r.getArea()) {
			return 1;
		}
		else if (area<r.getArea()) {
			return -1;
		}
		return 0;

	}
	
}
