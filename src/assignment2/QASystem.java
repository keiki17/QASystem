/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2;

/**
 * SOFTWARE CONSTRUCTION :ASSIGNMENT 1
 *
 * @author Daijimara Chan-Ting
 */
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Daijimara Chan-Ting
 */
public class QASystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuestionList questionList = new QuestionList();
        int userID = -1; //means not logged in
        int choice;

        while (true) {
            System.out.println("MAIN MENU");
            System.out.println("------------------------------");
            System.out.println("  1. Login as staff");
            System.out.println("  2. Login as student");
            System.out.println("  0. Quit");
            System.out.println("------------------------------");
            System.out.println("choice: ");

            //int choice = scanner.nextInt();
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                // Handle invalid input (e.g., non-integer input)
                System.out.println("Invalid input. Please enter a valid option.");
                scanner.nextLine(); // Consume the invalid input
                continue;
            }

            if (choice == 0) {
                System.out.println("Goodbye!");
                break;
            }

            if (choice == 1) {
                userID = 1;
            } else if (choice == 2) {
                userID = 2;
            }

            if (userID == 1) {
                staffMenu(scanner, questionList);
            } else if (userID == 2) {
                studentMenu(scanner, questionList);
            }

            userID = -1; //logs out after each action
        }
    }

    public static void staffMenu(Scanner scanner, QuestionList questionList) {
        while (true) {
            System.out.println("\nSTAFF MENU");
            System.out.println("1. List questions");
            System.out.println("2. Add question");
            System.out.println("3. Edit question");
            System.out.println("4. Delete question");
            System.out.println("0. Logout");

            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Logged out.");
                break;
            }

            switch (choice) {
                case 1:
                    listQuestions(questionList.getQuestions());
                    break;
                case 2:
                    addQuestion(scanner, questionList);
                    break;
                case 3:
                    editQuestion(scanner, questionList);
                    break;
                case 4:
                    deleteQuestion(scanner, questionList);
                    break;
                default:
                    break;
            }
        }
    }

    public static void studentMenu(Scanner scanner, QuestionList questionList) {
        while (true) {
            System.out.println("\nSTUDENT MENU");
            System.out.println("1. List questions");
            System.out.println("2. Find questions");
            System.out.println("0. Logout");

            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Logged out.");
                break;
            }

            if (choice == 1) {
                listQuestions(questionList.getQuestions());
            } else if (choice == 2) {
                findQuestion(scanner, questionList);
            }
        }
    }

    public static void listQuestions(List<Question> questions) {
        System.out.println("\nQuestions:");
        for (Question question : questions) {
            System.out.println("ID: " + question.getQuestionID());
            System.out.println(question.toString());
            System.out.println();
        }
    }

    public static void addQuestion(Scanner scanner, QuestionList questionList) {
        System.out.println("Enter question:");
        scanner.nextLine();
        String title = scanner.nextLine();
        System.out.println("Enter Answer:");
        String answer = scanner.nextLine();

        Question question = new Question(questionList.getQuestions().size() + 1, title, answer);

        questionList.addQuestion(question);
        System.out.println("Question added successfully!");

    }

    public static void editQuestion(Scanner scanner, QuestionList questionList) {
        System.out.println("Enter question ID to edit:");
        int questionID = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Question question = questionList.getById(questionID);
        if (question == null) {
            System.out.println("Question not found.");
            return;
        }

        System.out.println("Enter updated question:");
        String newTitle = scanner.nextLine();
        question.setTitle(newTitle);

        System.out.println("Enter updated Answer:");
        String newAnswer = scanner.nextLine();
        question.setAnswer(newAnswer);

        System.out.println("Question updated successfully!");
    }

    public static void deleteQuestion(Scanner scanner, QuestionList questionList) {
        System.out.println("Enter question ID to delete:");
        int questionID = scanner.nextInt();

        Question question = questionList.getById(questionID);
        if (question == null) {
            System.out.println("Question not found.");
            return;
        }

        questionList.getQuestions().remove(question);
        System.out.println("Question deleted successfully!");
    }

    public static void findQuestion(Scanner scanner, QuestionList questionList) {
        System.out.println("Enter keywords to search for:");
        scanner.nextLine();
        String keywords = scanner.nextLine();

        System.out.println(keywords);
        List<Question> foundQuestions = questionList.findByTitle(keywords);
        if (foundQuestions.size() == 0) {
            System.out.println("No matching questions found.");
            return;
        }

        System.out.println("\nMatching Questions:");
        listQuestions(foundQuestions);
    }
}
