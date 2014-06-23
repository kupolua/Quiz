package ua.in.kupol.quiz.logic;

import org.apache.log4j.Logger;
import ua.in.kupol.quiz.model.QuizQuestion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;


/**
 * Created by pavelkulakovsky on 16.06.14.
 */
public class QuizExecutor {
    static Logger logger = Logger.getLogger(QuizExecutor.class);

    public QuizExecutor(){
        logger.info("Start dialogue with user!");
    }

    public List quizExecut(String quizHead, List<QuizQuestion> quizGetQuestions){
        List<QuizQuestion> quizUserAnswers = quizGetQuestions;
        String answer = "";
        System.out.println(quizHead);

        for(QuizQuestion quiz : quizUserAnswers) {
            System.out.println("\n" + quiz.getQuestion());
            logger.info("\n" + quiz.getQuestion());
            System.out.println(quiz.getChoice());
            logger.info(quiz.getChoice());
            try {
                System.out.print("Введите ответ: ");
                BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
                answer = bufferRead.readLine();
                System.out.print("\nВаш ответ: " + answer + "\n");
                logger.info("\nВаш ответ: " + answer + "\n");
                quiz.setAnswer(answer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        logger.info("Finish dialogue with user");
        return quizUserAnswers;
    }
}
