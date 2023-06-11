import java.io.Serializable;

public class Movie implements Serializable {
    private String title;
    private String author;
    private String description;
    private int coverResId;
    private String date;

    public Movie(String title, String author, String description, int coverResId, String date) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.coverResId = coverResId;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public int getCoverResId() {
        return coverResId;
    }

    public String getDate() {
        return date;
    }
}
