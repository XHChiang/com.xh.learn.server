package com.xh.learn.website;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.xh.learn.website.testModule.main.Main2;
import com.xh.learn.website.testModule.main.Main3;
import com.xh.learn.website.webProducts.usr.entity.Usr;
import com.xh.learn.website.webProducts.usr.entity.UsrGroup;
import com.xh.learn.website.webProducts.usr.mapper.UsrGroupMapper;
import com.xh.learn.website.webProducts.usr.mapper.UsrMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IbatisTests {
	private Logger logger = LoggerFactory.getLogger(IbatisTests.class);

	@Autowired
	UsrMapper usrMapper;

	@Autowired
	UsrGroupMapper usrGroupMapper;

	@Autowired
	Main2 main2;

	@Autowired
	Main3 main3;

	@Test
	@Ignore
	public void test1() throws InterruptedException {
		List<Usr> usrs1 = usrMapper.queryUsrs();
		logger.info("usrs1: {}", usrs1);

		Thread.sleep(3000);

		List<Usr> usrs2 = usrMapper.queryUsrs();
		logger.info("usrs2: {}", usrs2);
	}

	@Test
	@Ignore
	public void test2() {
		List<UsrGroup> usrGroups = usrGroupMapper.queryUsrGroups();
		usrGroups.forEach(usrgroup -> {
			System.out.println(usrgroup.getUsrs().size());
			System.out.println(usrgroup.getDeletedUsrs().size());
		});
	}

	@Test
	@Ignore
	public void test3() {
		List<UsrGroup> usrGroups = usrGroupMapper.queryUsrGroupsV2();
		logger.debug("usrGroups: {}", usrGroups);
	}

	@Test
	@Ignore
	public void test4() {
		logger.debug(main3.getName());
		logger.debug(Boolean.toString(main3.equals(main2.getMain3())));
	}

	@Test
	public void test5() {
		main2.showtime();
		main2.showtime();
	}
}
