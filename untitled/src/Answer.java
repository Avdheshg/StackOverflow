
import java.util.*;
import java.time.LocalDateTime;

public class Answer implements Commentable, Votable
{
    private final int id;
    private final String content;
    private User author;
    private Question question;
    private LocalDateTime creationDate;
    private final List<Comment> comments;
    private final List<Vote> votes;
    private boolean isAccepted;

    public Answer( User author, String content, Question question)
    {
        this.id = generateId();
        this.content = content;
        this.author = author;
        this.question = question;
        this.creationDate = LocalDateTime.now();

        comments = new ArrayList<>();
        this.votes = new ArrayList<>();

    }

    public void markAnswerAccepted()
    {
        if (isAccepted)
        {
            throw new IllegalStateException("This answer is already accepted.");
        }
        isAccepted = true;
        author.updateReputation(15);
    }

    private int generateId()
    {
        return (int)(System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    public int getId() {return id;}
    public String getContent() {return content;}
    public User getAuthor() {return author;}
    public Question getQuestion() {return question;}
    public LocalDateTime getCreationDate() {return creationDate;}

    @Override
    public List<Comment> getComments()
    {
        return new ArrayList<>(comments);
    }

    @Override
    public void addComment(Comment comment)
    {
        comments.add(comment);
    }

    @Override
    public void vote(User user, int value)
    {
        votes.add(new Vote(user, value));
    }

    @Override
    public int getVoteCount()
    {
        return votes.stream().mapToInt(Vote::getValue).sum();
    }

//    public int getVoteCount()
//    {
//        return 1;
//    }
}
