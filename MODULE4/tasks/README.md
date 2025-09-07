**This program implements a simple calculator model using Model-View-Controller pattern. 
The calculator is able to add positive integers, reset its value to zero, and return the current value. 
It demonstrates basic exception handling for invalid input
public class Calculator {
private int value = 0;**

```java
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
```


Below the code, explained by copilot on  how the class works.

### Explanation
The `Calculator` class is a simple implementation of a calculator that follows the MVC (Model-View-Controller) design pattern. It maintains an internal state represented by the `value` variable, which holds the current value of the calculator.
- **reset()**: This method resets the calculator's value to zero.
- **add(int a)**: This method adds a positive integer `a` to the current
- value. If a negative integer is passed, it throws an `IllegalArgumentException` to indicate that negative integers are not allowed.
- **getValue()**: This method returns the current value of the calculator.
- **main(String[] args)**: This is the entry point of the program. It creates an instance of the `Calculator` class, adds some positive integers, and prints the current value. It also demonstrates exception handling by attempting to add a negative integer, which results in an exception being caught and its message printed.value. If a negative integer is passed, it throws an `IllegalArgumentException` to indicate that negative integers are not allowed.
-