import java.util.Scanner;

public class Bikers {

  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);

    double S1, S2, S3, S4, S5;
    double avgSpeed;

    System.out.println("Enter the Speed of 5 racers: ");
    S1 = input.nextDouble();
    S2 = input.nextDouble();
    S3 = input.nextDouble();
    S4 = input.nextDouble();
    S5 = input.nextDouble();

    avgSpeed = (S1 + S2 + S3 + S4 + S5) / 5;

    System.out.println("Average Speed is: " + avgSpeed);
    if (S1 > avgSpeed)
      System.out.println("The Qualifying racers is S1 with speed: " + S1);
    if (S2 > avgSpeed)
      System.out.println("The Qualifying racers is S2 with speed: " + S2);
    if (S3 > avgSpeed)
      System.out.println("The Qualifying racers is S3 with speed: " + S3);
    if (S4 > avgSpeed)
      System.out.println("The Qualifying racers is S4 with speed: " + S4);
    if (S5 > avgSpeed)
      System.out.println("The Qualifying racers is S5 with speed: " + S5);

    input.close();
  }

}
