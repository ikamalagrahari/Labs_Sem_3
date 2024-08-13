import java.util.Vector;
import java.util.Scanner;

public class E7A_StringVectorOperations {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Vector<String> stringVector = new Vector<>();

    int n;
    System.out.print("Enter the number of strings to add to the vector: ");
    n = scanner.nextInt();
    scanner.nextLine();

    for (int i = 0; i < n; i++) {
      System.out.print("Enter string " + (i + 1) + ": ");
      String inputString = scanner.nextLine();

      if (stringVector.contains(inputString)) {

        stringVector.remove(inputString);
        System.out.println("String removed from the vector: " + inputString);
      } else {

        stringVector.add(inputString);
        System.out.println("String added to the vector: " + inputString);
      }
    }

    System.out.println("Contents of the vector:");
    for (String str : stringVector) {
      System.out.println(str);
    }
    scanner.close();
  }
}
