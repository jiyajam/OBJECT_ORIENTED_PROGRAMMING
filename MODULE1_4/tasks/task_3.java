import java.util.Scanner;

public class task_3 {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of the array: ");
        int size=scanner.nextInt();
        int[] integers = new int[size];

        System.out.println("Enter the integers into the array:");

        for(int i =0;i< size;i++){
            System.out.print("Enter integer " + (i + 1) + ": ");
            integers[i]=scanner.nextInt();
        }
        int[] noDuplicate = new int[size];
        int newSize = 0;

        for (int i = 0; i < size; i++) {
            int current = integers[i];

            boolean found = false;
            for (int j = 0; j < newSize; j++) {
                if (noDuplicate[j] == current) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                noDuplicate[newSize] = current;
                newSize++;
            }
        }

        System.out.println("The array without duplicates:");
        for (int i = 0; i < newSize; i++) {
            System.out.print(noDuplicate[i] + " ");
        }
    }
}
