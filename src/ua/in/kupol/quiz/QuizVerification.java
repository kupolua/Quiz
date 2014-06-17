package ua.in.kupol.quiz;

import java.util.List;

/**
 * Created by pavelkulakovsky on 16.06.14.
 */
public class QuizVerification {

    public void quizVerification(List quizAnswers){
        QuizProperties quizProperties = new QuizProperties();
        QuizResultWriter quizResultWriter = new QuizResultWriter();

        List<QuizQuestion> quizQuestionVerification = quizAnswers;
        String answerRegex = "";
        int cntAnswer;
        int cntKey;
        int compareArray = 0;
        int quizCountQuestions = 0;
        int quizCountRightAnswers = 0;
        int quizUserRating = 0;
        int quizTotalRating = 0;
        boolean quizReportInfo = true;

        System.out.print(quizResultWriter.quizInfoWrite("\n\n\n         Результаты Вашего теста        \n"));
        for(QuizQuestion quiz: quizQuestionVerification) {
            if (quiz.title != null){
                    System.out.print(quizResultWriter.quizInfoWrite(quiz.quizHead()));
            } else {
                quizCountQuestions++;
                quizTotalRating += quiz.rating;
                answerRegex = quiz.answer.replaceAll(quizProperties.quizProperties("regexMask"), "");
                if (quiz.key.compareToIgnoreCase(answerRegex) == 0){
                    quizCountRightAnswers++;
                    quizUserRating += quiz.rating;
                } else {
                    cntAnswer = answerRegex.length();
                    cntKey = quiz.key.length();
                    if (cntAnswer == cntKey) {
                        for (int i = 0; i < cntAnswer; i++) {
                            for (int j = 0; j < cntKey; j++) {
                                if (answerRegex.substring(i, i + 1).compareToIgnoreCase(quiz.key.substring(j, j + 1)) == 0){
                                    compareArray++;
                                    break;
                                }
                            }
                        }
                    }
                    if (compareArray == cntKey){
                        quizCountRightAnswers++;
                        quizUserRating += quiz.rating;
                    } else {
                        if (quiz.key.equals("*") && quiz.answer.length() > 0){
                            quizCountRightAnswers++;
                            quizUserRating += quiz.rating;
                        } else {
                            if (quizReportInfo) {
                                System.out.print(quizResultWriter.quizInfoWrite("\nВы неправильно ответили на следующие вопросы:\n"));
                                quizReportInfo = false;
                            }
                            System.out.print(quizResultWriter.quizInfoWrite(quiz.quizQuestions()));
                            System.out.print(quizResultWriter.quizInfoWrite(quiz.quizAnswers() + "  - Ответ неверный"));
                            System.out.print(quizResultWriter.quizInfoWrite("\nПравильный ответ: " + quiz.key));
                            System.out.print(quizResultWriter.quizInfoWrite("\nВы потеряли бвллы: " + quiz.rating));
                            System.out.print(quizResultWriter.quizInfoWrite("\nПримечание: " + quiz.notifi + "\n"));
                        }
                    }
                }
            }
        }
        System.out.print(quizResultWriter.quizInfoWrite("\nВы набрали: " + quizUserRating + " из " + quizTotalRating + " баллов."));
        System.out.print(quizResultWriter.quizInfoWrite("\nВы правильно ответили на " + quizCountRightAnswers + " из " + quizCountQuestions + " вопросов."));
        if (quizUserRating >= quizTotalRating - 20  && quizUserRating >= quizTotalRating - 5 ){
            System.out.println(quizResultWriter.quizInfoWrite("\n\n Поздравляем! Тест сдан!"));
        } else {
            System.out.println(quizResultWriter.quizInfoWrite("\nТест не сдан!"));
        }
    }
}
