public class VirtualThreadsExample {
    public static void main(String[] args) throws InterruptedException {
        int threadCount = 100_000;

        // Measure time for virtual threads
        long start = System.currentTimeMillis();

        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            threads[i] = Thread.startVirtualThread(() -> {
                System.out.println("Hello from virtual thread " + Thread.currentThread().threadId());
            });
        }

        for (Thread t : threads) {
            t.join();
        }

        long duration = System.currentTimeMillis() - start;
        System.out.println("Time taken for " + threadCount + " virtual threads: " + duration + " ms");
    }
}
