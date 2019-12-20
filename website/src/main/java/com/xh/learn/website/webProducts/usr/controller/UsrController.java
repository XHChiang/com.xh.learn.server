package com.xh.learn.website.webProducts.usr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.xh.learn.sdk.entity.Result;
import com.xh.learn.sdk.error.SdkError;
import com.xh.learn.website.webProducts.usr.entity.Usr;
import com.xh.learn.website.webProducts.usr.service.UsrService;

@RestController
@RequestMapping("/usr")
public class UsrController {
	@Autowired
	UsrService usrService;

	@PostMapping("/add")
	public Result addUsr(@RequestBody List<Usr> usrs) {
		Result result = new Result(Result.SUCCESS);
		try {
			usrService.addUsr(usrs);
		} catch (Exception e) {
			e.printStackTrace();
			result.error(SdkError.INTERNAL_ERROR);
		}
		return result;
	}

	@DeleteMapping("/delete")
	public Result deleteUsrByIds(@RequestParam String ids) {
		Result result = new Result(Result.SUCCESS);
		try {
			usrService.deleteUsrByIds(ids);
		} catch (Exception e) {
			e.printStackTrace();
			result.error(SdkError.INTERNAL_ERROR);
		}
		return result;
	}

	@GetMapping("/query")
	public Result queryUsr(Usr usr, @RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(defaultValue = "10") Integer pageSize) {
		Result result = new Result(Result.SUCCESS);
		try {
			PageInfo<Usr> usrPage = usrService.queryUsr(usr, pageNum, pageSize);
			result.setData(usrPage);
		} catch (Exception e) {
			e.printStackTrace();
			result.error(SdkError.INTERNAL_ERROR);
		}
		return result;
	}

	@GetMapping("/query/v2")
	public Result queryUsrByCondition(Usr usr, @RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(defaultValue = "10") Integer pageSize) {
		Result result = new Result(Result.SUCCESS);
		try {
			PageInfo<Usr> usrPage = usrService.queryUsrByCondition(usr, pageNum, pageSize);
			result.setData(usrPage);
		} catch (Exception e) {
			e.printStackTrace();
			result.error(SdkError.INTERNAL_ERROR);
		}
		return result;
	}
}
