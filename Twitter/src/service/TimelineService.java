package service;

import display.ConsoleDisplay;
import model.Client;
import model.Tweet;

import java.util.ArrayList;

/**
 * The Time line service.
 */
public class TimeLineService {
    private final ConsoleDisplay consoleDisplay = new ConsoleDisplay();

    /**
     * Show all followings tweets.
     *
     * @param client the client
     */
    public void showAllFollowingsTweets(Client client) {
        ArrayList<Client> followings = client.getFollowings();
        for (Client following: followings) {
            System.out.println(following.getUsername() + ":");
            showFollowingTweet(following);
            System.out.println("---------------------");
        }
    }

    private void showFollowingTweet(Client following) {
        for (Tweet tweet: following.getTweets()) {
            consoleDisplay.displayTweet(tweet);
        }
    }

}
