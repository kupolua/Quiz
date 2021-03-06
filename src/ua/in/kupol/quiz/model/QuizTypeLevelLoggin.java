package ua.in.kupol.quiz.model;

/**
 * Created by pavelkulakovsky on 17.06.14.
 */
public enum QuizTypeLevelLoggin {
    HARD{
        @Override
        public String quizGetTypeLevelLoggin(QuizQuestion quizQuestion){
            return "\nНеобходимо пройти тест заново.\n";
        }
    }, MIDDLE{
        public String quizGetTypeLevelLoggin(QuizQuestion quizQuestion){
            return  "\nНеобходимо пройти тест заново.\n"
                    + "\nВы не верно ответили на вопрос: " + quizQuestion.getQuestion()
                    + "\nВарианты ответа: " + quizQuestion.getChoice()
                    + "\nВаш ответ: " + quizQuestion.getAnswer();
        }
    }, LIGHT{
        public String quizGetTypeLevelLoggin(QuizQuestion quizQuestion){
            return  "\nНеобходимо пройти тест заново.\n"
                    + "\nВы не верно ответили на вопрос: " + quizQuestion.getQuestion()
                    + "\nВарианты ответа: " + quizQuestion.getChoice()
                    + "\nВаш ответ: " + quizQuestion.getAnswer()
                    + "\nВы потеряли : " + quizQuestion.getRating() + " баллов.";
        }
    }, DETEILED{
        public String quizGetTypeLevelLoggin(QuizQuestion quizQuestion){
            return  "\nНеобходимо пройти тест заново.\n"
                    + "\nВы не верно ответили на вопрос: " + quizQuestion.getQuestion()
                    + "\nВарианты ответа: " + quizQuestion.getChoice()
                    + "\nВаш ответ: " + quizQuestion.getAnswer()
                    + "\nВы потеряли : " + quizQuestion.getRating() + " баллов."
                    + "\nПравильный ответ: " + quizQuestion.getKey()
                    + "\nПримечание : " + quizQuestion.getNotify();
        }
    };

    public abstract String quizGetTypeLevelLoggin(QuizQuestion quizQuestion);
}
