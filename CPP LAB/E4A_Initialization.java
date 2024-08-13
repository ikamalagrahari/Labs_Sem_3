
class Circle {
  double x, y, r;

  // Default Constructor
  Circle() {
    x = 0;
    y = 0;
    r = 1;
  }

  // Parameterized Constructor
  Circle(double r) {
    this();
    this.r = r;
  }

  // Copy Constructor
  Circle(Circle c) {
    this(c.r);
  }

  void printArea() {
    System.out.println("The area of the circle is " + 3.14 * r * r);
  }

}

public class E4A_Initialization {
  public static void main(String[] args) {
    Circle circle1 = new Circle();
    Circle circle2 = new Circle(5);
    Circle circle3 = new Circle(circle2);

    circle1.printArea();
    circle2.printArea();
    circle3.printArea();
  }
}
