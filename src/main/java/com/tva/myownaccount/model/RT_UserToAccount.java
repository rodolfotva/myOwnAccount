package com.tva.myownaccount.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "rt_usertoaccount")
public class RT_UserToAccount {

  @Id
  private ObjectId objectId;
  @Field("userId")
  private String userId;
  @Field("accountId")
  private String accountId;

  public RT_UserToAccount() {
    super();
  }

  public RT_UserToAccount(ObjectId objectId, String userId, String accountId) {
    super();
    this.objectId = objectId;
    this.userId = userId;
    this.accountId = accountId;
  }

  public ObjectId getObjectId() {
    return objectId;
  }

  public void setObjectId(ObjectId objectId) {
    this.objectId = objectId;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

}
