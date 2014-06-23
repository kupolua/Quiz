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
    public static final String PROPERTIES_FILE  = "config.properties";
    
    public QuizProperties(){

        InputStream input = null;

        try {

            input = Quiz.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE);
            if(input==null){
                System.out.println("Sorry, unable to find " + PROPERTIES_FILE);
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
    public String getLogsHTMLFileLocation() {
        return quizProperties.getProperty("pathToLogsFile") + quizProperties.getProperty("logsHTNLFileName");
    }
    public String getLogsTXTFileLocation() {
        return quizProperties.getProperty("pathToLogsFile") + quizProperties.getProperty("logsTXTFileName");
    }
    public String getRegexMask() {
        return quizProperties.getProperty("regexMask");
    }
}
