import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < CountingThread.NUM_THREAD; i++) {
            Thread t = new CountingThread();
            threads.add(t);
        }
        for (Thread each : threads) {
            each.start();
        }
        for (Thread each : threads) {
            each.join();
        }
        System.out.println("result : " + CountingThread.count);
    }
}
