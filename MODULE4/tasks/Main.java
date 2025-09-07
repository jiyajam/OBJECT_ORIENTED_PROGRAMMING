public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        try {
            calculator.add(10);
            calculator.add(20);
            calculator.add(30);
            System.out.println("Total: " + calculator.getValue());

            // Uncomment to test exception
            // calculator.add(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        calculator.reset();
        System.out.println("After reset: " + calculator.getValue());
    }
}
