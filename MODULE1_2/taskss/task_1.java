import java.util.Scanner;

public class task_1 {
    public static void main(String[]args){
        Scanner scanner= new Scanner(System.in);

        System.out.println("Enter temperature in fahrenheit: ");
        double fahrenheit = Double.parseDouble(scanner.nextLine());

        double celsius = (fahrenheit-32) * 5/9;

        System.out.printf("The temperature of %.1f fahrenheit is %.1f celsius.", fahrenheit, celsius);

    }
}
