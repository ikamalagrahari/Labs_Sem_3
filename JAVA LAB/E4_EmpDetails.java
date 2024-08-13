class Employee {
  String name, address;
  int yearOfJoining;
  double salary;

  void setDetails(String name, String address, int yearOfJoining, double salary) {
    this.name = name;
    this.address = address;
    this.salary = salary;
    this.yearOfJoining = yearOfJoining;
  }

  void displayDetails() {
    System.out.println(name + " \t\t " + yearOfJoining + " \t\t\t " + salary + " \t\t " + address);
  }
}

class E4_EmpDetails {
  public static void main(String[] args) {
    Employee e1 = new Employee();
    e1.setDetails("Robert", "64C - WallStreet", 1994, 45000.7);
    Employee e2 = new Employee();
    e2.setDetails("Sam", "68D - WallStreet", 2000, 7600.4);
    Employee e3 = new Employee();
    e3.setDetails("John", "26B - WallStreet", 1999, 8001.23);

    System.out.println("Name \t\t Year of joining \t Salary \t\t Address");
    e1.displayDetails();
    e2.displayDetails();
    e3.displayDetails();

  }
}