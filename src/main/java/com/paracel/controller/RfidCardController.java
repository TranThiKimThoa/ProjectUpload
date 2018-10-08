package com.paracel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.paracel.entity.RfidCard;
import com.paracel.service.RfidCardService;

@Controller
@RestController
public class RfidCardController {
	@Autowired
	private RfidCardService rsfidServiceImpl;

	@GetMapping("rfid/{rfidreaderid}/{rfidcardid}")
	public ResponseEntity<String> getArticleById(@PathVariable("rfidreaderid") String rfidReaderId,
			@PathVariable("rfidcardid") String rfidCardId) {
		RfidCard rfidCard = rsfidServiceImpl.getRfid(rfidReaderId, rfidCardId);
		if (rfidCard == null) {
			return new ResponseEntity<String>("disactive", HttpStatus.OK);
		}
		return new ResponseEntity<String>(rfidCard.getStatus(), HttpStatus.OK);
	}

}