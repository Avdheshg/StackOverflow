
import java.util.*;

public class User
{
    private final int id;
    private final String username;
    private final String email;
    private int reputation;

    private final List<Question> questions;
    private final List<Answer> answers;
    private final List<Comment> comments;

    private static final int QUESTION_REPUTATION = 5;
    private static final int ANSWER_REPUTATION = 10;
    private static final int COMMENT_REPUTATION = 2;

    public User(int id, String username, String email)
    {
        this.id = id;
        this.username = username;
        this.email = email;
        this.reputation = 0;

        questions = new ArrayList<Question>();
        answers = new ArrayList<Answer>();
        comments = new ArrayList<Comment>();
    }

    public Question askQuestion(String title, String content, List<String> tags)
    {
        Question question = new Question(this, title, content, tags);
        questions.add(question);
        updateReputation(QUESTION_REPUTATION);
        return question;
    }

    public synchronized void updateReputation(int value)
    {
        this.reputation += value;

        if (this.reputation < 0)
        {
            this.reputation = 0;
        }
    }

    public Answer answerQuestion(Question question, String content)
    {
        Answer answer = new Answer(this, content, question);
        answers.add(answer);
        updateReputation(ANSWER_REPUTATION);
        return answer;
    }

    public Comment addComment(Commentable commentable, String content)
    {
        Comment comment = new Comment(this, content);
        comments.add(comment);
        commentable.addComment(comment);
        updateReputation(COMMENT_REPUTATION);
        return comment;
    }

}
