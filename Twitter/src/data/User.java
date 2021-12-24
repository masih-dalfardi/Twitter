package data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class User implements Serializable
{
    private String firstName, lastName;
    private String name;
    private String password;
    private ArrayList<User> followers = new ArrayList<>();
    private ArrayList<User> followings = new ArrayList<>();
    private ArrayList<Tweet> userTweets = new ArrayList<>();
    private String joinDate, birthDate, bio;

    public ArrayList<Tweet> getUserTweets()
    {
        return userTweets;
    }

    public String getBio()
    {
        return bio;
    }

    public User(String firstName)
    {
        this.firstName = firstName;
    }

    public User(String firstName, String lastName, String name, String password,
                String birthDate, String bio)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.name = name;
        this.password = password;
        this.birthDate = birthDate;
        this.bio = bio;
        this.joinDate = LocalDate.now().toString();
    }

    public Tweet getIndexOfTweet(int index)
    {
        return userTweets.get(index);
    }

    public int getSizeOfTweets()
    {
        return userTweets.size();
    }

    public void addTweet(Tweet tweet)
    {
        userTweets.add(tweet);
    }

    public String getName()
    {
        return name;
    }

    public String getPassword()
    {
        return password;
    }

    public User getFollowersIndex(int index)
    {
        return followers.get(index);
    }

    public void removeFollower(User user)
    {
        followers.remove(user);
    }

    public void addToFollowers(User user)
    {
        followers.add(user);
    }

    public int getFollowersSize()
    {
        return followers.size();
    }

    public User getFollowingsIndex(int index)
    {
        return followings.get(index);
    }

    public void removeFollowing(int index)
    {
        followings.remove(index);
    }

    public void addToFollowings(User user)
    {
        followings.add(user);
    }

    public int getFollowingsSize()
    {
        return followings.size();
    }

    public ArrayList<User> getFollowers() {
        return followers;
    }

    public ArrayList<User> getFollowings() {
        return followings;
    }
}
