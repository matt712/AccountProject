package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountRepository;
import com.qa.util.JSONUtil;

public class ServiceImplementation1 implements Service 
{
	@Inject
	private AccountRepository repo;
	@Inject
	private JSONUtil util;

	@Override
	public String addAccount(String account) {
		Account newAccount = util.getObjectForJSON(account, Account.class);
		if(newAccount.getId() == 9)
		{
			return "{\"message\": \"This account is blocked\"}";
		}
		else
		{
			return repo.createAccount(account);
		}
	}

	@Override
	public String getAllAccounts() {
		return repo.getAllAccounts();
	}

	@Override
	public String getAnAccount(Long id) {
		return repo.getAnAccount(id);
	}

	@Override
	public String updateAccount(Long id, String account) {
		return repo.updateAccount(id, account);
	}

	@Override
	public String deleteAccount(Long id) {
		return repo.deleteAccount(id);
	}

}
