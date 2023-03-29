package final_project;
import java.util.*;
import java.io.*;


public class Menu
{

    public Menu(){
        MainUser = new User("JK12", "MainMan", "UoD", "Dundee");
        Social = new SocialNetwork();


    }
    SocialNetwork Social;
    private static boolean running = true;
    private User MainUser;
    public void profile()
    {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        System.out.println("To exit and go back to the menu press 1: ");
        System.out.println(MainUser.getName() + "             " + MainUser.getUserID());
        System.out.println("I live in " + MainUser.getHometown());
        System.out.println("I work at " + MainUser.getWorkplace());
        System.out.println();
        ReadingPostsFromFile PostList = new ReadingPostsFromFile();
        try {
            PostList.readFromFile(MainUser.getUserID());
        } catch (IOException e) {
            System.out.println("failed to load posts ");
        }
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
        return loaded;
    }

    
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


    public static void main(String[] args)
    {
        Menu menu = new Menu();
        menu.test();
    }
}