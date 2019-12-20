package com.xh.learn.website.webProducts.usr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.xh.learn.website.webProducts.usr.entity.UsrGroup;

import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;

@Mapper
public interface UsrGroupMapper extends BaseMapper<UsrGroup>, IdsMapper<UsrGroup>, ConditionMapper<UsrGroup> {

	public List<UsrGroup> queryUsrGroups();

	public List<UsrGroup> queryUsrGroupsV2();
}
