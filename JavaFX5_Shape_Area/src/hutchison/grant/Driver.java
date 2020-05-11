package hutchison.grant;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.println("2D Shapes");
		
		System.out.println("Rectangle");
		System.out.print("Width: ");
		int width = in.nextInt();
		
		System.out.print("Height: ");
		int height = in.nextInt();
		
		Rectangle rect = new Rectangle(width, height);
		
		System.out.println("Circle");
		System.out.print("Radius: ");
		int radius = in.nextInt();
		
		Circle circle = new Circle(radius);

		System.out.println(circle);
		System.out.println(rect);
		
		if (circle.getArea()> rect.getArea()) {
			System.out.println("Circle is larger.");
		}
		else {
			System.out.println("Rectangle is larger.");
		}
		
	}

}
