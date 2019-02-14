package com.qa.businessTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.service.ServiceImplementation1;
import com.qa.persistence.repository.AccountRepository;

@RunWith(MockitoJUnitRunner.class)
public class BusinessTest {

	private static final String MOCK_OBJECT1 = "{\"id\":9,\"accNumber\":123458,\"FirstName\":\"Bob\",\"LastName\":\"Davey\"}";
	private static final String MOCK_OBJECT2 = "{\"id\":2,\"accNumber\":123458,\"FirstName\":\"Bob\",\"LastName\":\"Davey\"}";
	private static final String MOCK_VALUE2 = "test_value_2";
	private static final String MOCK_VALUE = "\"{\\\"message\\\": \\\"This account is blocked\\\"}\"";
	private static final Long MOCK_ID = (long) 1;
	
	@InjectMocks 
	private ServiceImplementation1 serv;
	@Mock
	private AccountRepository repo;
	@Before
	public void setUp()
	{
		serv.setRepo(repo);
	}
	@Ignore
	public void testAccountCreation()
	{
		Mockito.when(repo.createAccount(MOCK_OBJECT2)).thenReturn(MOCK_VALUE2);
		assertEquals(MOCK_VALUE2, serv.addAccount(MOCK_OBJECT2));
		Mockito.verify(serv).addAccount(MOCK_VALUE);
		assertEquals(MOCK_VALUE, serv.addAccount(MOCK_OBJECT1));
		Mockito.verify(repo).createAccount(MOCK_OBJECT1);
	}
	@Test
	public void testGetAllAcc()
	{
		Mockito.when(repo.getAllAccounts()).thenReturn(MOCK_OBJECT2);
		assertEquals(MOCK_OBJECT2, serv.getAllAccounts());
		Mockito.verify(repo).getAllAccounts();
	}
	@Test
	public void testGetAnAccount()
	{
		Mockito.when(repo.getAnAccount(MOCK_ID)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, serv.getAnAccount(MOCK_ID));
		Mockito.verify(repo).getAnAccount(MOCK_ID);
	}
	@Test
	public void testUpdateAccount()
	{
		Mockito.when(repo.updateAccount(MOCK_ID, MOCK_OBJECT1)).thenReturn(MOCK_VALUE2);
		assertEquals(MOCK_VALUE2, serv.updateAccount(MOCK_ID, MOCK_OBJECT1));
		Mockito.verify(repo).updateAccount(MOCK_ID, MOCK_OBJECT1);
	}
	@Test
	public void testDeleteAccount()
	{
		Mockito.when(repo.deleteAccount(MOCK_ID)).thenReturn(MOCK_VALUE2);
		assertEquals(MOCK_VALUE2, serv.deleteAccount(MOCK_ID));
		Mockito.verify(repo).deleteAccount(MOCK_ID);
	}
}
