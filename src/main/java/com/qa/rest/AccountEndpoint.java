package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.apache.log4j.Logger;
import com.qa.business.service.Service;

@Path("/account")
public class AccountEndpoint {

	@Inject
	private Service service;
	//C
	@Path("/createAccount")
	@POST
	@Produces({ "application/json" })
	public String addAccount(String account) {
		return service.addAccount(account);
	}
	//R
	@Path("/getAllAccounts")
	@GET
	@Produces("application/json")
	public String getAllAccounts(){
		return service.getAllAccounts();
	}
	@Path("/getAnAccount/{id}")
	@GET
	@Produces({ "application/json" })
	public String getAnAccount(@PathParam("id") Long id) {
		return service.getAnAccount(id);
	}
	//U
	@Path("/updateAccount/{id}")
	@PUT
	@Produces({"application/json"})
	public String updateAccount(@PathParam("id") Long id, String account) {
		return service.updateAccount(id, account);
	}
	//D
	@Path("/deleteAccount/{id}")
	@DELETE
	@Produces({"application/json"})
	public String deleteAccount(@PathParam("id") Long id){
		return service.deleteAccount(id);
	}
	public void setService(Service service){
		this.service = service;
	}
}
