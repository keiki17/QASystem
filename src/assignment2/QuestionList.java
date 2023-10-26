/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2;

import java.util.ArrayList;
import java.util.List;

/**
 * SOFTWARE CONSTRUCTION :ASSIGNMENT 1
 * @author Daijimara Chan-Ting
 */
class QuestionList {
    private List<Question> questions;

    public QuestionList() {
        this.questions = new ArrayList<>();
    }

    public int addQuestion(Question question) {
        int nextQuestionID = questions.size() + 1;
        question = new Question(nextQuestionID, question.getTitle(), question.getAnswer());
        questions.add(question);
        return nextQuestionID;
    }

    public boolean updateQuestion(int questionID, Question question) {
        if (questionID < 1 || questionID > questions.size()) {
            return false;
        }
        questions.set(questionID - 1, question);
        return true;
    }

    public boolean deleteQuestion(int questionID) {
        if (questionID < 1 || questionID > questions.size()) {
            return false;
        }
        questions.remove(questionID - 1);
        return true;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public Question getById(int questionID) {
        if (questionID >= 1 && questionID <= questions.size()) {
            return questions.get(questionID - 1);
        }
        return null;
    }

    public List<Question> findByTitle(String title) {
        List<Question> foundQuestions = new ArrayList<>();
        for (Question question : this.questions) {
            if (question.getTitle().contains(title) == true) {
                foundQuestions.add(question);
            }
            System.out.println(question.getTitle());
        }
        return foundQuestions;
    }

}