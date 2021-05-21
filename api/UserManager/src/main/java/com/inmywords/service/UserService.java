package com.inmywords.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inmywords.model.BlogUser;
import com.inmywords.repository.UserRepo;
import com.inmywords.service.exception.UserNotFoundException;

@Service
public class UserService {

	private UserRepo userRepo;

	@Autowired
	public UserService(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	public BlogUser addBlogUser(BlogUser blogUser) {
		blogUser.setUserCode(UUID.randomUUID().toString());
		return userRepo.save(blogUser);

	}

	public List<BlogUser> findAllBlogUsers() {
		return userRepo.findAll();
	}

	public BlogUser updateBlogUser(BlogUser blogUser) {
		return userRepo.save(blogUser);
	}

	public void deleteBlogUser(Long id) {
		userRepo.deleteBlogUserById(id);
	}

	public BlogUser findBlogUserById(Long id) {
		return userRepo.findBlogUserById(id)
				.orElseThrow(() -> new UserNotFoundException("User not found by Id : " + id));
	}
}
