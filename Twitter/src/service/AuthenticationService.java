package service;

import dao.ClientDao;
import model.Client;
import java.util.Date;
import java.util.Optional;

/**
 * The Authentication service.
 */
public class AuthenticationService {
    private final static int MAX_BIO_LENGTH = 256;
    private final ClientDao clientDao = new ClientDao();

    /**
     * Sign in int.
     *
     * @param username the username
     * @param password the password
     * @return the int
     */
    public int signIn(String username, String password) {
        Optional<Client> optionalClient = clientDao.searchByUsername(username);
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            if (authenticateClient(client, password) == 0) {
                clientDao.addToLogInClients(client);
                return 0;
            } else {
                // wrong password
                return -1;
            }
        } else {
            // wrong username
            return 1;
        }
    }

    private int authenticateClient(Client client, String password) {
        if (client.getPassword().equals(password))
            return 0;
        else
            return -1;
    }
    /**
     * Signup int.
     *
     * @param username  the username
     * @param password  the password
     * @param firstname the firstname
     * @param lastname  the lastname
     * @param birthdate the birthdate
     * @param bio       the bio
     * @return the int
     */
    public int signup(String username, String password, String firstname, String lastname, Date birthdate, String bio) {

        // maximum length of bio!
        if (bio.length() > MAX_BIO_LENGTH)
            return 1;
        Optional<Client> optionalClient = clientDao.searchByUsername(username);
        if (optionalClient.isEmpty()) {
            Client client = new Client(firstname, lastname, username,
                    password, birthdate, new Date(), bio);
            return clientDao.addToTotalClients(client);
        } else {
            // username is already exists!
            return -1;
        }
    }
}
