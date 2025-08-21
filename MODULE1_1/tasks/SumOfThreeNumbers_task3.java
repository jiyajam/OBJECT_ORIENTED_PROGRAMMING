import java.util.Scanner;

public class SumOfThreeNumbers_task3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give the first number:");
        int first = Integer.parseInt(scanner.nextLine());

        System.out.println("Give the second number:");
        int second = Integer.parseInt(scanner.nextLine());

        System.out.println("Give the third number:");
        int third = Integer.parseInt(scanner.nextLine());

        System.out.println("The sum of the numbers is " + (first + second + third));
        System.out.println("The product of the numbers is " + (first * second * third));
        System.out.println("The sum of the numbers is " + ((first + second + third)/3.0));
    }
}
/*
I think , the main reason it does not work with just the number 3
is because java then takes all the numbers to be just integers and not decimals .
So it also gives out the answer in integer form . But using 3.0 solves the problem.
*/