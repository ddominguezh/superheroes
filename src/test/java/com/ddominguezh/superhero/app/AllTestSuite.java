package com.ddominguezh.superhero.app;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import com.ddominguezh.superhero.app.checkHealth.CheckHealthTestSuite;
import com.ddominguezh.superhero.app.color.ColorTestSuite;
import com.ddominguezh.superhero.app.gender.GenderTestSuite;

@SelectClasses(
		{
			CheckHealthTestSuite.class,
			ColorTestSuite.class,
			GenderTestSuite.class
		}
	)
@Suite
public class AllTestSuite {

}
