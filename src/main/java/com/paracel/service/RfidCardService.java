package com.paracel.service;

import com.paracel.entity.RfidCard;

public interface RfidCardService {
	RfidCard getRfid(String rfidReaderId, String rfidCardId);
}
