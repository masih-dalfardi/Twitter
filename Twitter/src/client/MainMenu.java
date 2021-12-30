
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

    // print first menu
    private String firstMenuPrint()
    {
        cls();
        System.out.println("1) Login.");
        System.out.println("2) Sign up.");
        System.out.println("3) Quit.");
        System.out.println("Please enter a number to advance:");

        return in.next();
    }


    // login part
    private User login() throws IOException, ClassNotFoundException
    {
        String userName;
        String password;

        System.out.println("Please enter your user name:");
        userName = in.next();

        System.out.println();

        System.out.println("Please enter your password:");
        password = in.next();

        App.client.getWriter().writeUTF(Tasks.getLoginTask(userName, password));

        User user = (User) App.client.getReader().readObject();

        if(user.getName().equals("WRONG"))
        {
            cls();
            System.out.println("data.User name or password is wrong!");
            System.out.println("Press enter to continue.");
            in.nextLine();
            in.nextLine();
            return null;
        }

        else
        {
            return user;
        }
    }

    private User signUp() throws Exception
    {
        System.out.println("Please enter your name:");

        String name;
        String password;

        name = in.next();

        System.out.println();
        System.out.println("Please enter your password.");
        password = in.next();

        System.out.println("Please now enter your name, last name, birthdate, bio");
        String firstName = in.next(), lastNAme = in.next(), birth = in.next(), bio = in.next();

        String task = Tasks.getSignUpTask(firstName, lastNAme, name, password, birth, bio);

        if(bio.length() > 256)
        {
            throw new Exception();
        }

        App.client.getWriter().writeUTF(task);

        System.out.println(App.client.getReader().readObject().toString());

        User currUser = new User(firstName, lastNAme, name, password, birth, bio);
        return currUser;
    }
      // clear the cmd
    private void cls()
    {
        for(int i = 0; i < 40; i++)
        {
            System.out.println();
        }
    }
    public void secondMenu(User currUser) throws Exception
    {
        while(true)
        {
            String action = secondMenuPrint();

            switch (action)
            {
                case "1": return;

                case "2": myProfile(currUser);
                    break;
                case "3": tweet(currUser);
                    break;
                case "4": follow(currUser);
                    break;
                case "5": unfollow(currUser);
                    break;
                case "6": followers(currUser);
                    break;
                case "7": followings(currUser);
                    break;
                case "8": timeLine(currUser);
                    break;
                case "9": profile();
                    break;
                case "10": like(currUser);
                    break;
                case "11": System.exit(0);
                    break;
            }
        }
    }

    private String secondMenuPrint()
    {
        cls();
        System.out.print("1) Logout.\n2) My Profile.\n3) data.Tweet.\n4) Follow.\n5) Unfollow.\n");
        System.out.print("6) Followers.\n7) Following.\n8) Timeline.\n9) Profile.\n10) Like.\n11) Quit.\n");
        System.out.println("Please enter a number:");

        return in.next();
    }
        private void myProfile(User currUser)
    {
        System.out.println(currUser.getName());
        System.out.println("-------------------------");
        System.out.println(currUser.getBio());
        System.out.println("-------------------------");

        for(int i = 0; i < currUser.getSizeOfTweets(); i++)
        {
            System.out.println(currUser.getIndexOfTweet(i).getTweet());
            System.out.println("data.Tweet ID: " + currUser.getIndexOfTweet(i).getTweetID());
            System.out.println("Likes: " + currUser.getIndexOfTweet(i).getIsLikedSize());
        }
        System.out.println("Press enter to continue.");
        in.nextLine();
        in.nextLine();
    }

    private void tweet(User currUser) throws IOException
    {
        System.out.println("Please enter your tweet:");
        in.nextLine();
        String newTweet = in.nextLine();

        Tweet tweet = new Tweet(newTweet);
        currUser.addTweet(tweet);

        String task = Tasks.getNewTweetTask(currUser.getName(), newTweet, tweet.getTweetID(), tweet.getDateTime());
        App.client.getWriter().writeUTF(task);
    }
