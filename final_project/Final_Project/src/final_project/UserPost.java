package final_project;

public class UserPost {
	private String postID;
	private String userID;
	private String content;
	private int likes;
	
	public UserPost(String postID, String userID, String content, int likes){
		this.postID = postID;
		this.userID = userID;
		this.content = content;
		this.likes = likes;
	}
	public UserPost(String postID, String userID, String content){
		this.postID = postID;
		this.userID = userID;
		this.content = content;
		likes = 0;

		}
	
	public String getPostID() {
		return postID;
	}
	public void setPostID(String postID) {
		this.postID = postID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
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

	public void addLikes(){
		likes += 1;
	}
	
	
}
