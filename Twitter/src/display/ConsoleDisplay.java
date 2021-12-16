package display;

import model.Tweet;

/**
 * The Console display.
 * prints objects based on specific format in the console.
 */
public class ConsoleDisplay {
    /**
     * Display tweet.
     *
     * @param tweet the tweet
     */
    public void displayTweet(Tweet tweet) {
        System.out.println(tweet);
    }
}
