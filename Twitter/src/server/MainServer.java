package server;

import data.User;
import java.util.ArrayList;
import java.util.List;


public class MainServer
{
    public static Server server;
    public static List<User> users = new ArrayList<>();

    public static void main(String[] args) throws Exception
    {
        server = new Server();

        while (true)
        {
            server.waitForConnection();

            TaskListener listener = new TaskListener(server.getWriter(), server.getReader());

            server.setKiller(listener);

            Thread thread = new Thread(listener);

            thread.start();
        }
    }
}
