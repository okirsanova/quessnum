package TSI_Java_courses;


import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        String answer;
        do {
            System.out.println("I'm thinking of a number from 1 to 100. Try to guess it!");

            int randNum = random.nextInt(100) + 1;
            System.out.println("Secret Number is " + randNum);

            for (int i = 1; i <= 10; i++) {
                System.out.println("Try # " + i );

                int userNum = scanner.nextInt();
                System.out.println(userNum);

                if (randNum < userNum) {

                    System.out.println("My Number is Higher");}

                else if (randNum > userNum) {

                    System.out.println("My Number is Lower"); }

                if (randNum == userNum) {

                    System.out.println("That is My Number!!!");
                    break; }

                if (i == 10) {
                    System.out.println("Looser! My number was " + userNum); }

            }

            System.out.println("Once more?");
            answer = scanner.next();
            System.out.println(answer);

        } while (answer.equals("yes"));

        System.out.println("Good bye!");

    }
}










