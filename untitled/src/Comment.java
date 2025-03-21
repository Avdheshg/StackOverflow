import java.time.LocalDateTime;

public class Comment
{
    private final int id;
    private final String content;
    private final User author;
    private final LocalDateTime creationDate;

    public Comment( User author, String content)
    {
        this.id = generateId();
        this.author = author;
        this.content = content;
        this.creationDate = LocalDateTime.now();
    }

    private int generateId()
    {
        return (int) (System.currentTimeMillis()  % Integer.MAX_VALUE);
    }
}
