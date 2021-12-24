package data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class Tweet implements Comparable<Tweet>, Serializable
{
    private String tweet;
    private ArrayList<User> isLiked = new ArrayList<>();
    private String tweetID;
    private String dateTime;
    private int like = 0;

    public void liked()
    {
        like++;
    }

    public Tweet(String tweet)
    {
        this.tweet = tweet;
        dateTime = LocalDateTime.now().toString();
        tweetID = generateID();
    }

    private String generateID()
    {
        Random random = new Random();
        int ID = 0;

        for(int i = 0; i < 8; i++)
        {
            ID *= 10;
            ID += random.nextInt(8) + 1;
        }

        return Integer.toString(ID);
    }

    @Override
    public int compareTo(Tweet t)
    {
        return getDateTime().compareTo(t.getDateTime());
    }

    public void setDateTime(String dateTime)
    {
        this.dateTime = dateTime;
    }

    public void setTweetID(String tweetID)
    {
        this.tweetID = tweetID;
    }

    public String getDateTime()
    {
        return dateTime;
    }

    public String getTweet()
    {
        return tweet;
    }

    public int getIsLikedSize()
    {
        return like;
    }

    public String getTweetID()
    {
        return tweetID;
    }

    public User getIsLikedIndex(int index)
    {
        return isLiked.get(index);
    }

    public void addIsLiked(User user)
    {
        isLiked.add(user);
    }
}
