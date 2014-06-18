package ua.in.kupol.quiz.logic;

import org.codehaus.jackson.map.ObjectMapper;
import ua.in.kupol.quiz.model.QuizHead;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by pavelkulakovsky on 17.06.14.
 */
public class QuizGetHead {
    public QuizHead quizGetHead(){
        QuizResultWriter quizResultWriter = new QuizResultWriter();
        quizResultWriter.quizInfoRemover();
        QuizProperties quizProperties = new QuizProperties();

        QuizHead quizHeadObjects = null;
        try {
            File quizQuestion = new File(quizProperties.quizProperties("headLocation"));
            BufferedReader quizQuestionsFile = new BufferedReader(new FileReader(quizQuestion));
            ObjectMapper mapper = new ObjectMapper();
            quizHeadObjects = mapper.readValue(quizQuestionsFile, QuizHead.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return quizHeadObjects;
    }
    public String quizGetPrintHead(){

        return "\n======================================"
                + "\nНазвание теста: " + quizGetHead().title
                + "\nОписание: " + quizGetHead().description
                + "\nУровень сложности: " + quizGetHead().level
                + "\n======================================\n";

    }

}
