package com.inovatex.planrequest.service;

import java.util.List;

import com.inovatex.planrequest.beans.PlanRequest;
import com.inovatex.planrequest.dao.PlanRequestDao;
import com.inovatex.planrequest.dao.PlanRequestDaoImpl;
import com.inovatex.planrequest.exceptions.PlanRequestNotFoundExceptions;

public class PlanRequestServiceImpl implements PlanRequestService {
	PlanRequestDao planRequestDao = new PlanRequestDaoImpl();
	@Override
	public int addPlanRequest(PlanRequest planRequest, int userId) {
	
		return planRequestDao.addPlanRequest(planRequest, userId);
	}

	@Override
	public int deletePlanRequest(int requestId) throws PlanRequestNotFoundExceptions {
		
		return planRequestDao.deletePlanRequest(requestId);
	}

	@Override
	public List<PlanRequest> allRequest() throws PlanRequestNotFoundExceptions {
		
		return planRequestDao.allRequest();
	}

}
