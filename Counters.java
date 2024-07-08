public class Counters {

    public static void main(String[] args) {
        // Create the first thread to count up to 20
        Thread thread1 = new Thread(new CountUp());
        
        // Start the first thread
        thread1.start();
        
        try {
            // Wait for the first thread to finish
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Create the second thread to count down to 0
        Thread thread2 = new Thread(new CountDown());
        
        // Start the second thread
        thread2.start();
        
        try {
            // Wait for the second thread to finish
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class CountUp implements Runnable {
    public void run() {
        for (int i = 1; i <= 20; ++i) {
            System.out.println("Count Up: " + i);
            try {
                Thread.sleep(100); // Sleep for 100 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class CountDown implements Runnable {
    public void run() {
        for (int i = 20; i >= 0; --i) {
            System.out.println("Count Down: " + i);
            try {
                Thread.sleep(100); // Sleep for 100 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
