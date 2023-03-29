package final_project;
import java.util.*;
import java.io.*;
import java.util.HashSet;

public class SocialNetwork
{
    private Map<String, User> users;
    
    public SocialNetwork()
    {
        this.users = new HashMap<>();
    }
    
    public void loadFromFile(String filename) throws IOException
    {
        // Creating new instance of buffered reader to read from the file named
        try (BufferedReader reader = new BufferedReader(new FileReader(filename)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                // While the line being read has nothing in it, read through each part of current line
                // where fields are split by commas and then create new instance of User with said fields as parameters
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
    
    public Set<String> loadFriends(String filename) throws IOException
    {
        Set<String> friendIDs = new HashSet<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filename)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                friendIDs.add(line.trim());
            }
        }
        return friendIDs;
    }
    
    public void saveFriends(String filename, ArrayList<String> friendIDs) throws IOException 
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename)))
        {
            for (String friendID : friendIDs)
            {
                writer.write(friendID);
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
    
    public List<User> getMyFriends(String myUserID)
    {
        User me = getUser(myUserID);
        return me.getFriends();
    }

    public List<User> getFriendFriends(String friendUserID)
    {
        User friend = getUser(friendUserID);
        List<User> friendFriends = new ArrayList<>();
        for (User friendFriend : friend.getFriends())
        {
            if (!friendFriend.getUserID().equals(friendUserID))
            {
                friendFriends.add(friendFriend);
            }
        }
        return friendFriends;
    }

    public List<User> filterFriends(String myUserID, String filterType, String filterValue)
    {
        List<User> myFriends = getMyFriends(myUserID);
        List<User> filteredFriends = new ArrayList<>();
        for (User friend : myFriends)
        {
            if (filterType.equals("workplace") && friend.getWorkplace().equals(filterValue))
            {
                filteredFriends.add(friend);
            }
            if (filterType.equals("hometown") && friend.getHometown().equals(filterValue))
            {
                filteredFriends.add(friend);
            }
            else
            {
                System.out.println("Cannot filter for "+filterValue);
            }
        }
        return filteredFriends;
    }

    public List<User> friendRecommendations(String myUserID)
    {
        List<User> recommendations = new ArrayList<>();
        User me = getUser(myUserID);
        List<User> myFriends = me.getFriends();
        for (User friend : myFriends)
        {
            List<User> friendFriend = friend.getFriends();
            for (User friendFriends : friendFriend)
            {
                // if the ID obtained from friendFriends.getUserID is not equal to the main user's ID
                // and the main user's friend does not contain the ID and recommendations does not contain the ID
                // then add the ID of that person to the recommendations list
                if (!friendFriends.getUserID().equals(myUserID) && !myFriends.contains(friendFriend) && !recommendations.contains(friendFriend))
                {
                    recommendations.add(friendFriends);
                }
            }
        }
        return recommendations;
    }
}