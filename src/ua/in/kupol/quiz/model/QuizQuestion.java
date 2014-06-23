package ua.in.kupol.quiz.model;

import ua.in.kupol.quiz.logic.QuizGetTypeQuesrion;

/**
 * Created by pavelkulakovsky on 16.06.14.
 */
public class QuizQuestion {

    private QuizGetTypeQuesrion typeQuestion;

    private String question;
    private String choice;
    private String answer; //20.	не понятно зачем answer и key одновремено
                          // field answer stores user answer. It's proof!
    private String key;    // key stored right answer.
    private boolean isPassed;
    private int rating;
    private String notify;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public boolean isPassed() {
        return isPassed;
    }

    public void setPassed(boolean isPassed) {
        this.isPassed = isPassed;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getNotify() {
        return notify;
    }

    public void setNotify(String notify) {
        this.notify = notify;
    }

    public QuizGetTypeQuesrion getTypeQuestion() {
        return typeQuestion;
    }

    public void setTypeQuestion(QuizGetTypeQuesrion typeQuestion) {
        this.typeQuestion = typeQuestion;
    }
}
