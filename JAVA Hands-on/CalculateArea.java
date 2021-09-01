package EAS.java.handson;

import java.util.Scanner;

public class CalculateArea {
	static Scanner in = new Scanner(System.in);
	public static double calculateArea(double len, double breadth)
	{
		System.out.println("Area of rectangle is calculated as, length*breadth: ");
		return (double)len*breadth;
	}

	public static void main(String[] args) {
		double a,b;
		System.out.println("Enter length and breadth");
		a = in.nextDouble();
		b = in.nextDouble();
		System.out.println(calculateArea(a,b));
	}
}
