package final_project;
import java.util.*;
import java.io.*;


public class ReadingPostsFromFile
{
    public List<UserPost> posts;
    public ReadingPostsFromFile()
    {
        this.posts = new ArrayList<>();
    }

    public void readFromFile(String filename) throws IOException
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                String[] fields = line.split(",");
                String postID = fields[0];
                String content = fields[1];
                int likes = Integer.parseInt(fields[2]);
                UserPost post = new UserPost(postID, filename, content, likes);
                posts.add(post); //needs to arraylist(?) in user to store their posts 
            }
        }
    }
}