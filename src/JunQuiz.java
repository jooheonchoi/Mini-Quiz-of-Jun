import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class JunQuiz {
    private int attempts = 0;
    private static final int outOf = 3;

    private static final String QUIT_STRING = "q";
    private static final String NEXT_STRING = "n";
    private static final String wrongAnswer = "Nope! Try again or press " + NEXT_STRING + " to move on:\n";
    private String[] q1Answers = {"canucks", "vancouver canucks"};
    private String[] q2Answers = {"cooking", "inline hockey", "piano", "playing piano", "painting", "dioramas"};
    private String[] q3Answers = {"c", "c++", "sql", "python", "typescript", "javascript", "html", "css", "java"};

    public JunQuiz() {
        List<String> a1 = new ArrayList<>(Arrays.asList(q1Answers));
        List<String> a2 = new ArrayList<>(Arrays.asList(q2Answers));
        List<String> a3 = new ArrayList<>(Arrays.asList(q3Answers));

        String question1 = "Which is Jun's favourite NHL team?";
        String question2 = "What is one of Jun's hobbies?";
        String question3 =
                "Name a computer language (not necessarily a programming language) that Jun is experienced in.";

        String prompt1 = "Correct! Jun's favourite team is the ";
        String prompt2 = "Correctomundo! One of Jun's hobbies is ";
        String prompt3 = "Yes! Jun is fluent in ";

        Scanner scanner = new Scanner(System.in);
        String input = null;

        System.out.println("WELCOME TO A MINI QUIZ OF JUN\n");
        System.out.println("At anytime, press " + QUIT_STRING + " to exit.");

        // questions of the quiz
        question(input, scanner, question1,  a1, prompt1);
        question(input, scanner, question2,  a2, prompt2);
        question(input, scanner, question3,  a3, prompt3);

        System.out.println("You finished with " + attempts + " attempts for " + outOf + " questions.");
        if (attempts == outOf) {
            System.out.println("Nice! You must know Jun pretty well!");
        }
    }


    public void question(String input, Scanner scanner, String question, List<String> answers, String correctPrompt) {
        while (true) {
            System.out.println(question);
            input = scanner.next();
            if (checkQuitOrNext(input) == 0) {
                return;
            };
            input = input.trim().toLowerCase();
            attempts++;
            if (answers.contains(input)) {
                System.out.println(correctPrompt + input + ".\n");
                break;
            } else {
                System.out.println(wrongAnswer);
            }
        }
    }

    private static int checkQuitOrNext(String input) {
        if (input.equals(QUIT_STRING)) {
            System.out.println("Thanks for trying this test out!");
            exit(0);
            return -1;
        } else if (input.equals(NEXT_STRING)) {
            return 0;
        } else {
            return 1;
        }
    }



    public static void main(String[] args) {
        new JunQuiz();
    }
}
