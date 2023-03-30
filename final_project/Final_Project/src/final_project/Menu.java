package final_project;
import java.util.*;
import java.io.*;


public class Menu
{

    public Menu(){
        //MainUser = new User("JK12", "MainMan", "UoD", "Dundee");
        Social = new SocialNetwork();
        //load jk12 from file. call get user in social
        MainUser = Social.getUser("JK12");
        //load list of friends to user, from file.
        Set<String> friends = new HashSet<>();
        for(User u: Social.getUsers().values()){
            friends = LoadFriends(u);
            for(String f:friends){
                MainUser.addFriend(Social.getUser(f));
            }
        }
    }
    SocialNetwork Social;
    private static boolean running = true;
    private User MainUser;
    public void profile()
    {

        
        
        System.out.println("To exit and go back to the menu press 1: ");    
        System.out.println(MainUser.getName() + "             " + MainUser.getUserID());
        System.out.println("I live in " + MainUser.getHometown());
        System.out.println("I work at " + MainUser.getWorkplace());
        System.out.println();
        
        //posts being loaded from file then displayed
        ReadingPostsFromFile PostList = new ReadingPostsFromFile();


        try {
            PostList.readFromFile(MainUser.getUserID());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("failed to load posts");
        }

        //looping through the posts to display them
        for(UserPost userpost : PostList.posts)
        {
            System.out.println(userpost.getContent());
        }


        System.out.println("If you would like to view your friends list press 2: ");
       
        Scanner scan = new Scanner(System.in);
        int ans = scan.nextInt();

        switch(ans)
        {
            case (1): 
            {
                System.out.println("Exiting");
            }
            break;

            case (2): 
            {
                System.out.println("Friend List: ");
                ViewMyFriends(MainUser);
            }
            break;
        }
    }

    public Set<String> LoadFriends(User u){
        Set<String> Friends = new HashSet<>();
        String friendsFile = u.getUserID() + " friends.txt";
        try 
        {
            Friends = Social.loadFriends(friendsFile);
            Friends.remove(u.getUserID());
        }   
        catch(IOException e)
        {
            System.out.println("Failed to load");
            e.printStackTrace();
        }
        return Friends;
    }
    
    
    
    //show a list of all the main users friends
    public boolean ViewMyFriends(User  UserID)
    {
        boolean loaded = false;
        Set<String> Friends = LoadFriends(UserID);
        Iterator<String> iter = Friends.iterator();
        while (iter.hasNext())
        {
            System.out.println(iter.next());
        }
        loaded = true;


        System.out.println("To return to the menu press 1:  ");
        System.out.println("To return to your profile press 2:  ");
        Scanner scan = new Scanner(System.in);
        int ans = scan.nextInt();

        switch(ans)
        {
            case (1): 
            {
                System.out.println("Exiting");
            }
            break;

            case (2): 
            {
                profile();
            }
            break;
        }

        return loaded;
    }
    
    public void recommendations()
    {
        String friendsFile = MainUser.getUserID() + " friends.txt";
        Set<String> Friends = null;
        try
        {
            Friends = Social.loadFriends(friendsFile);
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        List<User> ff = new ArrayList<>() ;
        for(String f:Friends){
            //get friend from id from above file
            ff.add(Social.getUser(f));
            
        }
        MainUser.setFriends(ff);
        List<User> recoms = Social.friendRecommendations(MainUser.getUserID());
        //System.out.println(recoms);
        for (User recFriend : recoms)
        {
            System.out.println(recFriend.getName() + " " + recFriend.getUserID());
        }
    }
    
    public void saveFriendsList()
    {
        String filename = MainUser.getUserID()+" friends.txt";
        ArrayList<String> friendIDs = new ArrayList<String>();
        for (User friend : MainUser.getFriends())
        {
            friendIDs.add(friend.getUserID());
        }
        try
        {
            Social.saveFriends(filename, friendIDs);
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
    
    public void addFriend(String userID)
    {
        MainUser.addFriend(Social.getUser(userID));
        saveFriendsList();
    }
    
    public void removeFriend(String userID)
    {
        MainUser.removeFriend(Social.getUser(userID));
        saveFriendsList();
    }
    
    //main 
    public void test()
    {
        while(running)
        {
            //System.out.print("\033[H\033[2J");  
            System.out.flush();  
            Scanner scan1 = new Scanner(System.in);
            System.out.println("To view your profile press 1: ");
            System.out.println("To view your friends list press 2: ");
            System.out.println("To view list of recommended friends press 3");
            System.out.println("To add friends press 4");
            System.out.println("To remove friends press 5");
            System.out.println("To view friends of a friend press 6");
            System.out.println("To exit the Social Network press 0: ");
            
            int ans = scan1.nextInt();
            scan1.nextLine();
            switch(ans)
            {
                case (1):
                {
                    profile();
                }
                break;

                case (2): 
                {
                    System.out.println("Friend List: ");
                    ViewMyFriends(MainUser);
                }
                break;
                
                case (3):
                {
                    recommendations();        
                }
                break;
                
                case (4):
                {
                    System.out.println("Enter the user ID of the friend you want to add: ");
                    String ID = scan1.nextLine();
                    addFriend(ID);
                }
                break;
                
                case (5):
                {
                    System.out.println("Enter the user ID of the friend you want to remove: ");
                    String ID = scan1.nextLine();
                    removeFriend(ID);
                }
                break;
                
                case (6):
                {
                    System.out.println("Enter the user ID of the friend you want to view: ");
                    String ID = scan1.nextLine();
                    ViewMyFriends(Social.getUser(ID));
                }
                break;
                
                case (0): 
                {
                    running = false;
                }
                break;

            }
        }

    }


    public static void main(String[] args)
    {
        Menu menu = new Menu();
        menu.test();
    }
}