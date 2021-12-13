package dao;

import model.Client;
import model.Tweet;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

/**
 * The Tweet DAO
 */
public class TweetDao {

    /**
     * Add tweet
     *
     * @param tweet the tweet
     * @return the int
     */
    public int addTweet(Tweet tweet) {
        Client sender = tweet.getSender();
        return sender.addTweet(tweet);
    }

    /**
     * Remove tweet int.
     *
     * @param tweet the tweet
     * @return the int
     */
    public int removeTweet(Tweet tweet) {
        Client sender = tweet.getSender();
        return sender.removeTweet(tweet);
    }
        /**
     * Search by date.
     *
     * @param sender the sender
     * @param date   the date
     * @return the optional date
     */
    public Optional<Tweet> searchByDate(Client sender, Date date) {
        ArrayList<Tweet> tweets = sender.getTweets();
        Optional<Tweet> optionalTweet = Optional.empty();
        for (Tweet tweet: tweets) {
            if (tweet.getSendDate().equals(date)) {
                optionalTweet = Optional.of(tweet);
            }
        }
        return optionalTweet;
    }
}
