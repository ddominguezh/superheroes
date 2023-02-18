package com.ddominguezh.superhero.app.color.domain;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ColorMother {

	public static List<Color> randomColors() {
		return Collections.nCopies(new Random().nextInt(10), randomColor());
	}

	public static Color randomColor() {
		return Color.create(new Random().nextInt(100), randomAlphabetic(30));
	}
}
