package com.paracel.dao;

import com.paracel.entity.User;

public interface UserDao extends Dao<User>{
	User getByUserName(String userName);
}
 