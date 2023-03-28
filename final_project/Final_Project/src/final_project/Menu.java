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
        System.out.println("To exit and go back to the menu press 1: ");
        System.out.println(MainUser.getName() + "             " + MainUser.getUserID());
        System.out.println("I live in " + MainUser.getHometown());
        System.out.println("I work at " + MainUser.getWorkplace());
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

    public void ViewMyFriends()
    {
        String afile = "socialNetworkTest.txt";
        try {
            Social.loadFromFile(afile);
        } catch (IOException e) {
        }
        List<User> Friends = Social.getMyFriends(MainUser.getUserID());
        System.out.println(Friends);
    }

    
    public void test()
    {
        while(running)
        {
            Scanner scan = new Scanner(System.in);
            System.out.println("To view your profile press 1: ");
            System.out.println("To view your friends list press 2: ");
            System.out.println("To exit the Social Network press 3: ");

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
                
                case 3: 
                {
                    running = false;
                }

            }
        }

    }


    public static void main(String[] args)
    {
        Menu menu = new Menu();
        menu.test();
    }
}