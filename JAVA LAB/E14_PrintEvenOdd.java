public class E14_PrintEvenOdd {
  private static final int MAX_NUMBER = 10;
  private static final Object lock = new Object();
  private static boolean isEvenTurn = true;

  public static void main(String[] args) {
    Thread evenThread = new Thread(new EvenPrinter());
    Thread oddThread = new Thread(new OddPrinter());

    evenThread.start();
    oddThread.start();
  }

  static class EvenPrinter implements Runnable {
    @Override
    public void run() {
      for (int i = 2; i <= MAX_NUMBER; i += 2) {
        synchronized (lock) {
          while (!isEvenTurn) {
            try {
              lock.wait();
            } catch (InterruptedException e) {
              Thread.currentThread().interrupt();
            }
          }
          System.out.println("Even: " + i);
          isEvenTurn = false;
          lock.notify();
        }
      }
    }
  }

  static class OddPrinter implements Runnable {
    @Override
    public void run() {
      for (int i = 1; i <= MAX_NUMBER; i += 2) {
        synchronized (lock) {
          while (isEvenTurn) {
            try {
              lock.wait();
            } catch (InterruptedException e) {
              Thread.currentThread().interrupt();
            }
          }
          System.out.println("Odd: " + i);
          isEvenTurn = true;
          lock.notify();
        }
      }
    }
  }
}
