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
            quizMaxRating += quiz.rating;
            if (quiz.isPassed){
                quizPassedQuestions++;
                quizRating += quiz.rating;
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

                switch (quizGetHead.quizGetHead().level) {
                    case HARD:
                        System.out.println(quizPrintHardLevel());
                        ;
                        break;
                    case MIDDLE:
                        System.out.println(quizPrintMiddleLevel(quiz));
                        ;
                        break;
                    case LIGHT:
                        System.out.println(quizPrintLightLevel(quiz));
                        ;
                        break;
                    case DETEILED:
                        System.out.println(quizPrintDeteiledLevel(quiz));
                        ;
                        break;
                    default:
                        System.out.println("No answer!");
                        break;
                }
            }
        }
    }


    public String quizPrintHardLevel(){

        return "";
    }
    private String quizPrintMiddleLevel(QuizQuestion quiz) {
        String quizPrintMiddleLevel = "";
            quizPrintMiddleLevel += quizPrintHardLevel()
                    + "\nВы не верно ответили на вопрос: " + quiz.guestion
                    + "\nВарианты ответа: " + quiz.choice
                    + "\nВаш ответ: " + quiz.answer;
        return  quizPrintMiddleLevel;
    }
    private String quizPrintLightLevel(QuizQuestion quiz) {
        String quizPrintLightLevel = "";
            quizPrintLightLevel += quizPrintMiddleLevel(quiz) + "\nВы потеряли : " + quiz.rating + " баллов.";
        return  quizPrintLightLevel;
    }
    private String quizPrintDeteiledLevel(QuizQuestion quiz) {
        String quizPrintDeteiledLevel = "";
            quizPrintDeteiledLevel += quizPrintLightLevel(quiz)
                    + "\nПравильный ответ: " + quiz.key
                    + "\nПримечание : " + quiz.notify;
        return  quizPrintDeteiledLevel;
    }


}
