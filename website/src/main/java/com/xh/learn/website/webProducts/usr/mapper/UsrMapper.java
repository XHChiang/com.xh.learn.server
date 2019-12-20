package com.xh.learn.website.webProducts.usr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.xh.learn.website.webProducts.usr.entity.Usr;

import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;

@Mapper
public interface UsrMapper extends BaseMapper<Usr>, IdsMapper<Usr>, ConditionMapper<Usr> {

	public List<Usr> queryUsrs();

	public List<Usr> queryUsrsByGroupId(@Param("groupId") Integer groupId);

	public List<Usr> queryDeletedUsrsByGroupId(@Param("groupId") Integer groupId);
}
