package ua.in.kupol.quiz.logic;

import ua.in.kupol.quiz.model.QuizQuestion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by pavelkulakovsky on 16.06.14.
 */
public class QuizExecutor {
    private final Logger log;

    public QuizExecutor(){
        log = Logger.getLogger(getClass().getName());
//        log.setLevel(Level.FINEST);
    }

    public List quizExecut(String quizHead, List<QuizQuestion> quizGetQuestions){
        List<QuizQuestion> quizUserAnswers = quizGetQuestions;
        String answer = "";
        System.out.println(quizHead);

//        log.config("Start dialogue with user");
        log.setLevel(Level.INFO);
        log.severe("Info Log");
        log.warning("Info Log");
        log.info("Info Log");
        log.finest("Really not important");

        for(QuizQuestion quiz : quizUserAnswers) {
            System.out.println("\n" + quiz.getQuestion());
            System.out.println(quiz.getChoice());
            try {
                System.out.print("Введите ответ: ");
                BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
                answer = bufferRead.readLine();
                System.out.print("\nВаш ответ: " + answer + "\n");
                quiz.setAnswer(answer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        log.fine("Finish dialogue with user");
        return quizUserAnswers;
    }
}
