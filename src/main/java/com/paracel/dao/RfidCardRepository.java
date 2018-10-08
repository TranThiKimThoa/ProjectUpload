package com.paracel.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.paracel.entity.RfidCard;

public interface RfidCardRepository extends CrudRepository<RfidCard, String> { // Long: Type of Employee ID.
	 
	RfidCard findByRfidCardIdAndRfidReaderId(String rfidCardId, String rfidReaderId);
    @Query("SELECT COUNT(r.rfidCardId) FROM RfidCard r")
    Long getCount();
 
}
