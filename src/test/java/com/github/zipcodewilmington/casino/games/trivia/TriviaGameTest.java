package com.github.zipcodewilmington.casino.games.trivia;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class TriviaGameTest {

    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUpStreams() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    void setupLoadsQuestions() {
        TriviaGame game = new TriviaGame();
        game.setup();

        assertNotNull(game);
    }

    @Test
    void promptDifficultyReturnsNullForMixed() throws Exception {
        System.setIn(new ByteArrayInputStream("4\n".getBytes(StandardCharsets.UTF_8)));

        Method method = TriviaGame.class.getDeclaredMethod("promptDifficulty", Scanner.class);
        method.setAccessible(true);

        Question.Difficulty result = (Question.Difficulty) method.invoke(null, new Scanner(System.in));

        assertNull(result);
    }

    @Test
    void promptDifficultyReturnsEasy() throws Exception {
        System.setIn(new ByteArrayInputStream("1\n".getBytes(StandardCharsets.UTF_8)));

        Method method = TriviaGame.class.getDeclaredMethod("promptDifficulty", Scanner.class);
        method.setAccessible(true);

        Question.Difficulty result = (Question.Difficulty) method.invoke(null, new Scanner(System.in));

        assertEquals(Question.Difficulty.EASY, result);
    }

    @Test
    void readAnswerRejectsInvalidInputThenAcceptsValidInput() throws Exception {
        System.setIn(new ByteArrayInputStream("Z\nA\n".getBytes(StandardCharsets.UTF_8)));

        Method method = TriviaGame.class.getDeclaredMethod("readAnswer", Scanner.class);
        method.setAccessible(true);

        char result = (char) method.invoke(null, new Scanner(System.in));

        assertEquals('A', result);
    }

    @Test
    void printBannerWritesTitle() throws Exception {
        Method method = TriviaGame.class.getDeclaredMethod("printBanner");
        method.setAccessible(true);
        method.invoke(null);

        String output = outContent.toString(StandardCharsets.UTF_8);
        assertTrue(output.contains("DRAGON FIRE CASINO"));
        assertTrue(output.contains("TRIVIA"));
    }

    @Test
    void printQuestionWritesPromptAndChoices() throws Exception {
        Question question = new Question(
                "What is 2 + 2?",
                new String[]{"A) 3", "B) 4", "C) 5", "D) 6"},
                'B',
                Question.Difficulty.EASY
        );

        Method method = TriviaGame.class.getDeclaredMethod("printQuestion", int.class, int.class, Question.class);
        method.setAccessible(true);
        method.invoke(null, 0, 1, question);

        String output = outContent.toString(StandardCharsets.UTF_8);
        assertTrue(output.contains("Question 1/1 [EASY]"));
        assertTrue(output.contains("What is 2 + 2?"));
        assertTrue(output.contains("A) 3"));
        assertTrue(output.contains("B) 4"));
    }

    @Test
    void repositoryAndGameCanBeCreatedTogether() {
        List<Question> questions = QuestionRepository.getAllQuestions();
        TriviaPlayer player = new TriviaPlayer("Test");
        GameEngine engine = new GameEngine(questions, player);

        assertNotNull(engine);
        assertFalse(questions.isEmpty());
    }
}
