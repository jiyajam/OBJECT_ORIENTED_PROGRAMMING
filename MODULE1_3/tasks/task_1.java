import java.util.Scanner;

public class task_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter coefficient a:");
        int coefficient_a= Integer.parseInt(scanner.nextLine());

        System.out.println("Enter coefficient b:");
        int coefficient_b= Integer.parseInt(scanner.nextLine());

        System.out.println("Enter coefficient c:");
        int coefficient_c= Integer.parseInt(scanner.nextLine());

        double discriminant=(coefficient_b * coefficient_b) -(4*coefficient_a *coefficient_c);

        if (discriminant < 0) {
            System.out.println("No real roots");
        }
        else {
            double root_1= (-coefficient_b + Math.sqrt(discriminant))/(2*coefficient_a);
            double root_2= (-coefficient_b - Math.sqrt(discriminant))/(2*coefficient_a);

            System.out.printf("the roots are %.2f and %.2f",root_1,root_2);

        }
    }
}