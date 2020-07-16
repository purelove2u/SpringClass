package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.PartnerVO;
import com.spring.mapper.PartnerMapper;

@Service  //@Component, @Repository, @Controller  => 객체 생성
public class PartnerServiceImpl implements PartnerService {

	@Autowired  //객체 주입 @Inject
	private PartnerMapper mapper;
	
	@Override
	public boolean insert(PartnerVO vo) {		
		return mapper.create(vo)==1?true:false;
	}

}










