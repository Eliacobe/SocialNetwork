package final_project;
import java.util.LinkedList;

public class ProfileList {
	private LinkedList<User> friends = new LinkedList<User>();
	
	public ProfileList() {
		
	}

	public void addFriend(User friend) {
		friends.add(friend);
		
	}
	
	public User findFriend(String friendToFind) {
		User finding;
		for(int i =0; i < friends.size(); i++){
			 finding = friends.get(i);
			 if (finding.getUserID() == friendToFind){
				return finding;
			 }
		}
		return null;
	}
	
	public boolean removeFriend() {
		return false;
		
	}
	
}
