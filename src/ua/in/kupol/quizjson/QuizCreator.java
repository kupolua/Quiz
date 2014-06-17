package ua.in.kupol.quizjson;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by pavelkulakovsky on 16.06.14.
 */


public class QuizCreator {

    public List quizGetQuestions(){
        QuizResultWriter quizResultWriter = new QuizResultWriter();
        quizResultWriter.quizInfoRemover();
        QuizProperties quizProperties = new QuizProperties();

        List<QuizQuestion> quizQuestionsObjects = null;
        try {
            File quizQuestion = new File(quizProperties.quizProperties("fileReadLocation"));
            BufferedReader quizQuestionsFile = new BufferedReader(new FileReader(quizQuestion));
            ObjectMapper mapper = new ObjectMapper();
            quizQuestionsObjects = mapper.readValue(quizQuestionsFile, new TypeReference<List<QuizQuestion>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return quizQuestionsObjects;
    }
}
