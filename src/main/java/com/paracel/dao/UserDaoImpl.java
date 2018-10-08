package com.paracel.dao;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.paracel.entity.User;
@Transactional
@Repository
public class UserDaoImpl extends AbstractDao<User> implements UserDao {
	@SuppressWarnings("unchecked")
	@Override
	public User getByUserName(String userName) {
		String hql = "SELECT u FROM User as u WHERE u.userName = ?1 and u.enabled = 1";
		List<User> list = entityManager.createQuery(hql)
						.setParameter(1, userName)
						.getResultList();
		if(list == null || list.isEmpty()){
			return null;
		}
		return list.get(0);
	}
}
