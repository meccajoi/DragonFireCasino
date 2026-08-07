package com.github.zipcodewilmington.casino.games.trivia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameEngine {
    private final List<Question> questions;
    private final TriviaPlayer player;
    private int currentIndex;

    public GameEngine(List<Question> questions, TriviaPlayer player) {
        this.questions = new ArrayList<>(questions);
        Collections.shuffle(this.questions);
        this.player = player;
        this.currentIndex = 0;
    }

    public boolean hasNextQuestion() {
        return currentIndex < questions.size() && !player.isEliminated();
    }

    public Question nextQuestion() {
        return questions.get(currentIndex++);
    }

    public boolean submitAnswer(Question question, char answer) {
        boolean correct = Character.toUpperCase(answer) == question.correctAnswer();
        if (correct) {
            player.recordCorrect(question.difficulty());
        } else {
            player.recordWrong();
        }
        return correct;
    }

    public int getQuestionsAnswered() {
        return currentIndex;
    }

    public int getTotalQuestions() {
        return questions.size();
    }
}