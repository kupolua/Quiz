package ua.in.kupol.quiz.model;

/**
 * Created by pavelkulakovsky on 17.06.14.
 */
public class QuizHead {
    private String title;
    private String description;
    private QuizTypeLevelLoggin levelLogging;

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

    public QuizTypeLevelLoggin getLevelLogging() {
        return levelLogging;
    }

    public void setLevelLogging(QuizTypeLevelLoggin levelLogging) {
        this.levelLogging = levelLogging;
    }
}
