package com.qa.DBTests;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountDBRepository;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class AccountDBRepoTest {

	@InjectMocks
	private AccountDBRepository repo;
	@Mock
	private EntityManager em;
	@Mock
	private Query query;
	private JSONUtil util;
	private static final String MOCK_DATA_ARRAY = "[{\"id\":2,\"accNumber\":123458,\"FirstName\":\"Bob\",\"LastName\":\"Davey\"}]";
	private static final String MOCK_OBJECT = "{\"id\":2,\"accNumber\":123458,\"FirstName\":\"Bob\",\"LastName\":\"Davey\"}";
	private static final Long MOCK_ID = (long) 2;
	@Before
	public void setUp() 
	{
		repo.setEm(em);
		util = new JSONUtil();
		repo.setUTIL(util);
	}
	@Test
	public void testGetAllAccounts()
	{
		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(query);
		List<Account> accounts = new ArrayList<Account>();
		accounts.add(new Account(MOCK_ID, 123458, "Bob", "Davey"));
		Mockito.when(query.getResultList()).thenReturn(accounts);
		Assert.assertEquals(MOCK_DATA_ARRAY, repo.getAllAccounts());
	}
	@Test
	public void testGetAnAccount()
	{
		Mockito.when(em.find(Account.class, MOCK_ID)).thenReturn(util.getObjectForJSON(MOCK_OBJECT, Account.class));
		Assert.assertEquals(MOCK_OBJECT, repo.getAnAccount(MOCK_ID));
	}
	@Test
	public void testCreateAccount()
	{
		String reply = repo.createAccount(MOCK_OBJECT);
		Assert.assertEquals(reply, "{\"message\": \"Account created\"}");
	}
	@Test
	public void testDeleteMovie()
	{
		String reply = repo.deleteAccount(1L);
		Assert.assertEquals(reply, "{\"message\": \"Account successfully removed\"}");
	}
}
