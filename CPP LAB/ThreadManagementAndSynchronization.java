import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadManagementAndSynchronization {

    public static void main(String[] args) {
        AtomicInteger counter = new AtomicInteger(0);
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Object lock = new Object(); // Create a lock object

        // Submit the tasks to the ExecutorService
        executorService.submit(() -> {
            synchronized (lock) { // Synchronize on the lock object
                for (int i = 0; i < 100; i++) {
                    counter.incrementAndGet();
                }
            }
        });

        executorService.submit(() -> {
            synchronized (lock) { // Synchronize on the same lock object
                for (int i = 0; i < 100; i++) {
                    counter.incrementAndGet();
                }
            }
        });

        // Shutdown the ExecutorService and wait for all threads to finish executing
        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the final value of the counter
        System.out.println("Final counter value: " + counter.get());
    }
}