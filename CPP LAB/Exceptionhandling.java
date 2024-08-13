public class Exceptionhandling {
  public static void main(String[] args) {
    int a = 5;
    int b = 0;
    int[] marks = { 12, 50, 100, 98, 64 };
    try {
      // int c = a / b;
      // System.out.println(c);
      System.out.println(marks[5]);
    } catch (ArithmeticException ae) {
      System.out.println(ae);
    } catch (ArrayIndexOutOfBoundsException e) {
      e.printStackTrace();
    } finally {
      System.out.println("The code has been executed successfully");
    }
  }
}
