import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args)
    {
        run();
    }

    public static void run()
    {
        StackOverflow stackOverflowSystem = new StackOverflow();

        // Create User : "Alice"
        User alice = stackOverflowSystem.createUser("Alice", "alice@example.com");
        // Create User: "Bob"
        User bob = stackOverflowSystem.createUser("Bob", "bob@example.com");
        // Create User: "Charlie"
        User charlie = stackOverflowSystem.createUser("Charlie", "charlie@example.com");

        // ALice ask the question
        Question aliceJavaQuestion = stackOverflowSystem.askQuestion(alice, "What is polymorphism in Java?", "Can someone explain Polymorphism in Java with an example?", Arrays.asList("java", "oop"));

        // bob answers the aliceJavaQuestion
        Answer bobAnswer = stackOverflowSystem.answerQuestion(bob, aliceJavaQuestion, "Polymorphism in Java is the ability of an object to take on many forms...");

        // Charlie comments on aliceJavaQuestion answer
        stackOverflowSystem.addComment(charlie, bobAnswer, "Great question! I'm also interested in learning about this.");

        //Alice comments on the bob's answer
        stackOverflowSystem.addComment(alice, bobAnswer, "Thanks for the explanation! Could you provide a code example?");

        // Charlie votes on question and answer
        stackOverflowSystem.voteQuestion(charlie, aliceJavaQuestion, 1);
        stackOverflowSystem.voteAnswer(charlie, bobAnswer, 1);

        // alice accepts bob's answer
        stackOverflowSystem.acceptAnswer(bobAnswer);

        // bob asks another question
        Question bobQuestion = stackOverflowSystem.askQuestion(bob, "How to use list comprehensions in Python?", "I'm new to Python and I've heard about list comprehensions. Can someone explain how to use them?", Arrays.asList("python", "list-comprehension"));

        // alice answers bob question
        Answer aliceAnswerToBob = stackOverflowSystem.answerQuestion(alice, bobQuestion, "List comprehensions in Python provide a concise way to create lists...");

    }
}





























/*
    1. HOW TO KNOW THIS COMMENT IS FOR WHICH QUESTION OR AN ANSWER
    2. Better method for generating ids
        private int generateId()
        {
            return (int) (System.currentTimeMillis()  % Integer.MAX_VALUE);
        }
        Can think for UUID instead of this because when the program start it will hit this point in the same time which will result int same id to several objects:Comment, Answer, Question, User
*/