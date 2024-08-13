class Student {
  private String name;
  private int age;
  private String address;

  public Student() {
    name = "unknown";
    age = 0;
    address = "not available";
  }

  public void setInfo(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public void setInfo(String name, int age, String address) {
    this.name = name;
    this.age = age;
    this.address = address;
  }

  public void displayInfo() {
    System.out.println("Name: " + name);
    System.out.println("Age: " + age);
    System.out.println("Address: " + address);
  }
}

public class E6_StudentInfo {
  public static void main(String[] args) {
    Student[] students = new Student[10];

    for (int i = 0; i < 10; i++) {
      students[i] = new Student();
      students[i].setInfo("Student " + (i + 1), i + 20, "Address " + (i + 1));
    }

    for (int i = 0; i < 10; i++) {
      System.out.println("Student " + (i + 1) + " Information:");
      students[i].displayInfo();
      System.out.println();
    }
  }
}
