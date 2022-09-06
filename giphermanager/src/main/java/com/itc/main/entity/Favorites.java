package com.itc.main.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Favorites {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int favId;
	private String email;
	private String title;
	private String imageUrl;
	@JsonIgnore
	private int userId;
	public Favorites() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Favorites(int favId, String email, String title, String imageUrl, int userId) {
		super();
		this.favId = favId;
		this.email = email;
		this.title = title;
		this.imageUrl = imageUrl;
		this.userId = userId;
	}
	public int getFavId() {
		return favId;
	}
	public void setFavId(int favId) {
		this.favId = favId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
