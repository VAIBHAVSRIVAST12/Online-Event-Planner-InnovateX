package com.inovatex.planrequest.service;

import java.util.List;

import com.inovatex.planrequest.beans.PlanRequest;
import com.inovatex.planrequest.exceptions.PlanRequestNotFoundExceptions;

public interface PlanRequestService {
	int addPlanRequest(PlanRequest planRequest, int userId);
	int deletePlanRequest (int requestId)throws PlanRequestNotFoundExceptions;
	List<PlanRequest> allRequest()throws PlanRequestNotFoundExceptions;
}
