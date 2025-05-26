class MessageThread extends Thread {
    private String message;

    public MessageThread(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++) {
            System.out.println(message + " - Count: " + (i + 1));
            try {
                Thread.sleep(500);  // Pause for half a second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class MultiThreadDemo {
    public static void main(String[] args) {
        MessageThread thread1 = new MessageThread("Thread 1");
        MessageThread thread2 = new MessageThread("Thread 2");

        thread1.start();
        thread2.start();
    }
}
