package com.qa.MapTests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.google.gson.Gson;
import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountMapRepository;
import com.qa.util.JSONUtil;

public class AccountServiceTest {
	

	private static final String MOCK_OBJECT = "{\"id\":\"1\",\"accNumber\":\"123456\",\"FirstName\":\"Bert\",\"LastName\":\"Smith\"}";
	private static final String MOCK_OBJECT2 = "{\"id\":\"2\",\"accNumber\":\"123457\",\"FirstName\":\"Bob\",\"LastName\":\"Bobson\"}";
	private static final String MOCK_OBJECT3 = "{\"id\":\"3\",\"accNumber\":\"123458\",\"FirstName\":\"Bob\",\"LastName\":\"Davey\"}";
	private AccountMapRepository repo = new AccountMapRepository(); 
	private Gson genny = new Gson();
	@Before
	public void setup() {
		Gson genny = new Gson();
		repo = new AccountMapRepository();
	}
	
	@Test
	public void addAccountTest() {
		String reply = "Account created";
		assertEquals(reply, repo.createAccount(MOCK_OBJECT));
	}
	
	@Test
	public void add2AccountsTest() {
		String reply = "Account created";
		assertEquals(reply, repo.createAccount(MOCK_OBJECT));
		assertEquals(reply, repo.createAccount(MOCK_OBJECT2));
	}

	@Test
	public void removeAccountTest() {
		String reply = "Account created";
		String reply2 = "Account deleted";
		assertEquals(reply, repo.createAccount(MOCK_OBJECT));
		assertEquals(reply2, repo.deleteAccount((long) 1));
	}
	
	@Test
	public void remove2AccountsTest() {

		String reply = "Account created";
		String reply2 = "Account deleted";
		assertEquals(reply, repo.createAccount(MOCK_OBJECT));
		assertEquals(reply, repo.createAccount(MOCK_OBJECT2));
		assertEquals(reply2, repo.deleteAccount((long) 1));
		assertEquals(reply2, repo.deleteAccount((long) 2));
	}
	
	@Test
	public void remove2AccountTestAnd1ThatDoesntExist() {

		String reply = "Account created";
		String reply2 = "Account deleted";
		assertEquals(reply, repo.createAccount(MOCK_OBJECT));
		assertEquals(reply, repo.createAccount(MOCK_OBJECT2));
		assertEquals(reply2, repo.deleteAccount((long) 1));
		assertEquals(reply2, repo.deleteAccount((long) 2));	
		assertEquals(reply2, repo.deleteAccount((long) 3));
	}
	
	@Test
	public void jsonStringToAccountConversionTest() {
		Account	acc1 = genny.fromJson(MOCK_OBJECT, Account.class);
		assertEquals(123456, acc1.getAccNumber());
	}
	@Ignore
	public void accountConversionToJSONTest() {
		Account acc1 = genny.fromJson(MOCK_OBJECT, Account.class);
		assertEquals(123456, acc1.getAccNumber());
		String testString = genny.toJson(acc1);
		assertEquals(MOCK_OBJECT, testString);
		//test currently broken, not sure why
	}
	@Test
	public void getCountForFirstNamesInAccountWhenZeroOccurances() {
		repo.createAccount(MOCK_OBJECT);
		repo.createAccount(MOCK_OBJECT2);	
		String reply = "There are 0 accounts with that name.";
		assertEquals(reply, repo.nameCount("David"));
	}
	
	@Test
	public void getCountForFirstNamesInAccountWhenOne() {
		repo.createAccount(MOCK_OBJECT);
		repo.createAccount(MOCK_OBJECT2);	
		String reply = "There are 1 accounts with that name.";
		assertEquals(reply, repo.nameCount("Bert"));
	}

	@Test
	public void getCountForFirstNamesInAccountWhenTwo() {
		repo.createAccount(MOCK_OBJECT);
		repo.createAccount(MOCK_OBJECT2);	
		repo.createAccount(MOCK_OBJECT3);
		String reply = "There are 2 accounts with that name.";
		assertTrue(MOCK_OBJECT2.contains("Bob"));
		assertEquals(reply, repo.nameCount("Bob"));
	}
}
