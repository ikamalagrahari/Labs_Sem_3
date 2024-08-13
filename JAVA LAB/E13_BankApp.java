class LessBalanceException extends Exception {
  private double withdrawAmount;

  public LessBalanceException(double withdrawAmount) {
    this.withdrawAmount = withdrawAmount;
  }

  public String getMessage() {
    return "Withdraw amount (" + withdrawAmount + " Rs) is not valid. Insufficient balance.";
  }
}

class BankAccount {
  private String accountNumber;
  private double balance;
  private double minimumBalance = 1000; // Minimum balance required

  public BankAccount(String accountNumber) {
    this.accountNumber = accountNumber;
    this.balance = minimumBalance; // Initialize with the minimum balance
  }

  public void deposit(double amount) {
    balance += amount;
    System.out.println("Deposited " + amount + " Rs. New balance: " + balance + " Rs");
  }

  public void withdraw(double amount) throws LessBalanceException {
    if (balance - amount < minimumBalance) {
      throw new LessBalanceException(amount);
    }
    balance -= amount;
    System.out.println("Withdrawn " + amount + " Rs. New balance: " + balance + " Rs");
  }

  public double getBalance() {
    return balance;
  }
}

public class E13_BankApp {
  public static void main(String[] args) {
    BankAccount account1 = new BankAccount("123456");
    BankAccount account2 = new BankAccount("789012");

    account1.deposit(2000);
    account2.deposit(1500);

    try {
      account1.withdraw(500);
      account2.withdraw(2000); // This will throw a LessBalanceException
    } catch (LessBalanceException e) {
      System.err.println("Error: " + e.getMessage());
      // Take appropriate action, like informing the user or reverting the transaction
    }

    System.out.println("Account 1 balance: " + account1.getBalance() + " Rs");
    System.out.println("Account 2 balance: " + account2.getBalance() + " Rs");
  }
}
