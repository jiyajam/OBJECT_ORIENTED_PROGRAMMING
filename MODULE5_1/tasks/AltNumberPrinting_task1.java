public class AltNumberPrinting_task1 extends Thread {
    private String threadType;
    private int maxRange;
    private static int currentNumber = 1;

    public AltNumberPrinting_task1(String type, int range) {
        threadType = type;
        maxRange = range;
    }

    public void run() {
        try {
            while (currentNumber <= maxRange) {
                if (threadType.equals("Odd") && currentNumber % 2 == 1) {
                    System.out.println("Odd Thread: " + currentNumber);
                    currentNumber++;
                    Thread.sleep(10); // small delay to allow alternation
                } else if (threadType.equals("Even") && currentNumber % 2 == 0) {
                    System.out.println("Even Thread: " + currentNumber);
                    currentNumber++;
                    Thread.sleep(10); // small delay to allow alternation
                } else {
                    Thread.yield(); // give other thread a chance
                }
            }
        } catch (InterruptedException e) {
            return; // end this thread
        }
    }

    public static void main(String[] args) {
        new AltNumberPrinting_task1("Odd", 19).start();
        new AltNumberPrinting_task1("Even", 19).start();

        // Wait a bit then print completion message
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // ignore
        }
        System.out.println("Printing complete.");
    }
}


