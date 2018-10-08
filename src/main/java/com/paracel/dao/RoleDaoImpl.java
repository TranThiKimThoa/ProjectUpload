package com.paracel.dao;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.paracel.entity.Role;
@Transactional
@Repository
public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao {
	

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getRoleNames(long roleId) {
		String hql = "SELECT r FROM Role as r WHERE r.roleId = ?1";
		List<Role> list = entityManager.createQuery(hql)
						.setParameter(1, roleId)
						.getResultList();
		if(list == null || list.isEmpty()){
			return new ArrayList<Role>();
		}
		return list;
	}
}
