package data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class User implements Serializable
{
    private String firstName, lastName;
    private String name;
    private String password;
    private ArrayList<User> followers = new ArrayList<>();
    private ArrayList<User> followings = new ArrayList<>();
    private ArrayList<Tweet> userTweets = new ArrayList<>();
    private String joinDate, birthDate, bio;


}