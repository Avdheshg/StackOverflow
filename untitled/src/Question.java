
import java.util.*;
import java.time.LocalDateTime;

public class Question implements Votable, Commentable
{
    private final int id;
    private final String title;
    private final String content;
    private final User author;
    private final LocalDateTime creationDate;

    private final List<Answer> answers;
    private final List<Comment> comments;
    private List<Tag> tags;
    private List<Vote> votes;

    public Question(User author, String title, String content, List<String> tagNames)
    {
        this.id = generateId();
        this.author = author;
        creationDate = LocalDateTime.now();
        this.title = title;
        this.content = content;

        this.answers = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.tags = new ArrayList<>();
        this.votes = new ArrayList<>();

        for (String tagName : tagNames)
        {
            tags.add(new Tag(tagName));
        }
    }

    public void vote(User user, int voteCount)
    {
        if (voteCount != 1 && voteCount != -1)
        {
            throw new IllegalArgumentException("Vote value must be either 1 or -1");
        }
        votes.removeIf(currVote -> currVote.getUser().equals(user));
        votes.add(new Vote(user, voteCount));
        user.updateReputation(voteCount * 5);
    }

    @Override
    public void addComment(Comment comment)
    {
        comments.add(comment);
    }

    @Override
    public List<Comment> getComments()
    {
        return new ArrayList<>(comments);
    }

    private int generateId()
    {
        return (int)(System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    public int getId() {return id;}
    public User getAuthor() {return author;}
    public LocalDateTime getCreationDate() {return creationDate;}
    public String getTitle() {return title;}
    public String getContent() {return content;}
    public List<Answer> getAnswers() {return answers;}
    public List<Tag> getTags() {return tags;}
    public List<Vote> getVotes() {return votes;}

}


