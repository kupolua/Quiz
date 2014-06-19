package ua.in.kupol.quiz.logic;

import ua.in.kupol.quiz.model.QuizQuestion;

import java.util.List;

/**
 * Created by pavelkulakovsky on 16.06.14.
 */
public class QuizVerifier {

    public List quizVerify(List<QuizQuestion> quizUserAnswers){
        String answerRegex = "";
        QuizProperties quizProperties = new QuizProperties();
        List<QuizQuestion> quizVerifiableAnswers = quizUserAnswers;

        for(QuizQuestion quiz: quizVerifiableAnswers) {
            answerRegex = quiz.answer.replaceAll(quizProperties.getRegexMask(), "");
            switch (quiz.typeQuestion) {
                case YESORNO:
                    quiz.isPassed = oneChoice(answerRegex, quiz.key);
                    break;
                case ONERIGHTANSWER:
                    quiz.isPassed = oneChoice(answerRegex, quiz.key);
                    break;
                case MULTICHOICE:
                    quiz.isPassed = multiChoice(answerRegex, quiz.key);
                    break;
                case STRONGORDER:
                    quiz.isPassed = strongOrder(answerRegex, quiz.key);
                    break;
                case WRITETEXT:
                    quiz.isPassed =  writeText(answerRegex, quiz.key);
                    break;
                default:
                    System.out.println("No answer!");
                    break;
            }
        }
        return quizVerifiableAnswers;
    }

    public Boolean oneChoice(String quizUserAnswer, String quizKey){
        if (quizKey.compareToIgnoreCase(quizUserAnswer) == 0){
            return true;
        } else {
            return false;
        }
    }
    public Boolean multiChoice(String quizUserAnswer, String quizKey) {
        int cntAnswer;
        int cntKey;
        int compareArray = 0;
        cntAnswer = quizUserAnswer.length();
        cntKey = quizKey.length();
        if (cntAnswer == cntKey) {
            for (int i = 0; i < cntAnswer; i++) {
                for (int j = 0; j < cntKey; j++) {
                    if (quizUserAnswer.substring(i, i + 1).compareToIgnoreCase(quizKey.substring(j, j + 1)) == 0) {
                        compareArray++;
                        break;
                    }
                }
            }
        }
        if (compareArray == cntKey){
            return true;
        } else {
            return false;
        }
    }
    public Boolean strongOrder(String quizUserAnswer, String quizKey){
        int cntAnswer;
        int cntKey;
        int compareArray = 0;

        cntAnswer = quizUserAnswer.length();
        cntKey = quizKey.length();
        if (cntAnswer == cntKey) {
            for (int i = 0; i < cntAnswer; i++) {
                if (quizUserAnswer.substring(i, i + 1).compareToIgnoreCase(quizKey.substring(i, i + 1)) == 0) {
                    compareArray++;
                }
            }
        }
        if (compareArray == cntKey){
            return true;
        } else {
            return false;
        }
    }
    public Boolean writeText(String quizUserAnswer, String quizKey){
        if (quizUserAnswer.length() > 0){
            return true;
        } else {
            return false;
        }
    }
}
