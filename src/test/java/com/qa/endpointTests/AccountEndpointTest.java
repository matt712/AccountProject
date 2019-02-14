package com.qa.endpointTests;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import com.qa.business.service.Service;
import com.qa.rest.AccountEndpoint;

@RunWith(MockitoJUnitRunner.class)
public class AccountEndpointTest 
{
	private static final String MOCK_VALUE2 = "test_value_2";
	private static final String MOCK_VALUE = "test_value";
	private static final Long MOCK_ID = (long) 1;
	@InjectMocks
	private AccountEndpoint ender;
	@Mock
	private Service serv;
	
	@Before
	public void setUp()
	{
		ender.setService(serv);
	}
	@Test
	public void testCreateAcc()
	{
		Mockito.when(serv.addAccount(MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, ender.addAccount(MOCK_VALUE2));
		Mockito.verify(serv).addAccount(MOCK_VALUE2);
	}
	@Test
	public void testGetAllAcc()
	{
		Mockito.when(serv.getAllAccounts()).thenReturn(MOCK_VALUE2);
		assertEquals(MOCK_VALUE2, ender.getAllAccounts());
		Mockito.verify(serv).getAllAccounts();
	}
	@Test
	public void testGetSpecificAcc()
	{
		Mockito.when(serv.getAnAccount(MOCK_ID)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, ender.getAnAccount(MOCK_ID));
		Mockito.verify(serv).getAnAccount(MOCK_ID);
	}
	@Test
	public void testUpdate()
	{
		Mockito.when(serv.updateAccount(MOCK_ID, MOCK_VALUE)).thenReturn(MOCK_VALUE2);
		assertEquals(MOCK_VALUE2, ender.updateAccount(MOCK_ID,  MOCK_VALUE));
		Mockito.verify(serv).updateAccount(MOCK_ID, MOCK_VALUE);
	}
	@Test
	public void testDelete()
	{
		Mockito.when(serv.deleteAccount(MOCK_ID)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, ender.deleteAccount(MOCK_ID));
		Mockito.verify(serv).deleteAccount(MOCK_ID);
	}
}
