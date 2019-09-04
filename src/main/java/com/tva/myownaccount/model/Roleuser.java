package com.tva.myownaccount.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "roleuser")
public class Roleuser {

  @Id
  private ObjectId objectId;
  @Field("id")
  private String id;
  @Field("role")
  private String role;

  public Roleuser() {
    super();
  }

  public Roleuser(ObjectId objectId, String id, String role) {
    super();
    this.objectId = objectId;
    this.id = id;
    this.role = role;
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

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }
}
