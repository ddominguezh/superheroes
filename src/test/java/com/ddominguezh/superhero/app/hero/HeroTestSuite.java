package com.ddominguezh.superhero.app.hero;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import com.ddominguezh.superhero.app.hero.application.useCase.findOneHero.OneHeroFinderTest;

@SelectClasses(
		{
			OneHeroFinderTest.class,
		}
	)
@Suite
public class HeroTestSuite {

}
