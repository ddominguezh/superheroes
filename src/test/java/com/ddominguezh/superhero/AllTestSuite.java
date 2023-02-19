package com.ddominguezh.superhero;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import com.ddominguezh.superhero.app.checkHealth.CheckHealthTestSuite;
import com.ddominguezh.superhero.app.color.ColorTestSuite;
import com.ddominguezh.superhero.app.gender.GenderTestSuite;
import com.ddominguezh.superhero.app.hero.HeroTestSuite;
import com.ddominguezh.superhero.shared.domain.AuthorizationTest;

@SelectClasses(
		{
			CheckHealthTestSuite.class,
			ColorTestSuite.class,
			GenderTestSuite.class,
			HeroTestSuite.class,
			AuthorizationTest.class
		}
	)
@Suite
public class AllTestSuite {

}
