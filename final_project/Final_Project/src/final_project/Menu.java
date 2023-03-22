package final_project;
import java.util.*;
import java.io.*;


public class Menu
{

    private static boolean running = true;


    public static void profile()
    {
        System.out.println("To exit and go back to the menu press 1: ");
        System.out.println(User.getName() + "             " + User.getUserID());
        System.out.println("I live in " + User.getHometown);
        System.out.println("I work at " + User.getWorkplace);
        System.out.println();
        System.out.println();
        System.out.println("If you would like to view your friends list press 2: ");
       
        Scanner scan = new Scanner(System.in);
        int ans = scan.nextInt();

        switch(ans)
        {
            case 1: 
            {
                System.out.println("Exiting");
            }

            case 2: 
            {
                ViewMyFriends();
            }
        }
    }

    public static void ViewMyFriends()
    {
        list<User> Friends = SocialNetwork.getMyFriends();

    }


    public static void main(String[] args)
    {

        // User MainUser = User("JK12", "MainMan", "UoD", "Dundee");
        while(running)
        {
            Scanner scan = new Scanner(System.in);
            System.out.println("To view your profile press 1: ");
            System.out.println("To view your friends list press 2: ");
            System.out.println("To view your posts press 3: ");
            System.out.println("To exit the Social Network press 4: ");

            int ans = scan.nextInt();
    
            switch(ans)
            {
                case 1:
                {
                    profile();
                }

                case 2: 
                {
                    ViewMyFriends();
                }
    
    
                
                case 4: 
                {
                    running = false;
                }

            }
        }

    }
}