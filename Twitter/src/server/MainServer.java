import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;


public class Server
{
    private final int port = 8080;
    private ServerSocket server;
    private Socket socket;
    private ObjectOutputStream writer;
    private DataInputStream reader;

    // number of connections -> primary key for clients
    private static int connection;

    // a temp map to help connecting USER to SOCKET
    private static Map<Integer, Socket> connections = new HashMap<>();

    // to kill client thread when app gets closed
    private static killer = new HashMap<>();

    public void setKiller(TaskListener listener)
    {
        killer.put(connection, listener);
    }

    public static Map<Integer, TaskListener> getKiller()
    {
        return killer;
    }

    // kill a thread
    public void kill(int number) throws IOException
    {
        killer.get(number).kill();
        killer.remove(number);

        connections.get(number).close();
        connections.remove(number);
    }
