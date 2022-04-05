package com.example.CallCenter.Repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.CallCenter.Dto.CallCenterDto;

public interface CallCenterRepo extends JpaRepository<CallCenterDto, Integer> {
	

}
