import java.util.Scanner;

public class task_2 {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter a binary number(composed of 0s and 1s): ");
        String binary=(scanner.nextLine());

        int decimalVal=0;
        int length = binary.length();

        for  (int i = 0; i < length; i++) {
            char bitChar = binary.charAt(i);
            int bit = bitChar - '0';
            int power = length - 1 - i;
            int value = bit * (int)Math.pow(2, power);
            decimalVal += value;
        }
             System.out.println("Decimal equivalent: " + decimalVal);

    }
}
