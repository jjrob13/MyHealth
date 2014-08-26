package Model;

import java.util.*;

public class Authentication {
	private boolean isLocked;
	private String userName;
	private int userID;
	private Date lastActive;
	public Authentication(boolean isLocked, String userName, int userID,
			Date lastActive) {
		super();
		this.isLocked = isLocked;
		this.userName = userName;
		this.userID = userID;
		this.lastActive = lastActive;
	}
	
	
	public Authentication(String userName) {
		super();
		this.userName = userName;

		this.isLocked = true;
		this.userName = userName;
		this.userID = -1;
		this.lastActive = new Date(System.currentTimeMillis());
	}


	public Authentication() {
		this.isLocked = true;
		this.userID = -1;
		this.lastActive = new Date(System.currentTimeMillis());
	}


	public boolean isLocked() {
		return isLocked;
	}
	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public Date getLastActive() {
		return lastActive;
	}
	public void setLastActive(Date lastActive) {
		this.lastActive = lastActive;
	}
	@Override
	public String toString() {
		return "Authentication [isLocked=" + isLocked + ", userName="
				+ userName + ", userID=" + userID + ", lastActive="
				+ lastActive + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + userID;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Authentication other = (Authentication) obj;
		if (userID != other.userID)
			return false;
		return true;
	}

	
}
