class Display {
  public void displayMessage() {
    System.out.println("Hello there");
  }

  protected void finalize() {
    System.out.println("The object is destroyed");
  }
}

public class E4B_Finalization {
  public static void main(String[] args) {
    Display d = new Display();
    d.displayMessage();
    d = null;
    System.gc();
  }
}
