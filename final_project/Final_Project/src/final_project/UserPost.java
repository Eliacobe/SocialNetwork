package final_project;

public class UserPost {
	private int postID;
	private int userID;
	private String content;
	private int likes;
	
	public UserPost(int postID, int userID, String content, int likes){
		this.postID = postID;
		this.userID = userID;
		this.content = content;
		this.likes = likes;
	}
	public UserPost(int postID, int userID, String content){
		this.postID = postID;
		this.userID = userID;
		this.content = content;
		likes = 0;
		}
	
	public int getPostID() {
		return postID;
	}
	public void setPostID(int postID) {
		this.postID = postID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getLikes() {
		return likes;
	}
	public void addLikes() {
		likes+=1;
	}
	
	
}
