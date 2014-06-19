package ua.in.kupol.quiz.logic;

import ua.in.kupol.quiz.Quiz;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by pavelkulakovsky on 16.06.14.
 */
public class QuizProperties {
    Properties quizProperties = new Properties();
    
    public QuizProperties(){

        InputStream input = null;

        try {

            String filename = "config.properties";
            input = Quiz.class.getClassLoader().getResourceAsStream(filename);
            if(input==null){
                System.out.println("Sorry, unable to find " + filename);
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
    }
    public String getHeadLocation() {
        return quizProperties.getProperty("pathToHeadFile")
                + quizProperties.getProperty("quizHeadFile");
    }
    public String getQuestionLocation() {
        return quizProperties.getProperty("pathToQuestionsFile") + quizProperties.getProperty("questionsFile");
    }
    public String getFileWriteLocation() {
        return quizProperties.getProperty("pathToUserResultFile") + quizProperties.getProperty("userResultFile");
    }
    public String getRegexMask() {
        return quizProperties.getProperty("regexMask");
    }



}
