/* Thread class to calculate sum of elements in a section of an array */
public class SumHunter_task2 extends Thread {
    int[] array;
    int startIndex, endIndex;
    long sum;

    /* constructor gets the array and the indices specifying what section to examine */
    SumHunter_task2(int[] array, int startIndex, int endIndex) {
        this.array = array;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        sum = 0;
    }

    /* examine a section of array and calculate the sum of elements */
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            sum += array[i];

            // to give the possibility for other threads to run
            Thread.yield();
        }
    }

    public long getSum() {
        return sum;
    }
}

