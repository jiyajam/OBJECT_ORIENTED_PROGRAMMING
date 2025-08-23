import java.util.Random;
import java.util.Scanner;

public class task_1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many random names do you want to generate?: ");
        int size = scanner.nextInt();

        String[] firstNames = {"Shayla","Valtteri","Carlos","Max","Mitchett"};


        String[] lastNames = {"Bottas","Verstappen","Sainz","Rafeek","Pritchett"};


        Random rand = new Random();

        for (int i = 0; i < size; i++) {

            int first = rand.nextInt(firstNames.length);
            int last =rand.nextInt(lastNames.length);

            String fullName = firstNames[first] + " " + lastNames[last];
            System.out.println(fullName);
        }


    }
 }

//
//        System.out.println("The integers in reverse order:");
//
//        for (int i = size - 1; i >= 0; i--) {
//            System.out.println(numbers[i]);

