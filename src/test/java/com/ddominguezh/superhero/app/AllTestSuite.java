package com.ddominguezh.superhero.app;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import com.ddominguezh.superhero.app.checkHealth.CheckHealthTestSuite;
import com.ddominguezh.superhero.app.color.ColorTestSuite;

@SelectClasses(
		{
			CheckHealthTestSuite.class,
			ColorTestSuite.class
		}
	)
@Suite
public class AllTestSuite {

}
