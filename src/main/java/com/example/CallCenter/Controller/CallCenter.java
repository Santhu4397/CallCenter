package com.example.CallCenter.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.CallCenter.Dto.CallCenterDto;
import com.example.CallCenter.Exsipation.StatusNotFound;
import com.example.CallCenter.Repo.CallCenterRepo;

@RestController
public class CallCenter  {

	@Autowired
	CallCenterRepo center ;
	@PostMapping("/")
	public CallCenterDto save(@RequestBody CallCenterDto callCenter) { 

		CallCenterDto dto= center.save(callCenter);
		
		if(dto!=null) {
			return dto;
		}else {
			throw new StatusNotFound(callCenter.getCallStatus()+"CallStatusNotAvialbel");
		}
	}
	
	
	
	@GetMapping("get")
	public CallCenterDto get() {
		
		return new CallCenterDto();
	}
}
