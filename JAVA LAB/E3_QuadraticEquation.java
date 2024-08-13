import java.util.Scanner;

public class E3_QuadraticEquation {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the coefficients of the quadratic equation ax^2 + bx + c = 0:");
    System.out.print("Enter a: ");
    double a = scanner.nextDouble();
    System.out.print("Enter b: ");
    double b = scanner.nextDouble();
    System.out.print("Enter c: ");
    double c = scanner.nextDouble();
    double discriminant = b * b - 4 * a * c;

    if (discriminant > 0) {
      double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
      double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
      System.out.println("Two real solutions:");
      System.out.println("Root 1: " + root1);
      System.out.println("Root 2: " + root2);
    } else if (discriminant == 0) {
      double root = -b / (2 * a);
      System.out.println("One real solution:");
      System.out.println("Root: " + root);
    } else {
      System.out.println("No real solutions. The discriminant is negative.");
    }

    scanner.close();
  }
}
