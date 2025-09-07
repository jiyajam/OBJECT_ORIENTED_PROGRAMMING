import java.io.FileWriter;
import java.io.IOException;

public class Task_2 {

    public static void main(String[] args) {
        final int COUNT = 60;
        long[] fib = new long[COUNT];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i < COUNT; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        try (FileWriter writer = new FileWriter("fibonacci.csv")) {
            for (int i = 0; i < COUNT; i++) {
                writer.write(fib[i] + "\n");
            }
            System.out.println("Fibonacci sequence written to fibonacci.csv");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
