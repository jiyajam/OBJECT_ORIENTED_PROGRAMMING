import java.util.Scanner;

public class task_2 {
    public static void main(String[]args){
        Scanner scanner= new Scanner(System.in);

        System.out.println("Enter length of one side of a right triangle : ");
        double length_1 =Double.parseDouble(scanner.nextLine());

        System.out.println("Enter length of the other side of a right triangle : ");
        double length_2 = Double.parseDouble(scanner.nextLine());

        double hypotenuse = Math.sqrt(length_1 * length_1 + length_2 * length_2);

        System.out.printf("The length of the hypotenuse is %.2f", hypotenuse);


    }
}
