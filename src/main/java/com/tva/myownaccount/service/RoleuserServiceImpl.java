package com.tva.myownaccount.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tva.myownaccount.model.Roleuser;
import com.tva.myownaccount.repositorie.RoleuserRepository;

@Service("roleuserService")
@Transactional
public class RoleuserServiceImpl implements RoleuserService {

  @Autowired
  private RoleuserRepository roleuserRepo;

  @Override
  public List<Roleuser> getAllRoleusers() {
    return roleuserRepo.findAll();
  }

  @Override
  public Roleuser getRoleusersById(String id) {
    return roleuserRepo.findByid(id);
  }

  @Override
  public List<Roleuser> getRoleusersByRole(String role) {
    return roleuserRepo.findByRole(role);
  }
}
