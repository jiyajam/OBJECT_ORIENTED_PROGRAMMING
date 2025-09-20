import java.util.ArrayList;
import java.util.List;

class ThreadSafeList<T> {
    private List<T> list;

    public ThreadSafeList() {
        this.list = new ArrayList<>();
    }

    public synchronized void add(T element) {
        list.add(element);
    }

    public synchronized int size() {
        return list.size();
    }

    public synchronized boolean remove(T element) {
        return list.remove(element);
    }

    public synchronized T removeAt(int index) {
        if (index >= 0 && index < list.size()) {
            return list.remove(index);
        }
        return null;
    }

    public synchronized T get(int index) {
        if (index >= 0 && index < list.size()) {
            return list.get(index);
        }
        return null;
    }
}

class ListWorker implements Runnable {
    private ThreadSafeList<String> threadSafeList;
    private int workerId;
    private int operations;

    public ListWorker(ThreadSafeList<String> list, int workerId, int operations) {
        this.threadSafeList = list;
        this.workerId = workerId;
        this.operations = operations;
    }

    public void run() {
        for (int i = 0; i < operations; i++) {

            threadSafeList.add("Worker" + workerId + "-Item" + i);

            // Checking size
            if (i % 10 == 0) {
                System.out.println("Worker " + workerId + " - Current size: " + threadSafeList.size());
            }
        }

        // to remove some elements
        for (int i = 0; i < operations / 2; i++) {
            threadSafeList.remove("Worker" + workerId + "-Item" + i);
        }

        System.out.println("Worker " + workerId + " completed. Final size: " + threadSafeList.size());
    }
}

public class ThreadSafeTest {
    public static void main(String[] args) {
        ThreadSafeList<String> threadSafeList = new ThreadSafeList<>();
        final int NUM_WORKERS = 5;
        final int OPERATIONS_PER_WORKER = 100;

        Thread[] workers = new Thread[NUM_WORKERS];

        System.out.println("Starting thread-safety test with " + NUM_WORKERS + " workers");

        // Create and start worker threads
        for (int i = 0; i < NUM_WORKERS; i++) {
            workers[i] = new Thread(new ListWorker(threadSafeList, i + 1, OPERATIONS_PER_WORKER));
            workers[i].start();
        }


        try {
            for (Thread worker : workers) {
                worker.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All workers completed.");
        System.out.println("Final list size: " + threadSafeList.size());
        System.out.println("Thread-safety test completed successfully.");
    }
}

