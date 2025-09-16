import java.util.ArrayList;

public class ParallelSummation_task2 {
    private static final int N = 100000;

    public static void execute(int[] array, int cores) {
        /* split the task to individual threads */
        ArrayList<SumHunter_task2> sumhunters = new ArrayList<>();
        double dy = (double) N /cores;
        for (int i = 0; i < cores; i++) {
            /* Divide array to roughly equally sized groups. The last group may be a little larger due rounding */
            int slicestart = (int)Math.round(i*dy);
            int sliceend = N;
            if (i < cores-1)
                sliceend = (int)Math.round((i+1)*dy);

            /* Then create SumHunter thread/job for that part of the array */
            sumhunters.add(new SumHunter_task2(array, slicestart, sliceend-1));
        }

        /* start threads */
        long start = System.nanoTime();
        for (SumHunter_task2 sh : sumhunters)
            sh.start();

        /* wait for them to complete their tasks, and collect results */
        long result = 0;
        for (SumHunter_task2 sh : sumhunters) {
            try {
                sh.join();
            } catch (InterruptedException e) {
                // thread was interrupted, the result may be incorrect
                e.printStackTrace();
            }
            result += sh.getSum();
        }
        long finish = System.nanoTime();
        long timeElapsed = finish - start;
        System.out.println("Time elapsed " + timeElapsed/10e6 + " ms. The result is " + result);
    }

    public static void main(String[] args) {
        int[] array = new int[N];

        /* create an array having random integer numbers */
        for (int i = 0; i < N; i++)
            array[i] = (int)(Math.random() * 100) + 1; // random numbers 1-100

        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Our system has " + cores + " processor cores\n");
        System.out.print("1 Thread(s): "); execute(array, 1);
        System.out.print("1 Thread(s): "); execute(array, 1);
        System.out.print(cores + " Thread(s): "); execute(array, cores);
    }
}

