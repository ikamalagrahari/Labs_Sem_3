class Employee {
  private int employeeNumber;
  private String name;
  private double salary;

  public Employee(int employeeNumber, String name, double salary) {
    this.employeeNumber = employeeNumber;
    this.name = name;
    this.salary = salary;
  }

  public void applyAnnualSalaryIncrement(double incrementPercentage) {
    salary += (salary * incrementPercentage / 100);
  }

  public int getEmployeeNumber() {
    return employeeNumber;
  }

  public String getName() {
    return name;
  }

  public double getSalary() {
    return salary;
  }
}

class Department {
  private String name;
  private Employee headOfDepartment;

  public Department(String name, Employee headOfDepartment) {
    this.name = name;
    this.headOfDepartment = headOfDepartment;
  }

  public void changeHeadOfDepartment(Employee newHead) {

    headOfDepartment = newHead;
  }

  public String getName() {
    return name;
  }

  public Employee getHeadOfDepartment() {
    return headOfDepartment;
  }
}

class Organization {
  private String name;

  public Organization(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}

public class E11_Employee {
  public static void main(String[] args) {
    Employee employee1 = new Employee(101, "John Doe", 50000.0);
    Employee employee2 = new Employee(102, "Jane Smith", 60000.0);

    Department department1 = new Department("HR", employee1);
    Department department2 = new Department("IT", employee2);

    employee1.applyAnnualSalaryIncrement(5.0);
    employee2.applyAnnualSalaryIncrement(7.5);

    department1.changeHeadOfDepartment(employee2);
    department2.changeHeadOfDepartment(employee1);

    Organization organization = new Organization("ABC Corp");

    System.out.println("Organization Information:");
    System.out.println("Name: " + organization.getName());

    System.out.println("\nEmployee 1 Information:");
    System.out.println("Employee Number: " + employee1.getEmployeeNumber());
    System.out.println("Name: " + employee1.getName());
    System.out.println("Salary: $" + employee1.getSalary());

    System.out.println("\nEmployee 2 Information:");
    System.out.println("Employee Number: " + employee2.getEmployeeNumber());
    System.out.println("Name: " + employee2.getName());
    System.out.println("Salary: $" + employee2.getSalary());

    System.out.println("\nDepartment 1 Information:");
    System.out.println("Name: " + department1.getName());
    System.out.println("Head of Department: " + department1.getHeadOfDepartment().getName());

    System.out.println("\nDepartment 2 Information:");
    System.out.println("Name: " + department2.getName());
    System.out.println("Head of Department: " + department2.getHeadOfDepartment().getName());
  }
}
