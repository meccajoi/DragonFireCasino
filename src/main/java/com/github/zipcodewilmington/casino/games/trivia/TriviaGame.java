package com.github.zipcodewilmington.casino.games.trivia;

import java.util.List;
import java.util.Scanner;

import com.github.zipcodewilmington.casino.GameInterface;

public class TriviaGame implements GameInterface {
    private List<Question> questions;

    @Override
    public void setup() {
        questions = QuestionRepository.getAllQuestions();
    }

    @Override
    public void play() {
        if (questions == null) {
            questions = QuestionRepository.getAllQuestions();
        }
        
        Scanner scanner = new Scanner(System.in);

        try {
            printBanner();

            System.out.print("Enter your name: ");
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                name = "Player";
            }

            TriviaPlayer player = new TriviaPlayer(name);

            Question.Difficulty chosenDifficulty = promptDifficulty(scanner);
            List<Question> pool = (chosenDifficulty == null)
                    ? questions
                    : QuestionRepository.getByDifficulty(chosenDifficulty);

            GameEngine engine = new GameEngine(pool, player);

            System.out.println("\nLet's go, " + player.getName() + "! Answer with A, B, C, or D.");
            System.out.println("Get 3 wrong and the round is over. Good luck!\n");

            while (engine.hasNextQuestion()) {
                Question question = engine.nextQuestion();
                printQuestion(engine.getQuestionsAnswered(), engine.getTotalQuestions(), question);

                char answer = readAnswer(scanner);
                boolean correct = engine.submitAnswer(question, answer);

                if (correct) {
                    System.out.printf("Correct! You earned $%d.%n", question.difficulty().getReward());
                } else {
                    System.out.println("Incorrect!");
                    System.out.println("The correct answer was: " + question.correctAnswer());
                }

                System.out.printf("Balance: $%.2f | Strikes: %d/3%n%n",
                        player.getBalance(), player.getWrongCount());
            }

            printSummary(player);

        } finally {
            scanner.close();
        }
    }

    private static void printBanner() {
        System.out.println("============================================");
        System.out.println("      DRAGON FIRE CASINO — TRIVIA");
        System.out.println("============================================");
    }

    private static Question.Difficulty promptDifficulty(Scanner scanner) {
        while (true) {
            System.out.println("\nChoose a difficulty:");
            System.out.println("  1) Easy   ($1 per correct answer)");
            System.out.println("  2) Medium ($3 per correct answer)");
            System.out.println("  3) Hard   ($5 per correct answer)");
            System.out.println("  4) Mixed  (all difficulties)");
            System.out.print("Your choice: ");

            String input = scanner.nextLine().trim();
            switch (input) {
                case "1":
                    return Question.Difficulty.EASY;
                case "2":
                    return Question.Difficulty.MEDIUM;
                case "3":
                    return Question.Difficulty.HARD;
                case "4":
                    return null;
                default:
                    System.out.println("Please enter 1, 2, 3, or 4.");
            }
        }
    }

    private static void printQuestion(int answeredSoFar, int total, Question question) {
        int questionNumber = answeredSoFar + 1;
        System.out.printf("Question %d/%d [%s]%n", questionNumber, total, question.difficulty());
        System.out.println(question.prompt());
        for (String choice : question.choices()) {
            System.out.println("  " + choice);
        }
    }

    private static char readAnswer(Scanner scanner) {
        while (true) {
            System.out.print("Your answer: ");
            String raw = scanner.nextLine().trim().toUpperCase();
            if (raw.length() == 1 && "ABCD".contains(raw)) {
                return raw.charAt(0);
            }
            System.out.println("Please enter A, B, C, or D.");
        }
    }

    private static void printSummary(TriviaPlayer player) {
        System.out.println("============================================");
        if (player.isEliminated()) {
            System.out.println("You struck out after 3 wrong answers.");
        } else {
            System.out.println("You made it through every question!");
        }
        System.out.println("Thanks for playing, " + player.getName() + "!");
        System.out.println("--------------------------------------------");
        System.out.printf("Correct answers: %d%n", player.getCorrectCount());
        System.out.printf("Wrong answers:   %d%n", player.getWrongCount());
        System.out.printf("Total winnings:  $%.2f%n", player.getBalance());
        System.out.println("============================================");
    }
        @Override
        public String getRules() {
        return "Answer questions. Three wrong answers ends the game.";
        }

        @Override
        public int getMinPlayers() {
        return 1;
        }

        @Override
        public int getMaxPlayers() {
        return 1;
}
}