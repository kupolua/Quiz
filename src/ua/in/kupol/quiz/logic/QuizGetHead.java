package ua.in.kupol.quiz.logic;

import com.google.gson.Gson;
import org.apache.log4j.Logger;
import ua.in.kupol.quiz.model.QuizHead;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by pavelkulakovsky on 17.06.14.
 *
 */
public class QuizGetHead {

    static Logger logger = Logger.getLogger(QuizGetHead.class);
    public QuizHead quizGetHead(){

        Gson gson = new Gson();
        QuizProperties quizProperties = new QuizProperties();

        BufferedReader quizHeadFile = null;

        QuizHead quizHeadObjects = null;
        try {
            File quizHead = new File(quizProperties.getHeadLocation());
            quizHeadFile = new BufferedReader(new FileReader(quizHead));
            quizHeadObjects = gson.fromJson(quizHeadFile, QuizHead.class);
        } catch (IOException e) {
            logger.error("Can't open file", e);
//            e.printStackTrace();
        } finally{
            if(quizHeadFile!=null){
                try {
                    quizHeadFile.close();
                } catch (IOException eQuizHeadFile) {
                    logger.error(eQuizHeadFile);
//                    eQuizHeadFile.printStackTrace();
                }
            }
        }
        return quizHeadObjects;
    }
    public String quizGetPrintHead(){
        String quizGetPrintHead = "";
        try {
            quizGetPrintHead = "\n======================================"
                    + "\nНазвание теста: " + quizGetHead().getTitle()
                    + "\nОписание: " + quizGetHead().getDescription()
                    + "\nУровень сложности: " + quizGetHead().getLevelLogging()
                    + "\n======================================\n";
        } catch (NullPointerException quizCANTReadHeadFile) {
            quizGetPrintHead = "Can't open Head File!";
            logger.error(quizGetPrintHead, quizCANTReadHeadFile);
        }
        return quizGetPrintHead;
    }
}
