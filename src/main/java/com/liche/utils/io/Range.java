package com.liche.utils.io;

public class Range {

	private int min;
	private int max;

	public Range(int min, int max) {
		this.min = min;
		this.max = max;
	}

	public boolean contains(int value) {

		return value >= min && value <= max;
	}
}
