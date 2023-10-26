/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2;

/**
 * SOFTWARE CONSTRUCTION :ASSIGNMENT 1
 * @author Daijimara Chan-Ting
 */
class Question {
    private int questionID;
    private String title;
    private String answer;

    public Question(int questionID, String title, String answer) {
        this.questionID = questionID;
        this.title = title;
        this.answer = answer;
    }

    public int getQuestionID() {
        return questionID;
    }

    public String getTitle() {
        return title;
    }


    public String getAnswer() {
        return answer;
    }
    
    public void setAnswer(String answer){
        this.answer = answer;
    }
    
     public void setTitle(String title){
        this.title = title;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Question ID: ").append(questionID).append("\n");
        sb.append("Title: ").append(title).append("\n");
        sb.append("Answer: ").append(answer).append("\n");
        return sb.toString();
    }
}