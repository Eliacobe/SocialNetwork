package final_project;
import java.util.*;
import java.io.*;
import java.util.HashSet;

/**
*The main class for the social network.
 */

public class SocialNetwork
{
    private Map<String, User> users;
    /**
    *constructor for SocialNetwork sets new hashmap.
 */
    public SocialNetwork()
    {
        this.users = new HashMap<>();
        try
        {
            loadFromFile("socialNetworkTest.txt");
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
    /**
    *loads the users from the users file.
    *@peram String filename
 */
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
    /**
    *saves users to user file
    *@peram String filename
 */
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
    /**
    *getter method for userID
    *@peram String userID
    *@return User user of given ID. 
 */
    
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
                writer.append(friendID);
                writer.newLine();
            }
        }
    }
    
    public User getUser(String userID)
    {
        return users.get(userID);
    }
    
    public Map<String, User> getUsers(){
        return users;
    }
    

    /**adds user to the users hashmap
    @peram String userID
 */

    public void addUser(User user)
    {
        users.put(user.getUserID(), user);
    }
    /**
    *remove user from users hashmap
    *@peram User user
 */
    public void removeUser(User user)
    {
        for (User friend : user.getFriends())
        {
            friend.getFriends().remove(user);
        }
        users.remove(user.getUserID());
    }
    /**
    *getter method for friends of the user
    *@peram String myUserID
    *@return List<User> list of friends of the user.
 */
    public List<User> getMyFriends(String myUserID)
    {
        User me = getUser(myUserID);
        //System.out.println(me.getUserID());
        return me.getFriends();
    }
/**
*getter fror friends of friends
*@peram String friendUserID
*@return List<User> list of friends for a friend of the user
 */
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
/**
*method for filtering friends based on specific attributes.
*@peram String myUserID
*@peram String filterType
*@peram String filterValue
*@return List<User> a list with freinds that meet the filter.
 */
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
/**
*method to give friend reccomendations
*@peram String myUserID
*@return List<User> a list containing the reccomendations.
 */
    public List<User> friendRecommendations(String myUserID)
    {
        List<User> recommendations = new ArrayList<>();
        List<User> myFriends = getMyFriends(myUserID);
        //System.out.println(myFriends);
        for (User friend : myFriends)
        {
            List<User> friendFriend = friend.getFriends();
            for (User friendFriends : friendFriend)
            {
                if (friendFriends != null){
                    if (!friendFriends.getUserID().equals(myUserID) && !myFriends.contains(friendFriend) && !recommendations.contains(friendFriend))
                    {
                        recommendations.add(friendFriends);
                    }
                }
                else
                {
                    System.out.println("Error");
                }
            }
        }
        return recommendations;
    }
}