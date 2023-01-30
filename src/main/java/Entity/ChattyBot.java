package Entity;

import java.util.Scanner;

public class ChattyBot {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        greet("Max", "2002"); // change it as you need
        remindName(scanner);
        guessAge(scanner);
        countToInputNumber(scanner);
        askQuestion(scanner);
        goodbyeAndEnd();
    }

    static void greet(String assistantName, String birthYear) {
        System.out.println("Hello! My name is " + assistantName + ".");
        System.out.println("I was created in " + birthYear + ".");
        System.out.println("Please, remind me your name.");
    }

    static void remindName(Scanner scanner) {
        String name = scanner.nextLine();
        System.out.println("What a great name you have, " + name + "!");
    }

    static void guessAge(Scanner scanner) {
        System.out.println("Let me guess your age.");
        System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");
        int rem3 = scanner.nextInt();
        int rem5 = scanner.nextInt();
        int rem7 = scanner.nextInt();
        int age = getAgeByFormula(rem3, rem5, rem7);
        System.out.println("Your age is " + age + "; that's a good time to start programming!");
    }

    private static int getAgeByFormula(int rem3, int rem5, int rem7) {
        return (rem3 * 70 + rem5 * 21 + rem7 * 15) % 105;
    }

    static void countToInputNumber(Scanner scanner) {
        System.out.println("Now I will prove to you that I can count to any number you want.");
        int num = scanner.nextInt();
        for (int i = 0; i <= num; i++) {
            System.out.printf("%d!\n", i);
        }
    }

    static void askQuestion(Scanner scanner) {
        System.out.println("Let's test your programming knowledge.");
        System.out.println("Why do we use methods?\n" +
                "1. To repeat a statement multiple times.\n" +
                "2. To decompose a program into several small subroutines.\n" +
                "3. To determine the execution time of a program.\n" +
                "4. To interrupt the execution of a program.");

        switch (scanner.nextInt()){
            case 1:
                break;
            case 2:
            case 3:
            case 4:
            default:
                System.out.println("Please, try again.");
                askQuestion(scanner);
                break;
        }
    }

    static void goodbyeAndEnd() {
        System.out.println("Congratulations, have a nice day!"); // Do not change this text
    }
}
