class Student {
  private int age, rollNo;
  private String name, address, email, mobileNo;

  public void setAge(int age) {
    this.age = age;
  }

  public void setRollNo(int rollNo) {
    this.rollNo = rollNo;
  }

  public void setMobileNo(String mobileNo) {
    this.mobileNo = mobileNo;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getAge() {
    return age;
  }

  public int getRollNo() {
    return rollNo;
  }

  public String getMobileNo() {
    return mobileNo;
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public String getEmail() {
    return email;
  }

}

public class E2_Encapsulation {
  public static void main(String[] args) {
    Student student1 = new Student();
    student1.setName("Amir");
    student1.setAddress("Gandhi Chowk, Bangala Muhalla, Samkhetar Mandi Himachal Pradesh - 175001");
    student1.setEmail("solomojo@bestspeakingcourses.com");
    student1.setMobileNo("1905225656");
    student1.setAge(44);
    student1.setRollNo(87);
    System.out.println("Details of the Student 1 are as follows:");
    System.out.println("Name: " + student1.getName());
    System.out.println("Roll No: " + student1.getRollNo());
    System.out.println("Age: " + student1.getAge());
    System.out.println("Moblie No: " + student1.getMobileNo());
    System.out.println("Email: " + student1.getEmail());
    System.out.println("Address: " + student1.getAddress());
    System.out.println();
    Student student2 = new Student();
    student2.setName("Meghana");
    student2.setAddress("Master Canteen Area, Kharavela Nagar Bhubaneshwar Odisha - 751001");
    student2.setEmail("solomojo@bestspeakingcourses.com");
    student2.setMobileNo("6742534994");
    student2.setAge(37);
    student2.setRollNo(47);
    System.out.println("Details of the Student 2 are as follows:");
    System.out.println("Name: " + student2.getName());
    System.out.println("Roll No: " + student2.getRollNo());
    System.out.println("Age: " + student2.getAge());
    System.out.println("Moblie No: " + student2.getMobileNo());
    System.out.println("Email: " + student2.getEmail());
    System.out.println("Address: " + student2.getAddress());
    System.out.println();
  }
}
