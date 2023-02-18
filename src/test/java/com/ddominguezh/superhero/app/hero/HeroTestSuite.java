package com.ddominguezh.superhero.app.hero;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import com.ddominguezh.superhero.app.hero.application.useCase.findOneHero.OneHeroFinderTest;
import com.ddominguezh.superhero.app.hero.domain.useCase.findHeroById.HeroByIdFinderTest;
import com.ddominguezh.superhero.app.hero.infrastructure.repository.H2HeroRepositoryTest;

@SelectClasses(
		{
			OneHeroFinderTest.class,
			HeroByIdFinderTest.class,
			H2HeroRepositoryTest.class
		}
	)
@Suite
public class HeroTestSuite {

}
