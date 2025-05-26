import java.util.concurrent.*;
import java.util.*;

public class CallableExample {
    public static void main(String[] args) {
        // Create a fixed thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Create a list of Callable tasks
        List<Callable<String>> tasks = List.of(
            () -> {
                TimeUnit.SECONDS.sleep(1);
                return "Task 1 completed";
            },
            () -> {
                TimeUnit.SECONDS.sleep(2);
                return "Task 2 completed";
            },
            () -> {
                TimeUnit.SECONDS.sleep(1);
                return "Task 3 completed";
            }
        );

        try {
            // Submit all tasks and get a list of Futures
            List<Future<String>> futures = executor.invokeAll(tasks);

            // Iterate through futures and print the results
            for (Future<String> future : futures) {
                System.out.println(future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            // Shutdown the executor service
            executor.shutdown();
        }
    }
}
