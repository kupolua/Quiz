package ua.in.kupol.quiz.model;

import ua.in.kupol.quiz.logic.QuizGetTypeLevelLoggin;

/**
 * Created by pavelkulakovsky on 17.06.14.
 */
public class QuizHead {
    private String title;
    private String description;
    private QuizGetTypeLevelLoggin levelLogging;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public QuizGetTypeLevelLoggin getLevelLogging() {
        return levelLogging;
    }

    public void setLevelLogging(QuizGetTypeLevelLoggin levelLogging) {
        this.levelLogging = levelLogging;
    }
}
