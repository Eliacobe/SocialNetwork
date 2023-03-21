package final_project;
import java.util.*;
import java.io.*;


public class Menu
{

    public void profile()
    {
        System.out.println(User.getName() + "             " + User.getUserID());
    }


    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("To view your profile press 1: ");
        System.out.println("To view your friends list press 2: ");
        System.out.println("To view your posts press 3: ");
        int ans = scan.nextInt();

        if(ans == 1)
        {
            profile();
        }
    }
}