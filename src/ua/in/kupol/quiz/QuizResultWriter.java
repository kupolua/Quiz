package ua.in.kupol.quiz;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by pavelkulakovsky on 16.06.14.
 */
public class QuizResultWriter {
    QuizProperties quizProperties = new QuizProperties();

    public String quizInfoWrite (String infoToWrite) {
        try {

            File file = new File(quizProperties.quizProperties("fileWriteLocation"));

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.append(infoToWrite);
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return infoToWrite;
    }
    public void quizInfoRemover(){
        File file = new File(quizProperties.quizProperties("fileWriteLocation"));
        file.delete();
    }

}
