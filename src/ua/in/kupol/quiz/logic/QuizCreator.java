package ua.in.kupol.quiz.logic;

import ua.in.kupol.quiz.model.QuizQuestion;

import java.util.List;

/**
 * Created by pavelkulakovsky on 16.06.14.
 */


public class QuizCreator {
    public void quizCreate(){

        QuizGetHead quizGetHead = new QuizGetHead();

        QuizGetQuestions quizGetQuestions = new QuizGetQuestions();
        List<QuizQuestion> quizQuestions = quizGetQuestions.quizGetQuestions();

        QuizExecutor quizExecutor = new QuizExecutor();
        List<QuizQuestion> quizUserAnswers = quizExecutor.quizExecut(quizGetHead.quizGetPrintHead(), quizQuestions);

        QuizVerifier quizVerifier = new QuizVerifier();
        List<QuizQuestion> quizVerifiedAnswers = quizVerifier.quizVerify(quizUserAnswers);

        QuizReporter quizReporter = new QuizReporter();
        quizReporter.quizPrintReport(quizVerifiedAnswers);

    }

}
