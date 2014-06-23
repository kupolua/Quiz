package ua.in.kupol.quiz.logic;

import org.apache.log4j.Logger;
import ua.in.kupol.quiz.model.QuizQuestion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pavelkulakovsky on 17.06.14.
 */
public class QuizReporter {
    Logger logger = Logger.getLogger(QuizGetTypeLevelLoggin.class);

    public void quizPrintReport(List<QuizQuestion> quizVerifiedAnswers){
        List<QuizQuestion> quizPrintable = quizVerifiedAnswers;
        ArrayList toRemove = new ArrayList();
        int quizMaxCountQuestions = 0;
        int quizPassedQuestions = 0;
        int quizMaxRating = 0;
        int quizRating = 0;

        for(QuizQuestion quiz: quizPrintable) {
            quizMaxCountQuestions++;
            quizMaxRating += quiz.getRating();
            if (quiz.isPassed()){
                quizPassedQuestions++;
                quizRating += quiz.getRating();
                toRemove.add(quiz);
            }
        }
        quizPrintable.removeAll(toRemove);

        QuizGetHead quizGetHead = new QuizGetHead();

        logger.info("\n\n\n         Результаты Вашего теста        \n");
        logger.info(quizGetHead.quizGetPrintHead());
        logger.info("\nВы набрали: " + quizRating + " из " + quizMaxRating + " баллов.");
        logger.info("\nВы правильно ответили на " + quizPassedQuestions + " из " + quizMaxCountQuestions + " вопросов.\n\n");

        if (quizRating == quizMaxRating) {
            logger.info("\nВы успешно прошли тест! Поздравляем!");
        } else {
            logger.info("\nНеобходимо пройти тест заново.\n");
            for(QuizQuestion quiz: quizPrintable) {
                logger.info(quizGetHead.quizGetHead().getLevelLogging().quizGetTypeLevelLoggin(quiz));
            }
        }
    }
}
