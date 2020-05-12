package hutchison.grant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Many Circles Compare");
		ArrayList<Shape2D> shapes = new ArrayList<>();
		
		System.out.print("How Many? ");
		int numCircles = in.nextInt();

	
		for (int i = 0; i < numCircles; i++) {
			System.out.println("Circle " + (i + 1));
			System.out.print("Radius: ");
			int radius = in.nextInt();
			shapes.add(new Circle(radius));
		}

		System.out.println("Many Rectangles Compare");

		System.out.print("How Many? ");
		int numRectangles = in.nextInt();
		
		for (int i = 0; i < numRectangles; i++) {
			System.out.println("Rectangle " + (i + 1) + " : ");
			System.out.print("width: ");
			int width = in.nextInt();

			System.out.print("height: ");
			int height = in.nextInt();

			shapes.add(new Rectangle(width, height));
		}


		System.out.println("List of Shapes");
		System.out.println("++++++++++++++");
		for (Shape2D s : shapes) {
			System.out.println(s);
		}
		Collections.sort(shapes);
		
		System.out.println("Sorted List of Shapes");
		System.out.println("+++++++++++++++++++++");
		for (Shape2D s : shapes) {
			System.out.println(s);
		}

	}

}
