package TSI_Java_courses;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
         // System.out.println("Current time is " + time/1000/60/60/24/365);
        ArrayList<GameResult> leaderboard = new ArrayList<>();  // tipa sunduk

        // try

        String answer;
        do {
            System.out.println("What is your name?");
            String name = scanner.next();
            System.out.println("What is your age?");
            String age = scanner.next();
            GameResult r = doGame(name, age);
            if (r != null) {
                leaderboard.add(r);
            }
            System.out.println("Once more?");
            answer = scanner.next();
            System.out.println(answer);

        } while (answer.equals("yes"));
        System.out.println("Winner chart:");

        for (GameResult r2 : leaderboard) {
            System.out.println(r2.userName2 + "\t Age: " + r2.userAge2 +  "\t Att: " + r2.attempts + " \t Time: " + r2.timeResult/1000);

        }

        // catch no such element exception e

        System.out.println("Good bye!");

    }

    private static GameResult doGame(String userName, String userAge) {   // nuzhen parametr, peredajutsja po porjadku
        System.out.println("Hello " + userName);
        System.out.println("You are " + userAge + " years old.");
        long time1 = System.currentTimeMillis();
        System.out.println("I'm thinking of a number from 1 to 100. Try to guess it!");

        int randNum = random.nextInt(100) + 1;
        System.out.println("Secret Number is " + randNum);

        GameResult result = new GameResult();
        result.userName2 = userName;
        result.userAge2 = userAge;

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
                long time2 = System.currentTimeMillis();
                System.out.println("That is My Number! You won in " + i + " attempts");
                result.attempts = i;
                result.timeResult = (time2 - time1);
                return result;
            }

        }
        System.out.println("Looser! My number was " + randNum);
        return null;
    }

//    static String askAnswer() {
//        for (; ; ) {
//            try {
//                String askAnswer = scanner.next();
//                if (askAnswer.equalsIgnoreCase("YES")) {
//                    System.out.println("Try again!");
//                }
//                if (askAnswer.equalsIgnoreCase("NO")) {
//                    System.out.println("Bye");
//                }
//            } catch (InputMismatchException e) {
//                scanner.next();
//                System.out.println("Type an answer YES or NO!");
//            }
//        }
//    }

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
//            catch (InputMismatchException | NoSuchElementException e) {
//                            scanner.next();
//                            System.out.println("Only numbers, please!");
//                        }
        }
    }
}











