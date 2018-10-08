package com.paracel.dao;

import java.util.List;

import com.paracel.entity.Role;

public interface RoleDao extends Dao<Role>{
	List<Role> getRoleNames(long roleId);
}
 