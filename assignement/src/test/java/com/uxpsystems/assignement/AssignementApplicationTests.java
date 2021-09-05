package com.uxpsystems.assignement;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uxpsystems.assignement.model.User;
import com.uxpsystems.assignement.repository.UserRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class AssignementApplicationTests {

	@Autowired
	UserRepository userRepo;
	
	@Test
	@Order(1)
	public void testCreate () {
		User p = new User();
		p.setId(1L);
		p.setUserName("Rahul");
		p.setPassword("12345");
		p.setStatus("activated");
		userRepo.save(p);
		assertNotNull(userRepo.findById(1L).get());
	}
		
	@Test
	@Order(2)
	public void testReadAll () {
		List list = userRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
		
	@Test
	@Order(3)
	public void testRead () {
		User User = userRepo.findById(1L).get();
		assertEquals("Rahul", User.getUserName());
	}
		
	@Test
	@Order(4)
	public void testUpdate () {
		User p = userRepo.findById(1L).get();
		p.setPassword("Rahul@123");
		userRepo.save(p);
		assertNotEquals("12345", userRepo.findById(1L).get().getPassword());
	}
		
	@Test
	@Order(5)
	public void testDelete () {
		userRepo.deleteById(1L);
		assertThat(userRepo.existsById(1L)).isFalse();
	}

}
