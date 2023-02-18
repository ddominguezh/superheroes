package com.ddominguezh.superhero.app.color;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import com.ddominguezh.superhero.app.color.application.useCase.findColor.ColorFinderTest;
import com.ddominguezh.superhero.app.color.infrastructure.controller.ColorGetControllerTest;
import com.ddominguezh.superhero.app.color.infrastructure.repository.H2ColorRepositoryTest;

@SelectClasses(
		{
			ColorFinderTest.class,
			ColorGetControllerTest.class,
			H2ColorRepositoryTest.class
		}
	)
@Suite
public class ColorTestSuite {

}
