import java.util.Scanner;

public class task_4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int points = 0;

        while (points < 10) {
            points = 0;

            for (int i = 0; i < 10; i++) {
                int factor_1 = (int)(Math.random() * 10) + 1;
                int factor_2 = (int)(Math.random() * 10) + 1;

                System.out.printf("Question %d: What is %d * %d? ", i + 1, factor_1, factor_2);
                int answer = Integer.parseInt(scanner.nextLine());

                if (answer == factor_1 * factor_2) {
                    System.out.println("Correct!");
                    points +=1;
                } else {
                    System.out.println("Wrong!");
                }
            }

            if (points == 10) {
                System.out.println("yay! You have scored all 10 points.");
                break;
            } else {
                System.out.println("You have scored " + points + " points until now. Please try again.");
            }
        }


    }
}


