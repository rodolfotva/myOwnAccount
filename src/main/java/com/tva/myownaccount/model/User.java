package com.tva.myownaccount.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "user")
public class User {

	@Id
	private ObjectId objectId;
	@Field("id")
	private String id;
	@Field("name")
	private String name;
	@Field("familyname")
	private String familyname;
	@Field("email")
	private String email;
	@Field("username")
	private String username;
	@Field("password")
	private String password;
	@Field("isAdmin")
	private Boolean isAdmin;
	@Field("authority")
	private List<String> authority;
	

	public User() {
		super();
	}

	public User(ObjectId objectId, String id, String name, String familyname, String email, String username, String password, Boolean isAdmin) {
		super();
		this.objectId = objectId;
		this.id = id;
		this.name = name;
		this.familyname = familyname;
		this.email = email;
		this.username = username;
		this.password = password;
		this.isAdmin = isAdmin;
	}

	public ObjectId getObjectId() {
		return objectId;
	}

	public void setObjectId(ObjectId objectId) {
		this.objectId = objectId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getAuthority() {
		return authority;
	}

	public void setAuthority(List<String> authority) {
		this.authority = authority;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFamilyname() {
		return familyname;
	}

	public void setFamilyname(String familyname) {
		this.familyname = familyname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	

}
