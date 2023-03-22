package final_project;
import java.util.*;
import java.io.*;


public class Menu
{

    public void profile()
    {
        System.out.println(User.getName() + "\t" + User.getUserID());
        System.out.println(User.getHometown() +"\t"+User.getWorkplace());
    }

    public void friends(){
        //
    }

    public void posts(){
        //
    }


    public static void main(String[] args)
    {
        //setup goes here. Initiating users ect.

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