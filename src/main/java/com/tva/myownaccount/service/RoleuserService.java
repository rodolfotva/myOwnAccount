package com.tva.myownaccount.service;

import java.util.List;

import com.tva.myownaccount.model.Roleuser;

public interface RoleuserService {

  public List<Roleuser> getAllRoleusers();

  public Roleuser getRoleusersById(String id);

  public List<Roleuser> getRoleusersByRole(String role);

}
