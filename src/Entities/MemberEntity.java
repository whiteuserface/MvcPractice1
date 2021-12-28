package Entities;
import java.util.Date;
public class MemberEntity {
	
	
	private String userId;
	private String userPassword;
	private String userNickName;
	
	
	/**
	 * @param userId
	 * @param userPassword
	 * @param userNickName
	 */
	
	public MemberEntity(String userId, String userPassword, String userNickName) {
		
		this.userId = userId;
		this.userPassword = userPassword;
		this.userNickName = userNickName;
		
	}
	
	
	
	@Override
	public String toString() {
		return "MemberEntity [userId=" + userId + ", userPassword=" + userPassword + ", userNickName=" + userNickName
				+ "]";
	}


	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserNickName() {
		return userNickName;
	}
	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

	

	
}
