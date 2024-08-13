import java.util.Scanner;

class InvalidPasswordException extends Exception {
  public InvalidPasswordException(String message) {
    super(message);
  }
}

public class E12_LoginApp {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter your login ID: ");
    String loginId = scanner.nextLine();

    try {
      System.out.print("Enter your password: ");
      String password = scanner.nextLine();

      if (isValidPassword(password)) {
        System.out.println("Login Successful!");
      } else {
        throw new InvalidPasswordException(
            "Please enter a valid password of length 8 containing one digit and one special symbol.");
      }
    } catch (InvalidPasswordException e) {
      System.err.println("Error: " + e.getMessage());
    }

    scanner.close();
  }

  // Function to check if a password is valid
  private static boolean isValidPassword(String password) {
    if (password.length() != 8) {
      return false;
    }

    boolean hasDigit = false;
    boolean hasSpecialSymbol = false;

    for (char ch : password.toCharArray()) {
      if (Character.isDigit(ch)) {
        hasDigit = true;
      } else if (!Character.isLetterOrDigit(ch)) {
        hasSpecialSymbol = true;
      }
    }

    return hasDigit && hasSpecialSymbol;
  }
}
