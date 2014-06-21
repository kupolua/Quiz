package ua.in.kupol.quiz;

<<<<<<< Temporary merge branch 1
import java.util.List;
=======
import ua.in.kupol.quiz.logic.QuizCreator;
>>>>>>> Temporary merge branch 2

/**
 * Created by pavelkulakovsky on 16.06.14.
 *
 * Fixed 8 ToDo
 */
public class Quiz {
    public static void main(String[] args) {
<<<<<<< Temporary merge branch 1

        //todo Quiz.main() не должен содержать никакой логики. просто execute или runTest, etc
        QuizCreator quizCreator = new QuizCreator();
        List<QuizQuestion> quizQuestions = quizCreator.quizGetQuestions();

        QuizPassing quizPassing = new QuizPassing();
        List<QuizQuestion> quizAnswers = quizPassing.quizPassing(quizQuestions);

        QuizVerification quizVerification = new QuizVerification();
        quizVerification.quizVerification(quizAnswers);
=======
        QuizCreator quizCreator = new QuizCreator();
        quizCreator.quizCreate();
>>>>>>> Temporary merge branch 2
    }
}
