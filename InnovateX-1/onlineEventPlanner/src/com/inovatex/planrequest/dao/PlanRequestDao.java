package com.inovatex.planrequest.dao;

import java.util.List;

import com.inovatex.planrequest.beans.PlanRequest;
import com.inovatex.planrequest.exceptions.PlanRequestNotFoundExceptions;

public interface PlanRequestDao {
	int addPlanRequest(PlanRequest planRequest, int userId);
	int deletePlanRequest (int requestId)throws PlanRequestNotFoundExceptions;
	List<PlanRequest> allRequest()throws PlanRequestNotFoundExceptions;
}
