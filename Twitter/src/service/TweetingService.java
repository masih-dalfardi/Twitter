package service;

import dao.TweetDao;
import model.Client;
import model.Tweet;
import java.util.Date;
import java.util.Optional;

/**
 * The Tweeting service.
 */
public class TweetingService {
    private final static int MAX_BODY_LENGTH = 256;

    private final TweetDao tweetDao = new TweetDao();

    /**
     * Tweeting int.
     *
     * @param body   the body
     * @param sender the sender
     * @return the int
     */
    public int tweeting(String body, Client sender) {
        // maximum length of body!
        if (body.length() > MAX_BODY_LENGTH)
            return 1;
        Tweet tweet = new Tweet(body, sender, 0, new Date());
        return tweetDao.addTweet(tweet);
    }

    /**
     * Like tweet int.
     *
     * @param sender    the sender
     * @param tweetDate the tweet date
     * @return the int
     */
    public int likeTweet(Client sender, Date tweetDate) {
        Optional<Tweet> optionalTweet = tweetDao.searchByDate(sender, tweetDate);

        if (optionalTweet.isPresent()) {
            Tweet tweet = optionalTweet.get();
            tweet.setLikes(tweet.getLikes() + 1);
            return 0;
        } else {
            // tweet does not exist!
            return -1;
        }
    }

    /**
     * Delete tweet int.
     *
     * @param sender    the sender
     * @param tweetDate the tweet date
     * @return the int
     */
    public int deleteTweet(Client sender, Date tweetDate) {
        Optional<Tweet> optionalTweet = tweetDao.searchByDate(sender,tweetDate);

        if (optionalTweet.isPresent()) {
            Tweet tweet = optionalTweet.get();
            return sender.removeTweet(tweet);
        } else {
            // tweet does not exist!
            return -1;
        }

    }
}
