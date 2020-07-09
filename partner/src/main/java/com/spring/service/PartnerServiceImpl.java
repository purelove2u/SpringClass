package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.spring.domain.PartnerVO;
import com.spring.mapper.PartnerMapper;

@Service
public class PartnerServiceImpl implements PartnerService {

	@Autowired
	private PartnerMapper mapper;
	
	@Override
	public boolean insertBoard(PartnerVO vo) {		
		return mapper.insert(vo)==1?true:false;
	}

	@Override
	public boolean updateBoard(PartnerVO vo) {		
		return mapper.update(vo)==1?true:false;
	}

	@Override
	public boolean deleteBoard(int bno) {		
		return mapper.delete(bno)==1?true:false;
	}

	@Override
	public PartnerVO getBoard(int bno) {		
		return mapper.read(bno);
	}

	@Override
	public List<PartnerVO> getList() {		
		return mapper.list();
	}

}






