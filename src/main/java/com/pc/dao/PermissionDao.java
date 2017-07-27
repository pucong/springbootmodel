package com.pc.dao;

import com.pc.model.Permission;

import java.util.List;

/**
 * Created by PC on 2017/7/27.
 */
public interface  PermissionDao {

    public List<Permission> findAll();

    public List<Permission> findByAdminUserId(int userId);
}
