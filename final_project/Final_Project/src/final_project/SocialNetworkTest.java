package final_project;

import java.io.IOException;
import java.util.List;

public class SocialNetworkTest
{
    public void SocialNetworkTester()
    {
        SocialNetwork network = new SocialNetwork();

        try 
        {
            network.loadFromFile("users.csv");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        User user1 = network.getUser("123");
        System.out.println(user1);

        User user2 = new User("571", "Thomas", "Generic coffee shop", "Edinburgh");
        network.addUser(user2);

        network.removeUser(user1);

        List<User> friends = network.getMyFriends("571");
        System.out.println(friends);

        List<User> friendFriends = network.getFriendFriends("321");
        System.out.println(friendFriends);

        List<User> filteredFriends = network.filterFriends("571", "Generic coffee shop", "Edinburgh");
        System.out.println(filteredFriends);

        List<User> recommendations = network.friendRecommendations("571");
        System.out.println(recommendations);

        try
        {
            network.saveToFile("users.csv");
        }    
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


}