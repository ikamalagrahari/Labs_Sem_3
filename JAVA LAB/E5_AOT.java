import java.util.Scanner;

class RectangleArea {
  private double length;
  private double breadth;

  public void setDim(double length, double breadth) {
    this.length = length;
    this.breadth = breadth;
  }

  public double getArea() {
    return length * breadth;
  }
}

public class E5_AOT {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    RectangleArea rectangle = new RectangleArea();

    System.out.print("Enter the length of the rectangle: ");
    double length = scanner.nextDouble();
    System.out.print("Enter the breadth of the rectangle: ");
    double breadth = scanner.nextDouble();
    rectangle.setDim(length, breadth);
    double area = rectangle.getArea();
    System.out.println("The area of the rectangle is: " + area);
    scanner.close();
  }
}
