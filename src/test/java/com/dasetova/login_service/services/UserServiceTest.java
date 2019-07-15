package com.dasetova.login_service.services;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.Test;

import com.dasetova.login_service.repositories.IUserRepository;
import com.dasetova.login_service.services.impl.UserService;

public class UserServiceTest {

	@Mock
	private IUserRepository userRepository;

	@Before 
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	@InjectMocks
	private IUserService userService = new UserService();
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void findByIdWhenIdNullTest() {
		userService.findById(null);
	}
}
