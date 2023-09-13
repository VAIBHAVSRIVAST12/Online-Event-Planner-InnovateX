package com.inovatex.user.service;

import java.util.HashMap;
import java.util.List;

import com.inovatex.user.beans.PlanRequest;
import com.inovatex.user.beans.User;
import com.inovatex.user.dao.UserDao;
import com.inovatex.user.dao.UserDaoImpl;
import com.inovatex.user.exceptions.PlanRequestNotFoundExceptions;
import com.inovatex.user.exceptions.UserAlreadyExistsException;
import com.inovatex.user.exceptions.UserNotFoundExceptions;
import com.inovatex.user.exceptions.UserWrongPasswordException;

public class UserServiceImpl implements UserService{
	UserDao userDao = new UserDaoImpl();
	@Override
	public int addUser(User user) throws UserAlreadyExistsException {
		
		return userDao.addUser(user);
	}
	@Override
	public int changePassword(String username, String password) throws UserNotFoundExceptions {
		
		return userDao.changePassword(username, password);
	}
	@Override
	public int changeStatus(String username, String status) throws UserNotFoundExceptions {
		
		return userDao.changeStatus(username, status);
	}
	@Override
	public int deleteUser(String username) throws UserNotFoundExceptions {
		
		return userDao.deleteUser(username);
	}
	@Override
	public User getUserByUsername(String username) throws UserNotFoundExceptions {
		
		return userDao.getUserByUsername(username);
	}
	@Override
	public List<User> allUser() throws UserNotFoundExceptions {
		
		return userDao.allUser();
	}
	@Override
	public boolean validateUser(String username, String userPassword) throws UserNotFoundExceptions, UserWrongPasswordException {
		try {
			User user = getUserByUsername(username);
			if(user.getUserPassword().equals(userPassword)) {
				return true;
			}
			else {
				throw new UserWrongPasswordException();
			}
		} catch (UserNotFoundExceptions e) {
			throw new UserNotFoundExceptions();
		}

	}
	@Override
	public HashMap<String, String> viewProfile(String username) throws UserNotFoundExceptions {
		HashMap<String, String> userProfile = new HashMap<>();
		try {
				User user = getUserByUsername(username);
				
				userProfile.put("Fullname",user.getUserFullName());
				userProfile.put("username",user.getUsername());
				userProfile.put("DateOfJoining",user.getUserDateOfJoining().toString());
				userProfile.put("DateOfBirth",user.getUserDateOfJoining().toString());
				userProfile.put("Department",user.getUserDepartment());
				userProfile.put("Mobile",user.getUserMobile());
				userProfile.put("Email",user.getUserEmail());
				userProfile.put("Location",user.getUserLocation());
				userProfile.put("Status",user.getUserStatus());
				return userProfile;
		}
		catch (UserNotFoundExceptions e) {
			throw new UserNotFoundExceptions();
		}
	}
	@Override
	public int getUserIdByUsername(String username) throws UserNotFoundExceptions {
		
		return userDao.getUserIdByUsername(username);
	}
	@Override
	public int addPlanRequest(PlanRequest planRequest, int userId) {
	
		return userDao.addPlanRequest(planRequest, userId);
	}

	@Override
	public int deletePlanRequest(int requestId) throws PlanRequestNotFoundExceptions {
		
		return userDao.deletePlanRequest(requestId);
	}

	@Override
	public List<PlanRequest> allRequest() throws PlanRequestNotFoundExceptions {
		
		return userDao.allRequest();
	}

}
