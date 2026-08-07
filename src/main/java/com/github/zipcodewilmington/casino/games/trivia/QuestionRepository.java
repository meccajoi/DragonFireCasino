package com.github.zipcodewilmington.casino.games.trivia;

import java.util.ArrayList;
import java.util.List;

import static com.github.zipcodewilmington.casino.games.trivia.Question.Difficulty.EASY;
import static com.github.zipcodewilmington.casino.games.trivia.Question.Difficulty.MEDIUM;
import static com.github.zipcodewilmington.casino.games.trivia.Question.Difficulty.HARD;

public class QuestionRepository {

    public static List<Question> getAllQuestions() {
        List<Question> all = new ArrayList<>();
        all.addAll(getEasyQuestions());
        all.addAll(getMediumQuestions());
        all.addAll(getHardQuestions());
        return all;
    }

    public static List<Question> getByDifficulty(Question.Difficulty difficulty) {
        List<Question> filtered = new ArrayList<>();
        for (Question q : getAllQuestions()) {
            if (q.difficulty() == difficulty) {
                filtered.add(q);
            }
        }
        return filtered;
    }

    private static List<Question> getEasyQuestions() {
        List<Question> list = new ArrayList<>();
        list.add(new Question("What is the capital of France?",
                new String[]{"A) Paris", "B) Rome", "C) Madrid", "D) Berlin"}, 'A', EASY));
        list.add(new Question("Which planet is closest to the sun?",
                new String[]{"A) Venus", "B) Earth", "C) Mercury", "D) Mars"}, 'C', EASY));
        list.add(new Question("What color do you get by mixing red and blue?",
                new String[]{"A) Green", "B) Purple", "C) Orange", "D) Yellow"}, 'B', EASY));
        list.add(new Question("How many days are in a week?",
                new String[]{"A) 5", "B) 6", "C) 7", "D) 8"}, 'C', EASY));
        list.add(new Question("What is the largest ocean on Earth?",
                new String[]{"A) Atlantic", "B) Indian", "C) Arctic", "D) Pacific"}, 'D', EASY));
        list.add(new Question("What is the chemical symbol for water?",
                new String[]{"A) H2O", "B) O2", "C) CO2", "D) H2"}, 'A', EASY));
        list.add(new Question("How many legs does a spider have?",
                new String[]{"A) 6", "B) 8", "C) 10", "D) 4"}, 'B', EASY));
        list.add(new Question("What is the fastest land animal?",
                new String[]{"A) Lion", "B) Horse", "C) Cheetah", "D) Gazelle"}, 'C', EASY));
        list.add(new Question("Which continent is Egypt located in?",
                new String[]{"A) Asia", "B) Africa", "C) Europe", "D) South America"}, 'B', EASY));
        list.add(new Question("How many continents are there on Earth?",
                new String[]{"A) 5", "B) 6", "C) 7", "D) 8"}, 'C', EASY));
        list.add(new Question("What is the freezing point of water in Celsius?",
                new String[]{"A) 0", "B) 32", "C) 100", "D) -10"}, 'A', EASY));
        list.add(new Question("What is the largest planet in our solar system?",
                new String[]{"A) Saturn", "B) Jupiter", "C) Neptune", "D) Earth"}, 'B', EASY));
        list.add(new Question("The Eiffel Tower is located in which country?",
                new String[]{"A) Italy", "B) Spain", "C) France", "D) Germany"}, 'C', EASY));
        list.add(new Question("How many sides does a triangle have?",
                new String[]{"A) 2", "B) 3", "C) 4", "D) 5"}, 'B', EASY));
        list.add(new Question("Who wrote the play 'Romeo and Juliet'?",
                new String[]{"A) Charles Dickens", "B) William Shakespeare", "C) Mark Twain", "D) Jane Austen"}, 'B', EASY));
        list.add(new Question("What is the official currency of Japan?",
                new String[]{"A) Won", "B) Yuan", "C) Yen", "D) Ringgit"}, 'C', EASY));
        list.add(new Question("Which organ in the human body pumps blood?",
                new String[]{"A) Lungs", "B) Liver", "C) Heart", "D) Kidney"}, 'C', EASY));
        return list;
    }

    private static List<Question> getMediumQuestions() {
        List<Question> list = new ArrayList<>();
        list.add(new Question("What is the smallest prime number?",
                new String[]{"A) 0", "B) 1", "C) 2", "D) 3"}, 'C', MEDIUM));
        list.add(new Question("What is the longest river in the world?",
                new String[]{"A) Amazon", "B) Nile", "C) Yangtze", "D) Mississippi"}, 'B', MEDIUM));
        list.add(new Question("What is the chemical symbol for gold?",
                new String[]{"A) Go", "B) Gd", "C) Au", "D) Ag"}, 'C', MEDIUM));
        list.add(new Question("How many bones are in the adult human body?",
                new String[]{"A) 186", "B) 206", "C) 226", "D) 246"}, 'B', MEDIUM));
        list.add(new Question("Which country gifted the Statue of Liberty to the United States?",
                new String[]{"A) England", "B) Spain", "C) France", "D) Italy"}, 'C', MEDIUM));
        list.add(new Question("What is the largest hot desert in the world?",
                new String[]{"A) Gobi", "B) Sahara", "C) Kalahari", "D) Mojave"}, 'B', MEDIUM));
        list.add(new Question("Approximately how fast does light travel, in km per second?",
                new String[]{"A) 30,000", "B) 300,000", "C) 3,000,000", "D) 300"}, 'B', MEDIUM));
        list.add(new Question("Who was the first person to walk on the moon?",
                new String[]{"A) Buzz Aldrin", "B) Yuri Gagarin", "C) Neil Armstrong", "D) John Glenn"}, 'C', MEDIUM));
        list.add(new Question("How many players are on the field for one soccer team during a match?",
                new String[]{"A) 9", "B) 10", "C) 11", "D) 12"}, 'C', MEDIUM));
        list.add(new Question("What is the capital of Australia?",
                new String[]{"A) Sydney", "B) Melbourne", "C) Canberra", "D) Perth"}, 'C', MEDIUM));
        list.add(new Question("Who is credited with inventing the telephone?",
                new String[]{"A) Thomas Edison", "B) Alexander Graham Bell", "C) Nikola Tesla", "D) Guglielmo Marconi"}, 'B', MEDIUM));
        list.add(new Question("What is the official currency of the United Kingdom?",
                new String[]{"A) Euro", "B) Dollar", "C) Pound Sterling", "D) Franc"}, 'C', MEDIUM));
        list.add(new Question("How many strings does a standard guitar have?",
                new String[]{"A) 4", "B) 5", "C) 6", "D) 7"}, 'C', MEDIUM));
        list.add(new Question("What is the largest mammal in the world?",
                new String[]{"A) African Elephant", "B) Blue Whale", "C) Giraffe", "D) Orca"}, 'B', MEDIUM));
        list.add(new Question("Which gas do plants primarily absorb for photosynthesis?",
                new String[]{"A) Oxygen", "B) Nitrogen", "C) Carbon Dioxide", "D) Hydrogen"}, 'C', MEDIUM));
        list.add(new Question("How many hearts does an octopus have?",
                new String[]{"A) 1", "B) 2", "C) 3", "D) 4"}, 'C', MEDIUM));
        list.add(new Question("In what year did World War II end?",
                new String[]{"A) 1943", "B) 1944", "C) 1945", "D) 1946"}, 'C', MEDIUM));
        return list;
    }

    private static List<Question> getHardQuestions() {
        List<Question> list = new ArrayList<>();
        list.add(new Question("What is the smallest country in the world by area?",
                new String[]{"A) Monaco", "B) San Marino", "C) Vatican City", "D) Liechtenstein"}, 'C', HARD));
        list.add(new Question("Which element has the atomic number 1?",
                new String[]{"A) Helium", "B) Hydrogen", "C) Lithium", "D) Oxygen"}, 'B', HARD));
        list.add(new Question("What is the deepest known point in Earth's oceans?",
                new String[]{"A) Puerto Rico Trench", "B) Java Trench", "C) Mariana Trench", "D) Tonga Trench"}, 'C', HARD));
        list.add(new Question("What is the chemical formula for common table salt?",
                new String[]{"A) NaCl", "B) KCl", "C) CaCl2", "D) NaOH"}, 'A', HARD));
        list.add(new Question("How many amendments make up the U.S. Bill of Rights?",
                new String[]{"A) 8", "B) 9", "C) 10", "D) 12"}, 'C', HARD));
        list.add(new Question("How many chromosomes are typically found in a human cell?",
                new String[]{"A) 23", "B) 44", "C) 46", "D) 48"}, 'C', HARD));
        list.add(new Question("Besides Saturn, which planet is notable for having rings tilted nearly 98 degrees?",
                new String[]{"A) Jupiter", "B) Uranus", "C) Neptune", "D) Mars"}, 'B', HARD));
        list.add(new Question("Which of these is considered one of the first widely used high-level programming languages?",
                new String[]{"A) Python", "B) Fortran", "C) Java", "D) COBOL"}, 'B', HARD));
        list.add(new Question("What is the official currency of Russia?",
                new String[]{"A) Ruble", "B) Hryvnia", "C) Lev", "D) Zloty"}, 'A', HARD));
        list.add(new Question("Which physicist wrote 'A Brief History of Time'?",
                new String[]{"A) Albert Einstein", "B) Richard Feynman", "C) Stephen Hawking", "D) Carl Sagan"}, 'C', HARD));
        list.add(new Question("The Byzantine Empire was the continuation of which empire's eastern half?",
                new String[]{"A) Persian Empire", "B) Roman Empire", "C) Ottoman Empire", "D) Macedonian Empire"}, 'B', HARD));
        list.add(new Question("Which cell structure is often called the 'powerhouse of the cell'?",
                new String[]{"A) Nucleus", "B) Ribosome", "C) Mitochondria", "D) Golgi Apparatus"}, 'C', HARD));
        list.add(new Question("Who was the first person to win Nobel Prizes in two different sciences?",
                new String[]{"A) Albert Einstein", "B) Marie Curie", "C) Niels Bohr", "D) Dorothy Hodgkin"}, 'B', HARD));
        list.add(new Question("Which treaty is credited with ending the Thirty Years' War in 1648?",
                new String[]{"A) Treaty of Versailles", "B) Treaty of Westphalia", "C) Treaty of Paris", "D) Treaty of Utrecht"}, 'B', HARD));
        list.add(new Question("The Higgs boson particle was confirmed at CERN in which year?",
                new String[]{"A) 2008", "B) 2010", "C) 2012", "D) 2015"}, 'C', HARD));
        list.add(new Question("Who is widely regarded as the first computer programmer?",
                new String[]{"A) Grace Hopper", "B) Alan Turing", "C) Ada Lovelace", "D) Charles Babbage"}, 'C', HARD));
        return list;
    }
}