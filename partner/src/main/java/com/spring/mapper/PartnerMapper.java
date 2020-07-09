package com.spring.mapper;

import java.util.List;

import com.spring.domain.PartnerVO;

public interface PartnerMapper {
	public List<PartnerVO> list();
	public int insert(PartnerVO vo);
	public PartnerVO read(int bno);
	public int update(PartnerVO vo);
	public int delete(int bno);
}
