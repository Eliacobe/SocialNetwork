package final_project;
import java.util.*;
import java.io.*;

/**
*Menu Class also inclueds main method
 */
public class Menu
{
/**
*Constuctor method for Menu Class.
*Sets main user and creates new social netowork instance
*
 */
    public Menu(){
        MainUser = new User("JK12", "MainMan", "UoD", "Dundee");
        Social = new SocialNetwork();


    }
    SocialNetwork Social;
    private static boolean running = true;
    private User MainUser;
    /**
    *Profile method for displaying infomation about the users profile to the user.
 */
    public void profile()
    {

        //flushes the screen so that  it looks nicer
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
        
        
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
        for(int i=0; i > PostList.posts.size(); i++ )
        {
            System.out.println(PostList.posts);
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
                ViewMyFriends();
            }
            break;
        }
    }
/**
*Method to view friends of the user. 
 */
    public void ViewMyFriends()


    //show a list of all the main users friends
    public boolean ViewMyFriends()
    {
        boolean loaded = false;
        String friendsFile = MainUser.getUserID() + " friends.txt";
        try 
        {
            Set<String> Friends = Social.loadFriends(friendsFile);
            System.out.println(Friends);
            loaded = true;
        }
        catch(IOException e)
        {
            System.out.println("Failed to load");
            e.printStackTrace();
        }

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
/**
*Method to allow for testing of the program. Is the acting menu selection.
 */

    public void test()
    {
        while(running)
        {
            System.out.print("\033[H\033[2J");  
            System.out.flush();  
            Scanner scan1 = new Scanner(System.in);
            System.out.println("To view your profile press 1: ");
            System.out.println("To view your friends list press 2: ");
            System.out.println("To exit the Social Network press 3: ");

            int ans = scan1.nextInt();
    
            switch(ans)
            {
                case (1):
                {
                    profile();
                }
                break;

                case (2): 
                {
                    ViewMyFriends();
                }
                break;
                
                case (3): 
                {
                    running = false;
                }
                break;

            }
        }

    }

/**
*Main method
*@peram String[] args
 */
    public static void main(String[] args)
    {
        Menu menu = new Menu();
        menu.test();
    }
}