import java.util.*;
import java.io.*;

class SocialNetwork
{
    private Map<String, User> users;
    
    public SocialNetwork()
    {
        this.users = new HashMap<>();
    }
    
    public void loadFromFile(String filename) throws IOException
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                String[] fields = line.split(",");
                String userID = fields[0];
                String name = fields[1];
                String workplace = fields[2];
                String hometown = fields[3];
                User user = new User(userID, name, workplace, hometown);
                users.put(userID, user);
            }
        }
    }
    
    public void saveToFile(String filename) throws IOException
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename)))
        {
            for (User user : users.values())
            {
                writer.write(user.getUserID() + "," + user.getName() + "," + user.getWorkplace() + "," + user.getHometown());
                writer.newLine();
            }
        }
    }
    
    public User getUser(String userID)
    {
        return users.get(userID);
    }
    
    public void addUser(User user)
    {
        users.put(user.getUserID(), user);
    }
    
    public void removeUser(User user)
    {
        for (User friend : user.getFriends())
        {
            friend.getFriends().remove(user);
        }
        users.remove(user.getUserID());
    }
    
    public list<User> getMyFriends(String myUserID)
    {
        User me = getUser(myUserID);
        return me.getFriends;
    }

    public list<User> getFriendFriends(String friendUserID)
    {
        User friend = getUser(friendUserID);
        List<User> friendFriends = new ArrayList<>();
        for (User friendFriend : friend.getFriends())
        {
            if ()
        }
    }
}