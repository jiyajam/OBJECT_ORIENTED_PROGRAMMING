import java.util.Scanner;

public class task_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Weight (g): \n");
        double Grams = Double.parseDouble(scanner.nextLine());

        double gramsPerLuoti = 13.28;
        double gramsPerNaula = gramsPerLuoti * 32;
        double gramsPerLeiviska = gramsPerNaula * 20;


        int leiviska = (int)(Grams / gramsPerLeiviska);
        double remainingLeiviska = Grams % gramsPerLeiviska;


        int naula = (int)(remainingLeiviska / gramsPerNaula);
        double remainingAfterNaula = remainingLeiviska % gramsPerNaula;


        double luoti = remainingAfterNaula / gramsPerLuoti;


        System.out.printf("%.0f grams is %d leiviskä, %d naula, and %.2f luoti.\n",
                Grams, leiviska, naula, luoti);
    }
}
