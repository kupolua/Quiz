package ua.in.kupol.quiz.model;

/**
 * Created by pavelkulakovsky on 17.06.14.
 */
public enum QuizTypeQuesrion {
    YESORNO{
        @Override
        public Boolean compareAnswerAndKey(String quizUserAnswer, String quizKey){
            return quizKey.equalsIgnoreCase(quizUserAnswer);
        }
    }, ONERIGHTANSWER {
        @Override
        public Boolean compareAnswerAndKey(String quizUserAnswer, String quizKey){
            return quizKey.equalsIgnoreCase(quizUserAnswer);
        }
    }, MULTICHOICE {
        @Override
        public Boolean compareAnswerAndKey(String quizUserAnswer, String quizKey){
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
                return compareArray == cntKey;
        }
    }, STRONGORDER {
        @Override
        public Boolean compareAnswerAndKey(String quizUserAnswer, String quizKey){
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
            return compareArray == cntKey;
        }
    }, WRITETEXT {
        @Override
        public Boolean compareAnswerAndKey(String quizUserAnswer, String quizKey){
            return quizUserAnswer.length() > 0;
        }
    };

    public abstract Boolean compareAnswerAndKey(String quizUserAnswer, String quizKey);
}
