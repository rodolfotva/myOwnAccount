package com.tva.myownaccount.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "account")
public class Account {

  @Id
  private ObjectId objectId;
  @Field("id")
  private String id;
  @Field("name")
  private String name;
  @Field("description")
  private String description;

  public Account() {
    super();
  }

  public Account(ObjectId objectId, String id, String name, String description) {
    super();
    this.objectId = objectId;
    this.id = id;
    this.name = name;
    this.description = description;
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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
