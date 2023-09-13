package com.inovatex.user.beans;

import java.time.LocalDate;
import java.util.Objects;

public class User {
	private int userId;
	private String userFullName;
	private String username;
	private String userPassword;
	private LocalDate userDateOfJoining;
	private LocalDate userDateOfBirth;
	private String userDepartment;
	private String userMobile;
	private String userEmail;
	private String userLocation;
	private String userStatus;
	private int quotationSelectedId;
	public User() {
		
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userFullName=" + userFullName + ", username=" + username
				 + ", userDateOfJoining=" + userDateOfJoining + ", userDateOfBirth="
				+ userDateOfBirth + ", userDepartment=" + userDepartment + ", userMobile=" + userMobile + ", userEmail="
				+ userEmail + ", userLocation=" + userLocation + ", userStatus=" + userStatus + ", quotationSelectedId="
				+ quotationSelectedId + "]";
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

    
    public User(String userFullName, String username, String userPassword, LocalDate userDateOfJoining,
			LocalDate userDateOfBirth, String userDepartment, String userMobile, String userEmail, String userLocation) {
		
		this.userFullName = userFullName;
		this.username = username;
		this.userPassword = userPassword;
		this.userDateOfJoining = userDateOfJoining;
		this.userDateOfBirth = userDateOfBirth;
		this.userDepartment = userDepartment;
		this.userMobile = userMobile;
		this.userEmail = userEmail;
		this.userLocation = userLocation;
		this.userStatus = "non-active";
		this.quotationSelectedId = 0;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public LocalDate getUserDateOfJoining() {
		return userDateOfJoining;
	}

	public void setUserDateOfJoining(LocalDate userDateOfJoining) {
		this.userDateOfJoining = userDateOfJoining;
	}

	public LocalDate getUserDateOfBirth() {
		return userDateOfBirth;
	}

	public void setUserDateOfBirth(LocalDate userDateOfBirth) {
		this.userDateOfBirth = userDateOfBirth;
	}

	public String getUserDepartment() {
		return userDepartment;
	}

	public void setUserDepartment(String userDepartment) {
		this.userDepartment = userDepartment;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserLocation() {
		return userLocation;
	}

	public void setUserLocation(String userLocation) {
		this.userLocation = userLocation;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public int getQuotationSelectedId() {
		return quotationSelectedId;
	}

	public void setQuotationSelectedId(int quotationSelectedId) {
		this.quotationSelectedId = quotationSelectedId;
	}

	public int getUserId() {
		return userId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(quotationSelectedId, userDateOfBirth, userDateOfJoining, userDepartment, userEmail,
				userFullName, userId, userLocation, userMobile, userPassword, userStatus, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return quotationSelectedId == other.quotationSelectedId
				&& Objects.equals(userDateOfBirth, other.userDateOfBirth)
				&& Objects.equals(userDateOfJoining, other.userDateOfJoining)
				&& Objects.equals(userDepartment, other.userDepartment) && Objects.equals(userEmail, other.userEmail)
				&& Objects.equals(userFullName, other.userFullName) && userId == other.userId
				&& Objects.equals(userLocation, other.userLocation) && Objects.equals(userMobile, other.userMobile)
				&& Objects.equals(userPassword, other.userPassword) && Objects.equals(userStatus, other.userStatus)
				&& Objects.equals(username, other.username);
	}

	
    
}
