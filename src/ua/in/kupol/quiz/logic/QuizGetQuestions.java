package ua.in.kupol.quiz.logic;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
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

        Gson gson = new Gson();

        QuizProperties quizProperties = new QuizProperties();


        BufferedReader quizQuestionsFile = null;
        List<QuizQuestion> quizQuestionsObjects = Collections.emptyList();
        try {
            File quizQuestion = new File(quizProperties.getQuestionLocation());
            quizQuestionsFile = new BufferedReader(new FileReader(quizQuestion));
            quizQuestionsObjects = gson.fromJson(quizQuestionsFile, new TypeToken<List<QuizQuestion>>(){}.getType());

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
