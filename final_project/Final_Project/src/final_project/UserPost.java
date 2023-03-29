package final_project;
/**
*UserPost Class. has the users posts
 */
public class UserPost {
	private String postID;
	private String userID;
	private String content;
	private int likes;
	/**
	*cosnstuctor method for UserPost, for setting all perams
	*@peram String postID
	*@peram String userID
	*@peram String content
	*@peram int likes
 */

	public UserPost(String postID, String userID, String content, int likes){
		this.postID = postID;
		this.userID = userID;
		this.content = content;
		this.likes = likes;
	}
	/**
	*constructor for setting perams but not including likes
	*@peram String postID
	*@peram String userID
	*@peram String content
 */

	public UserPost(String postID, String userID, String content){
		this.postID = postID;
		this.userID = userID;
		this.content = content;
		likes = 0;

		}
	/**
	*getter method for postID
	*@return String postID
 */
	public String getPostID() {
		return postID;
	}
	/**
	*setter method for postID
	*@peram String postID
 */
	public void setPostID(String postID) {
		this.postID = postID;
	}
	/**
		*getter method for userID
	*@return String userID
 */
	public String getUserID() {
		return userID;
	}
	/**
		*setter method for userID
	*@peram String userID
 */

	public void setUserID(String userID) {
		this.userID = userID;
	}
	/**
		*getter method for content
	*@return String content
 */
	public String getContent() {
		return content;
	}
	/**
		*setter method for content
	*@peram String content
 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
		*getter method for likes
	*@return int likes
 */
	public int getLikes() {
		return likes;
	}
	/**
* adds 1 like to the post
 */
	public void addLikes() {
		likes+=1;
	}

}
