package ua.in.kupol.quiz.logic;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import ua.in.kupol.quiz.model.QuizQuestion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * Created by pavelkulakovsky on 16.06.14.
 */


public class QuizCreator {
    public void quizCreate(){

        QuizGetHead quizGetHead = new QuizGetHead();

        List<QuizQuestion> quizQuestions = quizGetQuestions();
        QuizExecutor quizExecutor = new QuizExecutor();

        List<QuizQuestion> quizUserAnswers = quizExecutor.quizExecut(quizGetHead.quizGetPrintHead(), quizQuestions);

        QuizVerifier quizVerifier = new QuizVerifier();
        List<QuizQuestion> quizVerifiedAnswers = quizVerifier.quizVerify(quizUserAnswers);

        QuizReporter quizReporter = new QuizReporter();
        quizReporter.quizPrintReport(quizVerifiedAnswers);

    }

    public List quizGetQuestions(){
        QuizResultWriter quizResultWriter = new QuizResultWriter();
        quizResultWriter.quizInfoRemover();
        QuizProperties quizProperties = new QuizProperties();

        List<QuizQuestion> quizQuestionsObjects = Collections.emptyList();
        try {
            File quizQuestion = new File(quizProperties.quizProperties("questionLocation"));
            BufferedReader quizQuestionsFile = new BufferedReader(new FileReader(quizQuestion));
            ObjectMapper mapper = new ObjectMapper();
            quizQuestionsObjects = mapper.readValue(quizQuestionsFile, new TypeReference<List<QuizQuestion>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return quizQuestionsObjects;
    }
}
