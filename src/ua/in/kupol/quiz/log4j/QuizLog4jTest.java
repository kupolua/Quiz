package ua.in.kupol.quiz.log4j;

import org.apache.log4j.Logger;

/**
 * Created by kpl on 23.06.2014.
 */
public class QuizLog4jTest {
    static Logger logger = Logger.getLogger(QuizLog4jTest.class);
    public static void main(String[] args) {

        // Set up a simple configuration that logs on the console.
//        BasicConfigurator.configure();

        logger.info("Entering application.");
        System.out.println("TESTING....");
        logger.info("Exiting application.");
    }
}
