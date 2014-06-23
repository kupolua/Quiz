package ua.in.kupol.quiz.logger;

/**
 * Created by pavelkulakovsky on 21.06.14.
 */
import ua.in.kupol.quiz.logic.QuizProperties;

import java.io.IOException;
import java.util.logging.*;

public class QuizLogger {
    static private FileHandler fileTxt;
    static private SimpleFormatter formatterTxt;

    static private FileHandler fileHTML;
    static private Formatter formatterHTML;

    static public void setup() throws IOException {

        QuizProperties quizProperties = new QuizProperties();
        // get the global logger to configure it
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

        // suppress the logging output to the console
        Logger rootLogger = Logger.getLogger("");
        Handler[] handlers = rootLogger.getHandlers();
        if (handlers[0] instanceof ConsoleHandler) {
            rootLogger.removeHandler(handlers[0]);
        }

        logger.setLevel(Level.INFO);
        fileTxt = new FileHandler(quizProperties.getLogsTXTFileLocation());
        fileHTML = new FileHandler(quizProperties.getLogsHTMLFileLocation());

        // create a TXT formatter
        formatterTxt = new SimpleFormatter();
        fileTxt.setFormatter(formatterTxt);
        logger.addHandler(fileTxt);

        // create an HTML formatter
        formatterHTML = new QuizLogHtmlFormatter();
        fileHTML.setFormatter(formatterHTML);
        logger.addHandler(fileHTML);
    }
}

