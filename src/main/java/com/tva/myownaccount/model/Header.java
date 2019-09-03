package com.tva.myownaccount.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "header")
public class Header {

  @Id
  private ObjectId objectId;
  @Field("id")
  private String id;
  @Field("key")
  private String key;
  @Field("value")
  private String value;

  public Header() {
    super();
  }

  public Header(ObjectId objectId, String id, String key, String value) {
    super();
    this.objectId = objectId;
    this.id = id;
    this.key = key;
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

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

}
