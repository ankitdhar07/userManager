package com.inmywords.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inmywords.model.BlogUser;

public interface UserRepo extends JpaRepository<BlogUser, Long> {

	void deleteBlogUserById(Long id);

	Optional<BlogUser> findBlogUserById(Long id);

}
