package TSI_Java_courses;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import jdk.internal.cmm.SystemResourcePressureImpl;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);


        do
            System.out.println("Wanna play?");
            String answer2 = scanner.next();

            while (answer2.equals("no")) {
                System.out.println("Ok. Good bye.");
            }

            while (answer2.equals("")) {
                System.out.println("Ok... Good bye.");
            }

            while (answer2.equals("yes")) {
                System.out.println("I'm thinking of a number from 1 to 100. Try tp guess it!"); }
                {

                    int randNum = random.nextInt(100) + 1;

                    System.out.println(randNum);
                }

                int userNum = scanner.nextInt();
                int randNum = random.nextInt(100) + 1;

                for (int i = 0; i < 5; i++) {
                    System.out.println("Try # " + (i + 1));
                    {
                        System.out.println(userNum);
                    }

                    if ((randNum) < (userNum)) {

                        System.out.println("My Number is Higher");
                    } else if ((randNum) > (userNum)) {

                        System.out.println("My Number is Lower");

                    } else if ((randNum) == (userNum)) {

                        System.out.println("That is My Number!!!");
                        break;









