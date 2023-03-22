package final_project;
import java.util.*;
import java.io.*;


public class Menu
{

    public void profile()
    {
        System.out.println(mainUser.getName() + "\t" + mainUser.getUserID());
        System.out.println(mainUser.getHometown() +"\t"+ mainUser.getWorkplace());
    }

    public void friends(){
        //
    }

    public void posts(){
        //
    }


    public static void main(String[] args)
    {
        mainUser = new User(11, "Jacob", "Generic Shop", "Dundee"); // only for testing to be replaced by leading from file.
        //not sure when the SocialNetwork class needs to be initiated?

        //setup goes here. Initiating users ect.
        //initally load from file to get basic set of users.
        menu();
    }

    public void menu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("To view your profile press 1: ");
        System.out.println("To view your friends list press 2: ");
        System.out.println("To view your posts press 3: ");
        int ans = scan.nextInt();
        switch(ans){
            case 1:
            profile();
            break;

            case 2:
            friends();
            //friend list
            break;

            case 3:
            posts();
            //posts
            break;
        }
    }
}