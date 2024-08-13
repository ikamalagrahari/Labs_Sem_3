import java.util.Scanner;

public class E7B_RecursiveFunctions {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int choice;

    do {
      System.out.println("Recursive Functions Menu:");
      System.out.println("1. Find GCD and LCM");
      System.out.println("2. Print n Fibonacci numbers");
      System.out.println("3. Find reverse of a number");
      System.out.println("4. Solve 1 + 2 + 3 + ... + (n - 1) + n");
      System.out.println("5. Exit");
      System.out.print("Enter your choice (1-5): ");
      choice = scanner.nextInt();

      switch (choice) {
        case 1:
          System.out.print("Enter two numbers to find GCD and LCM (space-separated): ");
          int num1 = scanner.nextInt();
          int num2 = scanner.nextInt();
          int gcd = findGCD(num1, num2);
          int lcm = findLCM(num1, num2);
          System.out.println("GCD: " + gcd);
          System.out.println("LCM: " + lcm);
          break;
        case 2:
          System.out.print("Enter the number of Fibonacci numbers to print: ");
          int n = scanner.nextInt();
          System.out.println("Fibonacci Series:");
          for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
          }
          System.out.println();
          break;
        case 3:
          System.out.print("Enter a number to reverse: ");
          int numberToReverse = scanner.nextInt();
          int reversedNumber = reverseNumber(numberToReverse, 0);
          System.out.println("Reversed number: " + reversedNumber);
          break;
        case 4:
          System.out.print("Enter a number 'n' to solve 1 + 2 + 3 + ... + (n - 1) + n: ");
          int num = scanner.nextInt();
          int sum = solveSum(num);
          System.out.println("Sum: " + sum);
          break;
        case 5:
          System.out.println("Exiting the program. Goodbye!");
          break;
        default:
          System.out.println("Invalid choice. Please choose a valid option (1-5).");
          break;
      }
    } while (choice != 5);

    scanner.close();
  }

  // Recursive function to find GCD (Greatest Common Divisor)
  public static int findGCD(int a, int b) {
    if (b == 0) {
      return a;
    }
    return findGCD(b, a % b);
  }

  // Recursive function to find LCM (Least Common Multiple)
  public static int findLCM(int a, int b) {
    return (a * b) / findGCD(a, b);
  }

  // Recursive function to calculate Fibonacci numbers
  public static int fibonacci(int n) {
    if (n <= 1) {
      return n;
    }
    return fibonacci(n - 1) + fibonacci(n - 2);
  }

  // Recursive function to reverse a number
  public static int reverseNumber(int num, int reversed) {
    if (num == 0) {
      return reversed;
    }
    return reverseNumber(num / 10, reversed * 10 + num % 10);
  }

  // Recursive function to solve 1 + 2 + 3 + ... + (n - 1) + n
  public static int solveSum(int n) {
    if (n == 1) {
      return 1;
    }
    return n + solveSum(n - 1);
  }
}
