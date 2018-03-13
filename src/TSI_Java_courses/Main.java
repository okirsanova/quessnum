package TSI_Java_courses;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static File leaderBoardFile = new File("leader-board.txt");

    public static void main(String[] args) {
        ArrayList<GameResult> leaderboard = new ArrayList<>();  // tipa sunduk
        loadLeaderBoard(leaderboard);
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

        saveleaderBoard(leaderboard);
        leaderboard.sort(Comparator
                .<GameResult>comparingLong(g -> g.attempts)
                .<GameResult>thenComparingLong(g -> g.timeResult));
        PrintLeaderBoard(leaderboard);
        System.out.println("Good bye!");
    }

    private static void loadLeaderBoard(ArrayList<GameResult> leaderboard) {
        if (!leaderBoardFile.exists()) {
            return;      //ne chitatj ne sushestvujushij file chtoby nebylo oshybki
        }
        try (Scanner in = new Scanner(leaderBoardFile)) {
            while (in.hasNext()) {
                GameResult r = new GameResult();
                r.userName2 = in.next();
                r.userAge2 = in.next();
                r.attempts = in.nextInt();
                r.timeResult = in.nextLong();
                leaderboard.add(r);
            }

        } catch (IOException e) {
            System.out.println("Can't read a file for some reason");
        }
    }

    private static void saveleaderBoard(ArrayList<GameResult> leaderboard) {
        try (PrintWriter out = new PrintWriter(leaderBoardFile)) {
            for (GameResult r : leaderboard) {
                out.printf("%-10s %s %d %d \n", r.userName2, r.userAge2, r.attempts, r.timeResult);
            }
        } catch (IOException e) {
            System.out.println("Something wrong with file writing");
        }
    }

    private static void PrintLeaderBoard(ArrayList<GameResult> leaderboard) {
        for (GameResult r2 : leaderboard) {
            System.out.printf("%-25s \t Age:%s \t Att:%d \t Time:%.2f sec\n", r2.userName2, r2.userAge2, r2.attempts, r2.timeResult / 1000.0);
        }
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











