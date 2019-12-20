package com.xh.learn.website.webProducts.usr.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.xh.learn.website.webProducts.usr.entity.Usr;

public interface UsrService {
	public void addUsr(List<Usr> usrs);

	public void deleteUsrByIds(String ids);

	public String queryUsrs();

	public PageInfo<Usr> queryUsr(Usr usr, Integer pageNum, Integer pageSize);

	public PageInfo<Usr> queryUsrByCondition(Usr usr, Integer pageNum, Integer pageSize);
}
