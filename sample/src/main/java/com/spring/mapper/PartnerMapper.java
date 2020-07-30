package com.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.domain.PartnerVO;

public interface PartnerMapper {
	public int create(PartnerVO vo);
	public List<PartnerVO> read();
}
