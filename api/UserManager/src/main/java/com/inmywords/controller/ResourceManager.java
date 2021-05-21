package com.inmywords.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inmywords.model.BlogUser;
import com.inmywords.service.UserService;

@RestController
@RequestMapping("users")
public class ResourceManager {

	private UserService userService;

	public ResourceManager(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public ResponseEntity<List<BlogUser>> getAllUsers() {
		List<BlogUser> blogUsers = userService.findAllBlogUsers();
		return new ResponseEntity<>(blogUsers, HttpStatus.OK);

	}

	@GetMapping("/find/{id}")
	public ResponseEntity<BlogUser> getBlogUser(@PathVariable("id") Long id) {
		BlogUser blogUser = userService.findBlogUserById(id);
		return new ResponseEntity<>(blogUser, HttpStatus.OK);

	}

	@PostMapping("/add")
	public ResponseEntity<BlogUser> addBlogUser(@RequestBody BlogUser blogUser) {
		BlogUser newBlogUser = userService.addBlogUser(blogUser);
		return new ResponseEntity<>(newBlogUser, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<BlogUser> updateBlogUser(@RequestBody BlogUser blogUser) {
		BlogUser updatedBlogUser = userService.updateBlogUser(blogUser);
		return new ResponseEntity<>(updatedBlogUser, HttpStatus.OK);
	}

	@DeleteMapping("/delete/id")
	public ResponseEntity<?> deleteBlogUser(@PathVariable("id") Long id) {
		userService.deleteBlogUser(id);
		return new ResponseEntity<>(HttpStatus.OK);

	}
}
