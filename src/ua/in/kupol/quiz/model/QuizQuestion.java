package ua.in.kupol.quiz.model;

/**
 * Created by pavelkulakovsky on 16.06.14.
 */
public class QuizQuestion {

    public String question;
    public QuizTypeQuesrion typeQuestion;
    public String choice;
    public String answer; //20.	не понятно зачем answer и key одновремено
                          // field answer stores user answer. It's proof!
    public String key;    // key stored right answer.
    public boolean isPassed;
    public int rating;
    public String notify;

}
