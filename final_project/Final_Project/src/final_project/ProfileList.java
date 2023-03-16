package final_project;
import java.util.LinkedList;

public class ProfileList {
	private LinkedList<User> friends = new LinkedList<User>();
	
	public ProfileList() {
		
	}
	
	public void addFriend(User friend) {
		friends.add(friend);
		
	}
	
	public User findFriend() {
		User firstFriend = friends.getFirst();
		int sze = friends.size();
		for(int i = 0; i < sze ; i++){
			if 
		}
	}
	
	public boolean removeFriend() {
		
	}
	
}
