import java.util.concurrent.locks.ReentrantLock;

public class CountingThread extends Thread {
    public static final int NUM_THREAD = 4;
    public static long count = 0;
    public static long max = 100000;
    public ReentrantLock lock = new ReentrantLock();

    @Override
    synchronized public void run() {
        lock.lock();
        try {
            for (long i = 1; i <= max / NUM_THREAD; i++) {
                count++;
            }
            System.out.println(count);
        } finally {
            lock.unlock();
        }
    }
}
