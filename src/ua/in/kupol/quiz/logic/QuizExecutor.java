package ua.in.kupol.quiz.logic;

import ua.in.kupol.quiz.model.QuizQuestion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by pavelkulakovsky on 16.06.14.
 */
public class QuizExecutor {

    public List quizExecut(String quizHead, List<QuizQuestion> quizGetQuestions){
        List<QuizQuestion> quizUserAnswers = quizGetQuestions;
        String answer = "";
        System.out.println(quizHead);

        for(QuizQuestion quiz : quizUserAnswers) {
            System.out.println("\n" +quiz.getQuestion());
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
        return quizUserAnswers;
    }
}
