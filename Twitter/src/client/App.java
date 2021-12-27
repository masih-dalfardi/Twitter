package client;

import data.User;

public class App
{
    // main client which is connected to server
    public static Client client;

    public static void main(String[] args) throws Exception
    {
        client = new Client();
        client.connect();

        // open menu
        MainMenu menu = new MainMenu();

        while(true)
        {
            User currUser = menu.firstMenu();
            menu.secondMenu(currUser);
        }
    }
}
