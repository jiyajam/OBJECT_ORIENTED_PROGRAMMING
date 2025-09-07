public class Calculator {
    private int value = 0;

    public void reset() {
        value = 0;
    }

    public void add(int a) throws IllegalArgumentException {
        if (a < 0) {
            throw new IllegalArgumentException("Negative integers are not allowed");
        }
        value += a;
    }
    public void sum(int[] numbers) {
        for (int number : numbers) {
            if (number < 0) {
                throw new IllegalArgumentException("Negative integers are not allowed");
            }
            value += number;
        }
    }


    public int getValue() {
        return value;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        try {
            calculator.add(5);
            calculator.add(10);
            System.out.println("Current value: " + calculator.getValue()); // Should print 15

            calculator.add(-3); // Should throw exception
        } catch (IllegalArgumentException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
//explanation
/*In this implementation, the Calculator class maintains an internal state represented by the variable value.
The reset() method sets this value back to zero. The add(int a) method adds a positive integer to the current value,
 throwing an IllegalArgumentException if a negative integer is provided. The getValue() method returns the current value of the calculator.
The main method demonstrates how to use the Calculator class and handles exceptions for negative inputs.

 */
