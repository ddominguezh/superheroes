package com.ddominguezh.superhero.app.gender.domain;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GenderMother {
	
	public static List<Gender> randomGenders() {
		return Collections.nCopies(new Random().nextInt(10), randomGender());
	}

	public static Gender randomGender() {
		return Gender.create(new Random().nextInt(100), randomAlphabetic(30));
	}
	
}
