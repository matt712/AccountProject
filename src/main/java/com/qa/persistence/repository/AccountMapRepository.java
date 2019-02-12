package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;
import com.qa.util.*;

import com.qa.persistence.domain.Account;

public class AccountMapRepository implements AccountRepository{
	
	Map<Long, Account> accountMap = new HashMap<Long, Account>();
	private JSONUtil util = new JSONUtil();
	
	//You must provide concrete implementation for each of these methods
	//do not change the method signature

	public String getAllAccounts() {
		// TODO Auto-generated method stub
		return util.getJSONForObject(accountMap.values());
	}

	public String createAccount(String account) {
		Account newAccount = util.getObjectForJSON(account, Account.class);
		accountMap.put(newAccount.getId(), newAccount);
		return "Account created";
	}

	public String deleteAccount(Long id) {
		// TODO Auto-generated method stub
		accountMap.remove(id);
		return "Account deleted";
	}

	public String updateAccount(Long id, String account) {
		Account updatedAccount = util.getObjectForJSON(account, Account.class);
		accountMap.remove(id);
		accountMap.put(id, updatedAccount);
		return "Account updated.";
	}

}
