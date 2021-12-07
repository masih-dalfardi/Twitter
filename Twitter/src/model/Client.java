package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 * The type Client.
 */
public class Client {
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private Date birthDate;
    private Date joinDate;
    private String bio;
    private final ArrayList<Tweet> tweets;
    private final ArrayList<Client> followers;
    private final ArrayList<Client> followings;

    /**
     * Instantiates a new Client.
     *
     * @param firstname the firstname
     * @param lastname  the lastname
     * @param username  the username
     * @param password  the password
     * @param birthDate the birth date
     * @param joinDate  the join date
     * @param bio       the bio
     */
    public Client(String firstname, String lastname, String username,
                  String password, Date birthDate, Date joinDate, String bio) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.birthDate = birthDate;
        this.joinDate = joinDate;
        this.bio = bio;
        tweets = new ArrayList<>();
        followers = new ArrayList<>();
        followings = new ArrayList<>();
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(username, client.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }
  /**
     * Gets tweets.
     *
     * @return the tweets
     */
    public ArrayList<Tweet> getTweets() {
        return tweets;
    }
   /**
     * Gets followings.
     *
     * @return the followings
     */
    public ArrayList<Client> getFollowings() {
        return followings;
    }
     /**
     * Add tweet int.
     *
     * @param tweet the tweet
     * @return the int
     */
    public int addTweet(Tweet tweet) {
        tweets.add(tweet);
        return 0;
    }

    /**
     * Remove tweet int.
     *
     * @param tweet the tweet
     * @return the int
     */
    public int removeTweet(Tweet tweet) {
        tweets.remove(tweet);
        return 0;
    }
    /**
     * Add follower int.
     *
     * @param client the client
     * @return the int
     */
    public int addFollower(Client client) {
        followers.add(client);
        return 0;
    }

    /**
     * Add following int.
     *
     * @param client the client
     * @return the int
     */
    public int addFollowing(Client client) {
        followings.add(client);
        return 0;
    }

    /**
     * Remove follower int.
     *
     * @param client the client
     * @return the int
     */
    public int removeFollower(Client client) {
        followers.remove(client);
        return 0;
    }

    /**
     * Unfollow int.
     *
     * @param client the client
     * @return the int
     */
    public int Unfollow(Client client) {
        followings.remove(client);
        return 0;
    }
