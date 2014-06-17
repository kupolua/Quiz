package ua.in.kupol.quiz;

import java.util.List;

/**
 * Created by pavelkulakovsky on 16.06.14.
 */
public class Quiz {
    public static void main(String[] args) {

        //todo  - Quiz.main() не должен содержать никакой логики. просто execute или runTest, etc
        QuizCreator quizCreator = new QuizCreator();
        List<QuizQuestion> quizQuestions = quizCreator.quizGetQuestions();

        QuizPassing quizPassing = new QuizPassing();
        List<QuizQuestion> quizAnswers = quizPassing.quizPassing(quizQuestions);

        QuizVerification quizVerification = new QuizVerification();
        quizVerification.quizVerification(quizAnswers);
    }
}
