package com.pc.dao;

import com.pc.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by PC on 2017/7/26.
 */
@Mapper
public interface UserDao {
    User getUserById(int id);
}
