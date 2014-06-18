package ua.in.kupol.quiz.logic;

import ua.in.kupol.quiz.Quiz;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by pavelkulakovsky on 16.06.14.
 */
public class QuizProperties {
    public String quizProperties(String request){
        Properties quizProperties = new Properties();
        InputStream input = null;

        try {

            String filename = "config.properties";
            input = Quiz.class.getClassLoader().getResourceAsStream(filename);
            if(input==null){
                System.out.println("Sorry, unable to find " + filename);
                return null;
            }
            quizProperties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally{
            if(input!=null){
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (request.equals("headLocation")){
            return quizProperties.getProperty("pathToHeadFile") + quizProperties.getProperty("quizHeadFile");
        }
        if (request.equals("questionLocation")){
            return quizProperties.getProperty("pathToQuestionsFile") + quizProperties.getProperty("questionsFile");
        }
        if (request.equals("fileWriteLocation")){
            return quizProperties.getProperty("pathToUserResultFile") + quizProperties.getProperty("userResultFile");
        }
        if (request.equals("regexMask")) {
            return quizProperties.getProperty("regexMask");
        }

        else {
            return "";
        }

    }

}
