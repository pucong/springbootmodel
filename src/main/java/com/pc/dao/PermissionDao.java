package com.pc.dao;

import com.pc.model.Permission;
import com.pc.model.SysRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by PC on 2017/7/27.
 */
@Mapper
public interface  PermissionDao {

    public List<Permission> findAll();

    public List<Permission> findByAdminUserId(int userId);

    public List<SysRole> findRoleByAdminUserId(int userId);

}
