package com.inovatex.planrequest.beans;

import java.time.LocalDate;
import java.util.Objects;

public class PlanRequest {
	private int requestId;
    private LocalDate requestFromDate;
    private LocalDate requestToDate;
    private String requestServicesNeeded;
    private int requestNumberOfPersons;
    private String requestOtherServices;
    private int userId;
    
    public PlanRequest( LocalDate requestFromDate, LocalDate requestToDate, String requestServicesNeeded,
			int requestNumberOfPersons, String requestOtherServices) {
		
		this.requestFromDate = requestFromDate;
		this.requestToDate = requestToDate;
		this.requestServicesNeeded = requestServicesNeeded;
		this.requestNumberOfPersons = requestNumberOfPersons;
		this.requestOtherServices = requestOtherServices;
		
	}
	public PlanRequest() {
		super();
	}
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public LocalDate getRequestFromDate() {
		return requestFromDate;
	}
	public void setRequestFromDate(LocalDate requestFromDate) {
		this.requestFromDate = requestFromDate;
	}
	public LocalDate getRequestToDate() {
		return requestToDate;
	}
	public void setRequestToDate(LocalDate requestToDate) {
		this.requestToDate = requestToDate;
	}
	public String getRequestServicesNeeded() {
		return requestServicesNeeded;
	}
	public void setRequestServicesNeeded(String requestServicesNeeded) {
		this.requestServicesNeeded = requestServicesNeeded;
	}
	public int getRequestNumberOfPersons() {
		return requestNumberOfPersons;
	}
	public void setRequestNumberOfPersons(int requestNumberOfPersons) {
		this.requestNumberOfPersons = requestNumberOfPersons;
	}
	public String getRequestOtherServices() {
		return requestOtherServices;
	}
	public void setRequestOtherServices(String requestOtherServices) {
		this.requestOtherServices = requestOtherServices;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(requestFromDate, requestId, requestNumberOfPersons, requestOtherServices,
				requestServicesNeeded, requestToDate, userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlanRequest other = (PlanRequest) obj;
		return Objects.equals(requestFromDate, other.requestFromDate) && requestId == other.requestId
				&& requestNumberOfPersons == other.requestNumberOfPersons
				&& Objects.equals(requestOtherServices, other.requestOtherServices)
				&& Objects.equals(requestServicesNeeded, other.requestServicesNeeded)
				&& Objects.equals(requestToDate, other.requestToDate) && userId == other.userId;
	}
	@Override
	public String toString() {
		return "PlanRequest [requestId=" + requestId + ", requestFromDate=" + requestFromDate + ", requestToDate="
				+ requestToDate + ", requestServicesNeeded=" + requestServicesNeeded + ", requestNumberOfPersons="
				+ requestNumberOfPersons + ", requestOtherServices=" + requestOtherServices + ", userId=" + userId
				+ "]";
	}
	
}
