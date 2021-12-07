package model;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

/**
 * The type Tweet.
 */
public class Tweet {
    private String body;
    private Client sender;
    private int likes;
    private Date sendDate;

    /**
     * Instantiates a new Tweet.
     *
     * @param body     the body
     * @param sender   the sender
     * @param likes    the likes
     * @param sendDate the send date
     */
    public Tweet(String body, Client sender, int likes, Date sendDate) {
        this.body = body;
        this.sender = sender;
        this.likes = likes;
        this.sendDate = sendDate;
    }

    /**
     * Gets sender.
     *
     * @return the sender
     */
    public Client getSender() {
        return sender;
    }

    /**
     * Gets likes.
     *
     * @return the likes
     */
    public int getLikes() {
        return likes;
    }

    /**
     * Sets likes.
     *
     * @param likes the likes
     */
    public void setLikes(int likes) {
        this.likes = likes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tweet tweet = (Tweet) o;
        return Objects.equals(sender, tweet.sender) && Objects.equals(sendDate, tweet.sendDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sender, sendDate);
    }

    /**
     * Gets send date.
     *
     * @return the send date
     */
    public Date getSendDate() {
        return sendDate;
    }

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy mm/HH");
        return "| " + sender.getUsername() + "\t\t" + simpleDateFormat.format(sendDate)
                + "\n| " + body + "\n| " + likes + " likes";
    }
}
