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
 * Created by kpl on 19.06.2014.
 */
public class QuizGetQuestions {
    public List quizGetQuestions(){
        QuizResultWriter quizResultWriter = new QuizResultWriter();
        quizResultWriter.quizInfoRemover();
        QuizProperties quizProperties = new QuizProperties();

        BufferedReader quizQuestionsFile = null;
        List<QuizQuestion> quizQuestionsObjects = Collections.emptyList();
        try {
            File quizQuestion = new File(quizProperties.getQuestionLocation());
            quizQuestionsFile = new BufferedReader(new FileReader(quizQuestion));
            ObjectMapper mapper = new ObjectMapper();
            quizQuestionsObjects = mapper.readValue(quizQuestionsFile, new TypeReference<List<QuizQuestion>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(quizQuestionsFile!=null){
                try {
                    quizQuestionsFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return quizQuestionsObjects;
    }

}
