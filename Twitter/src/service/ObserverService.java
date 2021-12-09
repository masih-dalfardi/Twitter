package service;

import dao.ClientDao;
import model.Client;
import model.Tweet;

import java.util.ArrayList;
import java.util.Optional;

/**
 * The Observer service.
 */
public class ObserverService {
    private final ClientDao clientDao = new ClientDao();

    /**
     * Follow int.
     *
     * @param client           the client
     * @param usernameToFollow the username to follow
     * @return the int
     */
    public int follow(Client client, String usernameToFollow) {
        Optional<Client> clientOptional = clientDao.searchByUsername(usernameToFollow);
        if (clientOptional.isPresent()) {
            Client toFollow = clientOptional.get();
            toFollow.addFollower(client);
            return client.addFollowing(toFollow);
        } else {
            // username does not exist!
            return -1;
        }
    }
 /**
     * Unfollow int.
     *
     * @param client             the client
     * @param usernameToUnfollow the username to unfollow
     * @return the int
     */
    public int unfollow(Client client, String usernameToUnfollow) {
        Optional<Client> clientOptional = clientDao.searchByUsername(usernameToUnfollow);
        if (clientOptional.isPresent()) {
            Client toUnfollow = clientOptional.get();
            toUnfollow.removeFollower(client);
            return client.Unfollow(toUnfollow);
        } else {
            // username does not exist!
            return -1;
        }
    }

    /**
     * Gets all followings tweets.
     *
     * @param client the client
     * @return the all followings tweets
     */
    public ArrayList<Tweet> getAllFollowingsTweets(Client client) {
        ArrayList<Tweet> tweets = new ArrayList<>();
        ArrayList<Client> followings = client.getFollowings();

        for (Client following : followings) {
            tweets.addAll(following.getTweets());
        }
        return tweets;
    }
}
