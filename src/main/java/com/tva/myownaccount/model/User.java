package com.tva.myownaccount.model;

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
  @Field("roleId")
  private String roleId;
  @Field("name")
  private String name;
  @Field("familynane")
  private String familynane;
  @Field("email")
  private String email;
  @Field("username")
  private String username;
  @Field("password")
  private String password;

  public User() {
    super();
  }

  public User(ObjectId objectId, String id, String roleId, String name, String familynane, String email, String username, String password) {
    super();
    this.objectId = objectId;
    this.id = id;
    this.roleId = roleId;
    this.name = name;
    this.familynane = familynane;
    this.email = email;
    this.username = username;
    this.password = password;
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

  public String getRoleId() {
    return roleId;
  }

  public void setRoleId(String roleId) {
    this.roleId = roleId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getFamilynane() {
    return familynane;
  }

  public void setFamilynane(String familynane) {
    this.familynane = familynane;
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

}
