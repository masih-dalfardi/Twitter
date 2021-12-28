
import data.Tweet;
import data.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MainMenu
{
    Scanner in = new Scanner(System.in);

    // handle first menu
    public User firstMenu() throws Exception
    {
        while(true)
        {
            String action = firstMenuPrint();

            if(action.equals("1"))
            {
                cls();
                User currUser = login();

                if(currUser != null)
                {
                    return currUser;
                }
            }
            else if(action.equals("2"))
            {
                cls();
                User currUser = signUp();

                if(currUser != null)
                {
                    return currUser;
                }
            }
            else if(action.equals("3"))
            {
                System.exit(0);
            }
        }
    }
