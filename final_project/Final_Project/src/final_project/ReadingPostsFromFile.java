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

    public void readFromFile(String filename) throws FileNotFoundException, IOException
    {
        String file = filename + ".txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(file)))
        {
            String line;
            try {
                while ((line = reader.readLine()) != null)
                {
                    String[] fields = line.split(",");
                    String postID = fields[0];
                    String content = fields[1];
                    int likes = Integer.parseInt(fields[2]);
                    UserPost post = new UserPost(postID, filename, content, likes);
                    posts.add(post); 
                }
            } catch (NumberFormatException e) {
            } catch (IOException e) {
            }
        }
    }
}