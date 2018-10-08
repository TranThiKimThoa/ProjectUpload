package com.paracel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paracel.dao.RfidCardDao;
import com.paracel.dao.RfidCardRepository;
import com.paracel.entity.RfidCard;
@Service
public class RfidCardServiceImpl implements RfidCardService {
	@Autowired
	private RfidCardDao rfidCardDao;
	@Autowired
	private RfidCardRepository rfidCardRepository;
	@SuppressWarnings("unused")
	@Override
	public RfidCard getRfid(String rfidReaderId, String rfidCardId) {
		RfidCard rfidCard1 = rfidCardRepository.findByRfidCardIdAndRfidReaderId(rfidCardId, rfidReaderId);
		RfidCard rfidCard2 = rfidCardDao.getRfid(rfidReaderId, rfidCardId);
		
		return rfidCard2;
	}
	
	
}
