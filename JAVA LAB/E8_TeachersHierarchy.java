class Teacher {
  private String name;
  private String employeeId;
  private String department;

  public Teacher(String name, String employeeId, String department) {
    this.name = name;
    this.employeeId = employeeId;
    this.department = department;
  }

  public void displayInfo() {
    System.out.println("Name: " + name);
    System.out.println("Employee ID: " + employeeId);
    System.out.println("Department: " + department);
  }
}

class Professor extends Teacher {
  private String researchArea;

  public Professor(String name, String employeeId, String department, String researchArea) {
    super(name, employeeId, department);
    this.researchArea = researchArea;
  }

  @Override
  public void displayInfo() {
    super.displayInfo();
    System.out.println("Title: Professor");
    System.out.println("Research Area: " + researchArea);
  }
}

class AssociateProfessor extends Teacher {
  private int yearsOfExperience;

  public AssociateProfessor(String name, String employeeId, String department, int yearsOfExperience) {
    super(name, employeeId, department);
    this.yearsOfExperience = yearsOfExperience;
  }

  @Override
  public void displayInfo() {
    super.displayInfo();
    System.out.println("Title: Associate Professor");
    System.out.println("Years of Experience: " + yearsOfExperience);
  }
}

class AssistantProfessor extends Teacher {
  private String[] coursesTaught;

  public AssistantProfessor(String name, String employeeId, String department, String[] coursesTaught) {
    super(name, employeeId, department);
    this.coursesTaught = coursesTaught;
  }

  @Override
  public void displayInfo() {
    super.displayInfo();
    System.out.println("Title: Assistant Professor");
    System.out.print("Courses Taught: ");
    for (int i = 0; i < coursesTaught.length; i++) {
      System.out.print(coursesTaught[i]);
      if (i < coursesTaught.length - 1) {
        System.out.print(", ");
      }
    }
    System.out.println();
  }
}

class E8_TeachersHierarchy {
  public static void main(String[] args) {
    Professor prof = new Professor("Dr. Smith", "12345", "Computer Science", "Machine Learning");
    prof.displayInfo();

    AssociateProfessor assocProf = new AssociateProfessor("Dr. Johnson", "67890", "Physics", 10);
    assocProf.displayInfo();

    String[] courses = { "Calculus", "Linear Algebra" };
    AssistantProfessor asstProf = new AssistantProfessor("Dr. Brown", "54321", "Mathematics", courses);
    asstProf.displayInfo();
  }
}
