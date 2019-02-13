package com.qa.business.service;

public interface Service {
	//C
	String addAccount(String account);
	//R
	String getAllAccounts();
	String getAnAccount(Long id);
	//U
	String updateAccount(Long id, String account);
	//D
	String deleteAccount(Long id);
}
