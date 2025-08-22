import java.util.Scanner;

public class task_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter a positive integer(start): ");
        int start = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter another positive integer(end): ");
        int end = Integer.parseInt(scanner.nextLine());

        if (start > end){
            System.out.println("Can't do that");

        } else {
            for (int n = start; n <= end; n++) {
                boolean isPrime = true;
                for (int i = 2; i < n; i++) {
                    if (n % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime && n > 1) {
                    System.out.println("the prime numbers are: "+ n);
                }
            }
        }
    }
}