package com.inovatex.user.service;

import java.util.HashMap;
import java.util.List;

import com.inovatex.user.beans.PlanRequest;
import com.inovatex.user.beans.User;
import com.inovatex.user.exceptions.PlanRequestNotFoundExceptions;
import com.inovatex.user.exceptions.UserAlreadyExistsException;
import com.inovatex.user.exceptions.UserNotFoundExceptions;
import com.inovatex.user.exceptions.UserWrongPasswordException;

public interface UserService {
	int addUser (User user) throws UserAlreadyExistsException;
	int changePassword(String username,String password) throws UserNotFoundExceptions;
	int changeStatus(String username, String status) throws UserNotFoundExceptions;
	int deleteUser (String username)throws UserNotFoundExceptions;
	User getUserByUsername(String username)throws UserNotFoundExceptions;
	int getUserIdByUsername(String username)throws UserNotFoundExceptions;
	
	int addPlanRequest(PlanRequest planRequest, int userId);
	int deletePlanRequest (int requestId)throws PlanRequestNotFoundExceptions;
	List<PlanRequest> allRequest()throws PlanRequestNotFoundExceptions;
	
	List<User> allUser()throws UserNotFoundExceptions;
	boolean validateUser(String username,String userPassword) throws UserNotFoundExceptions, UserWrongPasswordException;
	HashMap<String, String> viewProfile(String username) throws UserNotFoundExceptions;
}
