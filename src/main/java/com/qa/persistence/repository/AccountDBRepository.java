package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@Default
@Transactional(SUPPORTS)
public class AccountDBRepository implements AccountRepository{

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	@Inject
	private JSONUtil util;
	@Override
	public String getAllAccounts() {
		Query query = em.createQuery("Select a FROM Account a");
		Collection<Account> accounts = (Collection<Account>) query.getResultList();
		return util.getJSONForObject(accounts);
	}
	@Override
	@Transactional(REQUIRED)
	public String createAccount(String account) {
		Account anAccount = util.getObjectForJSON(account, Account.class);
		em.persist(account);
		return "{\"message\": \"Account created\"}";
	}
	@Override
	public String getAnAccount(Long id)
	{
		return util.getJSONForObject(em.find(Account.class, id));
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteAccount(Long id) {
		Account accountDeletable = util.getObjectForJSON(getAnAccount(id), Account.class);
		if(em.contains(accountDeletable))
		{
			em.remove(accountDeletable);
		}
		return "{\"message\": \"Account succesfully removed\"}";
	}
	@Override
	@Transactional
	public String updateAccount(Long id, String account) {
		deleteAccount(id);
		createAccount(account);
		return "{\"message\": \"Account updated\\\"}";
	}
	public void setEm(EntityManager entManage)
	{
		this.em=entManage;
	}
	public void setUTIL(JSONUtil utility)
	{
		this.util=utility;
	}

}
