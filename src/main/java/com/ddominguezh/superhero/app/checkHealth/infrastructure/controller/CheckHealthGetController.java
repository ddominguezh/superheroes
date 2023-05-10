package com.ddominguezh.superhero.app.checkHealth.infrastructure.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ddominguezh.logger.spring.client.shared.domain.config.annotations.Traceable;

@Controller(value="CheckHealthGetController")
@RequestMapping("check-health")
public class CheckHealthGetController {

	@Traceable
	@CrossOrigin
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public HashMap<String, String> index() throws Exception{
		HashMap<String, String> response = new HashMap<String, String>();
		response.put("status", "OK");
		return response;
	}
	
}