package com.inmywords.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class BlogUser implements Serializable {

	private static final long serialVersionUID = 6061526192538198998L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long id;
	private String name;
	private String phone;
	private String email;
	private String imageUrl;
	@Column(nullable = false, updatable = false)
	private String userCode;

	public BlogUser() {
	}

	public BlogUser(String name, String phone, String email, String imageUrl, String userCode) {
		super();
		this.name = name;
		this.phone = phone;
		this.imageUrl = imageUrl;
		this.email = email;
		this.userCode = userCode;
	}

}
