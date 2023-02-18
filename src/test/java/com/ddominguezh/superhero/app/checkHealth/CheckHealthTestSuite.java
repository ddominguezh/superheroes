package com.ddominguezh.superhero.app.checkHealth;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import com.ddominguezh.superhero.app.checkHealth.infrastructure.controller.CheckHealthGetControllerTest;

@SelectClasses(
		{
			CheckHealthGetControllerTest.class
		}
	)
@Suite
public class CheckHealthTestSuite {

}
