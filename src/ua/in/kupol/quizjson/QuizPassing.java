package ua.in.kupol.quizjson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by pavelkulakovsky on 16.06.14.
 */
public class QuizPassing {

    public List quizPassing(List quizGetQuestions){
        QuizResultWriter quizResultWriter = new QuizResultWriter();
        List<QuizQuestion> quizQuestionPassing = quizGetQuestions;
        String answer = "";

        for(QuizQuestion quiz : quizQuestionPassing) {
            if (quiz.title != null) {
                System.out.println(quizResultWriter.quizInfoWrite(quiz.quizHead()));
            } else {
                System.out.println(quizResultWriter.quizInfoWrite(quiz.quizQuestions()));
                try {
                    System.out.print("Введите ответ: ");
                    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
                    answer = bufferRead.readLine();
                    System.out.print(quizResultWriter.quizInfoWrite("\nВаш ответ: " + answer + "\n"));
                    quiz.answer = answer;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return quizQuestionPassing;
    }
}
