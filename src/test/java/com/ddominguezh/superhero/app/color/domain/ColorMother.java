package com.ddominguezh.superhero.app.color.domain;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ColorMother {

	public static List<Color> randomColors() {
		return Collections.nCopies(new Random(10).nextInt(), randomColor());
	}

	public static Color randomColor() {
		return Color.create(new Random(100).nextInt(), randomAlphabetic(30));
	}
}
