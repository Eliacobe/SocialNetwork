import java.util.*;
import java.io.*;

class User
{
    private String userID;
    private String name;
    private String workplace;
    private String hometown;
    private List<User> friends;
    
    public User(String userId, String name, String workplace, String hometown)
    {
        this.userID = userID;
        this.name = name;
        this.workplace = workplace;
        this.hometown = hometown;
        this.friends = new ArrayList<>();
    }
    
    public String getUserID()
    {
        return userID;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getWorkplace()
    {
        return workplace;
    }
    
    public String getHometown()
    {
        return hometown;
    }
    
    public List<User> getFriends()
    {
        return friends;
    }
    
    public void addFrend(User friend)
    {
        friends.add(friend);
        friend.getFriends().add(this);
    }
    
    public void removerFriend(User friend)
    {
        friends.remove(friend);
        friend.getFriends().remove(this);
    }

    public void setName(String name){
        this.name = name;
    }

    public void setWorkplace(String workplace){
        this.workplace = workplace;
    }

    public void setHometown(String hometown){
        this.hometown = hometown;
    }
}