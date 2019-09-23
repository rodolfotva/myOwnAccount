package com.tva.myownaccount.model;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "lineitem")
public class Lineitem {

  @Id
  private ObjectId objectId;
  @Field("id")
  private String id;
  @Field("description")
  private String description;
  @Field("accountId")
  private String accountId;
  @Field("user")
  private String user;
  @Field("date")
  private Date date;
  @Field("value")
  private Double value;

  public Lineitem() {
    super();
  }

  public Lineitem(ObjectId objectId, String id, String description, String accountId, String user, Date date, Double value) {
    super();
    this.objectId = objectId;
    this.id = id;
    this.description = description;
    this.accountId = accountId;
    this.user = user;
    this.date = date;
    this.value = value;
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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public String getUser() {
    return user;
  }

  public void setUserId(String user) {
    this.user = user;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Double getValue() {
    return value;
  }

  public void setValue(Double value) {
    this.value = value;
  }

}
