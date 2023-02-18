package com.ddominguezh.superhero.app.gender;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import com.ddominguezh.superhero.app.gender.application.useCase.findGender.GenderFinderTest;
import com.ddominguezh.superhero.app.gender.infrastructure.controller.GenderGetControllerTest;
import com.ddominguezh.superhero.app.gender.infrastructure.repository.H2GenderRepositoryTest;

@SelectClasses(
		{
			GenderFinderTest.class,
			GenderGetControllerTest.class,
			H2GenderRepositoryTest.class
		}
	)
@Suite
public class GenderTestSuite {

}
