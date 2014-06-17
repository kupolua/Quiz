package ua.in.kupol.quiz;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pavelkulakovsky on 16.06.14.
 */
public class QuizQuestion {

    public String title;
    public String description;
    public String level;
    public List<String> levelVariants = new ArrayList<String>();
    public int id;
    public String question;
    public String choice;
    public String answer;
    public String key;
    public int rating;
    public String notifi;

    public String quizHead(){
        return  "========================================\nНазвание теста: " + title
                + "\nОписание: " + description
                + "\nУровень сложности: " + level
                + "\n========================================\n";
    }
    public String quizQuestions(){
        return "\n№ : " + id
                + "\nВопрос: " + question
                + "\nВыберете ответ: " + choice;
    }
    public String quizAnswers(){
        return "\nВаш ответ: " + answer;
    }
}
