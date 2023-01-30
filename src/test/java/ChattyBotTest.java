import static org.junit.jupiter.api.Assertions.assertEquals;

import Entity.ChattyBot;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


public class ChattyBotTest {
    private static final InputStream DEFAULT_STDIN = System.in;

    @AfterEach
    public void rollbackChangesToStdin() {
        System.setIn(DEFAULT_STDIN);
    }

    @Test
    void greet() {
        PrintStream original = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream tps = new PrintStream(baos);
        System.setOut(tps);
        ChattyBot.greet("Max","2002");
        System.setOut(original);
        tps.flush();
        assertEquals("Hello! My name is Max.\n" +
                "I was created in 2002.\n" +
                "Please, remind me your name.\n", baos.toString());
    }

    @Test
    void remindName() throws IOException {

        InputStream originalIn = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("max\n".getBytes());
        System.setIn(in);

        PrintStream original = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream tps = new PrintStream(baos);
        System.setOut(tps);

        ChattyBot.remindName(new Scanner(System.in));
        System.setIn(originalIn);
        System.setOut(original);
        tps.flush();
        assertEquals("What a great name you have, max!\n", baos.toString());
    }

    @Test
    void guessAge() throws IOException {
        InputStream originalIn = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1 2 3\n".getBytes());
        System.setIn(in);

        PrintStream original = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream tps = new PrintStream(baos);
        System.setOut(tps);

        ChattyBot.guessAge(new Scanner(System.in));
        System.setOut(original);
        System.setIn(originalIn);
        tps.flush();
        assertEquals("Let me guess your age.\n" +
                "Enter remainders of dividing your age by 3, 5 and 7.\n" +
                "Your age is 52; that's a good time to start programming!\n", baos.toString());
    }

    @Test
    void count() throws IOException {

        InputStream originalIn = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("4\n".getBytes());
        System.setIn(in);

        PrintStream original = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream tps = new PrintStream(baos);
        System.setOut(tps);

        ChattyBot.countToInputNumber(new Scanner(System.in));
        System.setOut(original);
        System.setIn(originalIn);
        tps.flush();
        assertEquals("Now I will prove to you that I can count to any number you want.\n" +
                "0!\n" +
                "1!\n" +
                "2!\n" +
                "3!\n" +
                "4!\n", baos.toString());
    }

    @Test
    void test_with_correct_answer() throws IOException {
        InputStream originalIn = System.in;
        PrintStream original = System.out;
        ByteArrayInputStream in = new ByteArrayInputStream("1\n".getBytes());
        System.setIn(in);


        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream tps = new PrintStream(baos);
        System.setOut(tps);

        ChattyBot.askQuestion(new Scanner(System.in));
        System.setOut(original);
        System.setIn(originalIn);
        tps.flush();
        assertEquals("Let's test your programming knowledge.\n" +
                "Why do we use methods?\n" +
                "1. To repeat a statement multiple times.\n" +
                "2. To decompose a program into several small subroutines.\n" +
                "3. To determine the execution time of a program.\n" +
                "4. To interrupt the execution of a program.\n", baos.toString());
    }

    @Test
    void end() {
        PrintStream original = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream tps = new PrintStream(baos);
        System.setOut(tps);

        ChattyBot.goodbyeAndEnd();
        System.setOut(original);
        tps.flush();
        assertEquals("Congratulations, have a nice day!\n", baos.toString());
    }
}