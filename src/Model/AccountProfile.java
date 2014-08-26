package Model;

import java.util.Date;

public class AccountProfile {
	
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private Date birthday;
	private char sex;
	private String securityAnswer;
	private double heightInches;
	private String password;
	private double goalWeight;
	
	
	
	public AccountProfile(String username, String firstName, String lastName,
			String email, Date birthday, char sex, String securityAnswer,
			double heightInches, String password, double goalWeight) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.birthday = birthday;
		this.sex = sex;
		this.securityAnswer = securityAnswer;
		this.heightInches = heightInches;
		this.password = password;
		this.goalWeight = goalWeight;
	}
	
	public AccountProfile() {
		
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}

	public String getSecurityAnswer() {
		return securityAnswer;
	}
	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}
	public double getHeightInches() {
		return heightInches;
	}
	public void setHeightInches(double heightInches) {
		this.heightInches = heightInches;
	}

	public double getGoalWeight()
	{
		return this.goalWeight;
	}
	
	public void setGoalWeight(double goalWeight)
	{
		this.goalWeight = goalWeight;
	}
	@Override
	public String toString() {
		return "AccountProfile [username=" + username + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email
				+ ", birthday=" + birthday + ", sex=" + sex
				+ ", securityAnswer=" + securityAnswer + ", heightInches="
				+ heightInches + ", password=" + password + "]";
	}

	
	

	}
