package com.ddominguezh.superhero.app.gender;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import com.ddominguezh.superhero.app.gender.application.useCase.findGender.GenderFinderTest;

@SelectClasses(
		{
			GenderFinderTest.class
		}
	)
@Suite
public class GenderTestSuite {

}
