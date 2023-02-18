package com.ddominguezh.superhero.app.hero;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import com.ddominguezh.superhero.app.hero.application.useCase.findOneHero.OneHeroFinderTest;
import com.ddominguezh.superhero.app.hero.domain.useCase.findHeroById.HeroByIdFinderTest;

@SelectClasses(
		{
			OneHeroFinderTest.class,
			HeroByIdFinderTest.class
		}
	)
@Suite
public class HeroTestSuite {

}
