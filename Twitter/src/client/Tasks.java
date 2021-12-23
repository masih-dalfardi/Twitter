package client;

public interface Tasks
{
    String signUp = "{\"task\":\"signup\",\"name\":\"%s\",\"last name\":\"%s\",\"username\":\"%s\",\"password\":\"%s\",\"date\":\"%s\",\"bio\":\"%s\"}";
    String login = "{\"task\":\"login\",\"username\":\"%s\",\"password\":\"%s\"}";
    String newTweet = "{\"task\":\"new tweet\",\"username\":\"%s\",\"tweet\":\"%s\",\"id\":\"%s\",\"date\":\"%s\"}";
    String follow = "{\"task\":\"follow\",\"username\":\"%s\",\"user\":\"%s\"}";
    String prof = "{\"task\":\"prof\",\"username\":\"%s\"}";
    String like = "{\"task\":\"like\",\"id\":\"%s\",\"username\":\"%s\"}";
    String unfollow = "{\"task\":\"unfollow\",\"from\":\"%s\",\"to\":\"%s\"}";

    static String getSignUpTask(String name, String lname, String username, String password, String date, String bio)
    {
        return String.format(signUp,name, lname, username, password, date, bio);
    }

    static String getLoginTask(String username, String password)
    {
        return String.format(login, username, password);
    }

    static String getNewTweetTask(String name, String newT, String tweetID, String dateTime)
    {
        return String.format(newTweet, name, newT, tweetID, dateTime);
    }

    static String getFollowTask(String name, String userName)
    {
        return String.format(follow, name, userName);
    }

    static String getProfTask(String userName)
    {
        return String.format(prof, userName);
    }

    static String getLike(String id, String username)
    {
        return String.format(like, id, username);
    }

    static String getUnfollow(String name, String userName) {

        return String.format(unfollow, name, userName);
    }
}
