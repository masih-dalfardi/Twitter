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
