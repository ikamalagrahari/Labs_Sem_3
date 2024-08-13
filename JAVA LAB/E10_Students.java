class Student {
  String name, programme;
  int age;

  Student(String name, int age, String programme) {
    this.name = name;
    this.age = age;
    this.programme = programme;
  }

  void display_student_info() {
    System.out.println("Name: " + name);
    System.out.println("Age: " + age);
    System.out.println("Programme: " + programme);
  }

}

class ResearchStudent extends Student {
  String specialization;
  int experienceYears;

  ResearchStudent(String name, int age, String programme, String specialization, int experienceYears) {
    super(name, age, programme);
    this.specialization = specialization;
    this.experienceYears = experienceYears;
  }

  @Override
  void display_student_info() {
    System.out.println("Info of Research Student");
    super.display_student_info();
    System.out.println("Specialization: " + specialization);
    System.out.println("Years of Experience: " + experienceYears);
    System.out.println();
  }

}

class GraduateStudent extends Student {
  String stream;
  double percentage;

  GraduateStudent(String name, int age, String programme, String stream, double percentage) {
    super(name, age, programme);
    this.stream = stream;
    this.percentage = percentage;
  }

  @Override
  void display_student_info() {
    System.out.println("Info of Graduate Student");
    super.display_student_info();
    System.out.println("Stream: " + stream);
    System.out.println("Marks in percentage: " + percentage);
    System.out.println();
  }

}

public class E10_Students {
  public static void main(String[] args) {
    ResearchStudent k = new ResearchStudent("Kamal", 30, "History & Geography", "Morden & Ancient History", 13);
    k.display_student_info();

    GraduateStudent a = new GraduateStudent("Akash", 25, "BE", "Data Science", 12.96);
    a.display_student_info();
  }
}
