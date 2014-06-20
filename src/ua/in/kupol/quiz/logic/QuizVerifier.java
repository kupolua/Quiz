package ua.in.kupol.quiz.logic;

import ua.in.kupol.quiz.model.QuizQuestion;

import java.util.List;

/**
 * Created by pavelkulakovsky on 16.06.14.
 *
 */
public class QuizVerifier {

    public List quizVerify(List<QuizQuestion> quizUserAnswers){

        String answerRegex = "";
        QuizProperties quizProperties = new QuizProperties();
        List<QuizQuestion> quizVerifiableAnswers = quizUserAnswers;

        for(QuizQuestion quiz: quizUserAnswers) {
            answerRegex = quiz.getAnswer().replaceAll(quizProperties.getRegexMask(), "");
            quiz.setPassed(quiz.getTypeQuestion().compareAnswerAndKey(answerRegex, quiz.getKey()));
        }
        return quizVerifiableAnswers;
    }
}
