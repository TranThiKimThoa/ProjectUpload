package com.paracel.dao;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.paracel.entity.RfidCard;
@Transactional
@Repository
public class RfidCardDaoImpl extends AbstractDao<RfidCard> implements RfidCardDao {
	

	@SuppressWarnings("unchecked")
	@Override
	public RfidCard getRfid(String rfidReaderId, String rfidCardId) {
		
		String hql = "SELECT r FROM RfidCard as r WHERE r.rfidReaderId = ?1 AND r.rfidCardId = ?2";
		List<RfidCard> list = entityManager.createQuery(hql)
						.setParameter(1, rfidReaderId)
						.setParameter(2, rfidCardId)
						.getResultList();
		if(list == null || list.isEmpty()){
			return null;
		}
		return list.get(0);
	}	
	 
}
