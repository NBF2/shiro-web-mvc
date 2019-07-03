package com.demo.mapper;

import com.demo.common.pojo.UserBean;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    UserBean getUserByUserName(@Param("userName") String username);

}
