package TSI_Java_courses;


import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        Random random = new Random();
        String answer;
        do {
            System.out.println("I'm thinking of a number from 1 to 100. Try to guess it!");

            int randNum = random.nextInt(100) + 1;
            System.out.println("Secret Number is " + randNum);

            for (int i = 1; i <= 10; i++) {
                System.out.println("Try # " + i);

                int userNum = askNumber();

                System.out.println(userNum);

                if (randNum < userNum) {

                    System.out.println("My Number is Lower");
                } else if (randNum > userNum) {

                    System.out.println("My Number is Higher");
                }

                if (randNum == userNum) {

                    System.out.println("That is My Number!!!");
                    break;
                }

                if (i == 10) {
                    System.out.println("Looser! My number was " + randNum);
                }
            }

            System.out.println("Once more?");
            answer = scanner.next();
            System.out.println(answer);

        } while (answer.equals("yes"));

        System.out.println("Good bye!");

    }

    static String askAnswer() {
        for (; ; ) {
            try {
                String askAnswer = scanner.next();
                if (askAnswer.equalsIgnoreCase("YES")) {
                    System.out.println("Try again!");
                }
                if (askAnswer.equalsIgnoreCase("NO")) {
                    System.out.println("Bye");
                }
            } catch (InputMismatchException e) {
                scanner.next();
                System.out.println("Type an answer YES or NO!");
            }
        }
    }


    static int askNumber() {
        for (; ; ) {
            try {
                int num = scanner.nextInt();
                if (num <= 100 && num >= 1) {
                    return num;
                }
                System.out.println("Oh no! Number " + num + " is in wrong range. Try between 1 and 100");
            } catch (InputMismatchException e) {
                scanner.next();
                System.out.println("Only numbers, please!");
            }
        }
    }
}











