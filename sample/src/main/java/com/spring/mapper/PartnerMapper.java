package com.spring.mapper;

import org.apache.ibatis.annotations.Param;

import com.spring.domain.PartnerVO;

public interface PartnerMapper {
	public int create(PartnerVO vo);
}
