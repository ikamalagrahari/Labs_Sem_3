class Vehicle {
  String Brand, Model, Colour;

  public void isfast(boolean fast) {
    if (fast)
      System.out.println("My Speed is very High!!");
    else
      System.out.println("My Speed is not very High!");

  }

  public void hasRange(boolean maxD) {
    if (maxD)
      System.out.println("I can cover Maximum Distance!!");
    else
      System.out.println("I can cover Minimum Distance!");

  }

  public void isEfficent(boolean maxM) {
    if (maxM)
      System.out.println("I have Maximum Milage!!");
    else
      System.out.println("I have Minimum Milage!");

  }

}

class Car extends Vehicle {
  public void details() {
    System.out.println("Brand: " + Brand);
    System.out.println("Model: " + Model);
    System.out.println("Colour: " + Colour);

  }
}

class Bike extends Vehicle {
  public void displayDetails() {
    System.out.println("Brand: " + Brand);
    System.out.println("Model: " + Model);
    System.out.println("Colour: " + Colour);

  }
}

public class E3_Inheritance {
  public static void main(String[] args) {
    Car C1 = new Car();
    C1.Brand = "Mercedes";
    C1.Model = "Benz";
    C1.Colour = "Black";
    C1.details();
    C1.isfast(true);
    C1.hasRange(true);

    System.out.println("\n");

    Car C2 = new Car();
    C2.Brand = "Hyundai";
    C2.Model = "Creta";
    C2.Colour = "White";
    C2.details();
    C2.isfast(false);
    C2.hasRange(false);

    System.out.println("\n");

    Bike B1 = new Bike();
    B1.Brand = "Hero";
    B1.Model = "Honda";
    B1.Colour = "Red";
    B1.displayDetails();
    B1.isfast(false);
    B1.isEfficent(false);

    System.out.println("\n");

    Bike B2 = new Bike();
    B2.Brand = "Maruti";
    B2.Model = "Suzuki Kawasaki";
    B2.Colour = "Green";
    B2.displayDetails();
    B2.isfast(true);
    B2.isEfficent(false);

  }
}
