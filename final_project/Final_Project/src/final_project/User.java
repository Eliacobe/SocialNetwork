package final_project;
import java.io.*;
import java.util.*;


/**
*User class.
 */

public class User
{
    private String userID;
    private String name;
    private String workplace;
    private String hometown;
    private List<User> friends;
    /**
    *constructor method for User. sets the given values and also opens a new arraylist for the users friends. 
    *@peram String userID
    *@peram String name
    *@peram String workplace
    *@peram String homeTown
 */
    public User(String userID, String name, String workplace, String hometown)
    {
        this.userID = userID;
        this.name = name;
        this.workplace = workplace;
        this.hometown = hometown;
        this.friends = new ArrayList<>();
    }
    /**
    *Getter method for UserID
    *@return String userID
 */
    public String getUserID()
    {
        return userID;
    }
    /**
    *Getter method for name
    *@return String name
 */
    public String getName()
    {
        return name;
    }
    /**
    *Getter method for workplace
    *@return String workplace
 */
    public String getWorkplace()
    {
        return workplace;
    }
    /**
    *Getter method for hometown
    *@return String hometown
 */
    public String getHometown()
    {
        return hometown;
    }
    /**
    *Getter method for friends
    *@return List<User> friends
 */
    public List<User> getFriends()
    {
        return friends;
    }
    /**
    *add method to add friend to the friends hashmap
    *@peram User friend
 */
    public void addFriend(User friend)
    {
        friends.add(friend);
        friend.getFriends().add(this);
    }
    /**
    *remove friends from friends hashmap
    *@peram User friend
 */
    public void removerFriend(User friend)
    {
        friends.remove(friend);
        friend.getFriends().remove(this);
    }
/**
* setter mmethod for setting the users name
*@return String name
 */
    public void setName(String name){
        this.name = name;
    }
/**
* setter mmethod for setting users workplace
*@return String workplace
 */
    public void setWorkplace(String workplace){
        this.workplace = workplace;
    }
/**
* setter mmethod for setting the hometown of the user
*@return String hometown
 */
    public void setHometown(String hometown){
        this.hometown = hometown;
    }
}