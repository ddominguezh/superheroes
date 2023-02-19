package com.ddominguezh.superhero.app.hero;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import com.ddominguezh.superhero.app.hero.application.useCase.createHero.HeroCreatorTest;
import com.ddominguezh.superhero.app.hero.application.useCase.deleteHero.HeroDeleterTest;
import com.ddominguezh.superhero.app.hero.application.useCase.findOneHero.OneHeroFinderTest;
import com.ddominguezh.superhero.app.hero.application.useCase.updateHero.HeroUpdaterTest;
import com.ddominguezh.superhero.app.hero.domain.useCase.findColorById.ColorByIdFinderTest;
import com.ddominguezh.superhero.app.hero.domain.useCase.findGenderById.GenderByIdFinderTest;
import com.ddominguezh.superhero.app.hero.domain.useCase.findHeroById.HeroByIdFinderTest;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroIdTest;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroNameTest;
import com.ddominguezh.superhero.app.hero.infrastructure.controller.HeroDeleteControllerTest;
import com.ddominguezh.superhero.app.hero.infrastructure.controller.HeroGetControllerTest;
import com.ddominguezh.superhero.app.hero.infrastructure.controller.HeroPostControllerTest;
import com.ddominguezh.superhero.app.hero.infrastructure.repository.H2HeroColorRepositoryTest;
import com.ddominguezh.superhero.app.hero.infrastructure.repository.H2HeroGenderRepositoryTest;
import com.ddominguezh.superhero.app.hero.infrastructure.repository.H2HeroRepositoryTest;

@SelectClasses(
		{
			HeroCreatorTest.class,
			HeroDeleterTest.class,
			HeroUpdaterTest.class,
			OneHeroFinderTest.class,
			ColorByIdFinderTest.class,
			GenderByIdFinderTest.class,
			HeroByIdFinderTest.class,
			HeroIdTest.class,
			HeroNameTest.class,
			HeroDeleteControllerTest.class,
			HeroGetControllerTest.class,
			HeroPostControllerTest.class,
			H2HeroColorRepositoryTest.class,
			H2HeroGenderRepositoryTest.class,
			H2HeroRepositoryTest.class
		}
	)
@Suite
public class HeroTestSuite {

}
