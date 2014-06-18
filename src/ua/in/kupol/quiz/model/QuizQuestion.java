package ua.in.kupol.quiz.model;

import ua.in.kupol.quiz.logic.QuizTypeQuesrion;

/**
 * Created by pavelkulakovsky on 16.06.14.
 */
public class QuizQuestion {

    public String question;
    public QuizTypeQuesrion typeQuestion;
    public String choice;
    public String answer;
    public String key;
    public boolean isPassed;
    public int rating;
    public String notify;

}
