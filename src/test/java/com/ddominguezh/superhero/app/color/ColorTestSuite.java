package com.ddominguezh.superhero.app.color;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import com.ddominguezh.superhero.app.color.application.useCase.findColor.ColorFinderTest;
import com.ddominguezh.superhero.app.color.infrastructure.controller.ColorGetControllerTest;

@SelectClasses(
		{
			ColorFinderTest.class,
			ColorGetControllerTest.class
		}
	)
@Suite
public class ColorTestSuite {

}
