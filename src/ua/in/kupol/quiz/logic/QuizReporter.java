package ua.in.kupol.quiz.logic;

import ua.in.kupol.quiz.model.QuizQuestion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pavelkulakovsky on 17.06.14.
 */
public class QuizReporter {

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

        System.out.print("\n\n\n         Результаты Вашего теста        \n");
        System.out.println(quizGetHead.quizGetPrintHead());
        System.out.print("\nВы набрали: " + quizRating + " из " + quizMaxRating + " баллов.");
        System.out.print("\nВы правильно ответили на " + quizPassedQuestions + " из " + quizMaxCountQuestions + " вопросов.\n\n");

        if (quizRating == quizMaxRating) {
            System.out.println("\nВы успешно прошли тест! Поздравляем!");
        } else {
            System.out.println("\nНеобходимо пройти тест заново.\n");
            for(QuizQuestion quiz: quizPrintable) {

                System.out.println(quizGetHead.quizGetHead().getLevelLogging().quizGetTypeLevelLoggin(quiz));
            }
        }
    }
}
