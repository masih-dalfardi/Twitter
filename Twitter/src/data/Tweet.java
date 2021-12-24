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

   
}