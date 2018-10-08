package com.paracel.dao;

import com.paracel.entity.RfidCard;

public interface RfidCardDao extends Dao<RfidCard>{
	RfidCard getRfid(String rfidReaderId, String rfidCardId);
}
 