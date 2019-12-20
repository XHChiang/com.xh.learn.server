package com.xh.learn.website.webProducts.usr.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xh.learn.website.webProducts.usr.entity.Usr;
import com.xh.learn.website.webProducts.usr.mapper.UsrMapper;
import com.xh.learn.website.webProducts.usr.service.UsrService;

import tk.mybatis.mapper.entity.Condition;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class UsrServiceImpl implements UsrService {
	@Autowired
	UsrMapper usrMapper;

	@Override
	public void addUsr(List<Usr> usrs) {
		usrs.forEach(u -> {
			u.setCreateTime(LocalDateTime.now());
			usrMapper.insertSelective(u);
		});
	}

	@Override
	public void deleteUsrByIds(String ids) {
		usrMapper.deleteByIds(ids);
	}

	@Override
	public String queryUsrs() {
		return JSON.toJSONString(usrMapper.selectAll());
	}

	@Override
	public PageInfo<Usr> queryUsr(Usr usr, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Usr> usrList = usrMapper.select(usr);
		PageInfo<Usr> usrPage = new PageInfo<Usr>(usrList);

		return usrPage;
	}

	@Override
	public PageInfo<Usr> queryUsrByCondition(Usr usr, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Condition condition = new Condition(Usr.class);
		condition.and().andGreaterThan("id", usr.getId());
		PageInfo<Usr> usrPage = new PageInfo<>(usrMapper.selectByCondition(condition));

		return usrPage;
	}

}
