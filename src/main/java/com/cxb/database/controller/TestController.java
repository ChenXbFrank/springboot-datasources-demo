package com.cxb.database.controller;

import com.cxb.database.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	protected static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private TestService testService;
	
	@RequestMapping("/test")
	public String index() {
		logger.debug("测试信息：{}","welcome log world");
		return "主表："+testService.queryCountByMester();
	}
	
	@RequestMapping("/test1")
	public String test(@RequestParam String name) {
		return "从表："+testService.queryCountBySavle(name);
	}
	
	
}