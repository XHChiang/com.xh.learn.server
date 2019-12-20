package com.xh.learn.website.webProducts.log.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.xh.learn.website.webProducts.log.entity.BsLog;

import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;

@Mapper
public interface LogMapper extends BaseMapper<BsLog>, IdsMapper<BsLog>, ConditionMapper<BsLog> {

}
