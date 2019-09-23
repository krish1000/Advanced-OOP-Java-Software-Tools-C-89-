package eecs2030.lab2;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

/*
 * NOTE TO STUDENTS: 
 * The constructor that you need to complete can be found on line 47.
 * 
 * The two methods you need to complete can be found at the end of this file.
 */

public class Die implements Comparable<Die> {

	/**
	 * A random number generator to simulate rolling the die. DO NOT CHANGE THE
	 * DECLARATION OF rng. THE UNIT TESTS RELY ON BEGIN ABLE TO ACCESS THE RANDOM
	 * NUMBER GENERATOR.
	 */
	Random rng = new Random();

	/**
	 * The array of face values.
	 */
	private int[] faces;

	/**
	 * The current value of the die.
	 */
	private int value;

	/**
	 * The number of faces on a die.
	 */
	public static int NUMBER_OF_FACES = 6;

	/*
	 * You need to implement the no-argument constructor below, and the methods
	 * compareTo and equals found at the end of the class.
	 */

	public Die() {
		int arr[] = { 1, 2, 3, 4, 5, 6 };
		this.faces = Arrays.copyOfRange(arr, 0, arr.length);
		// could have looped it
		this.value = 1;
	}

	private static boolean isInAscendingOrder(int[] a) {
		for (int i = 1; i < a.length; i++) {
			if (a[i] < a[i - 1]) {
				return false;
			}
		}
		return true;
	}

	public Die(int[] faces) {
		if (faces.length != 6) {
			throw new IllegalArgumentException();
		}
		if (!Die.isInAscendingOrder(faces)) {
			throw new IllegalArgumentException();
		}
		this.faces = Arrays.copyOf(faces, NUMBER_OF_FACES);
		this.value = this.faces[0];
	}

	public void setValueToFace(int face) {
		if (face < 0 || face >= NUMBER_OF_FACES) {
			throw new IllegalArgumentException();
		}
		this.value = this.faces[face];
	}

	public int value() {
		return this.value;
	}

	public int roll() {
		int idx = rng.nextInt(Die.NUMBER_OF_FACES);
		this.value = this.faces[idx];
		return this.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.value, this.faces);
	}

	/*
	 * You need to implement the compareTo and equals methods below.
	 * 
	 */

	@Override
	public int compareTo(Die other) {
		return this.value - other.value;
	}

	@Override
	public boolean equals(Object obj) {
		// The method Arrays.equals may be useful for helping
		// to implement this method.
		//System.out.println(obj.hashCode());
//		if (obj == null || obj.equals(null) || obj.getClass() != Die.class ) {
		if (obj == null || obj.getClass() != Die.class ) {
			return false;
//		} else if (this.faces.equals(((Die)obj).faces) || compareTo(((Die) obj)) == 0) {
		} else if (Arrays.equals(this.faces,((Die)obj).faces) == false) {
			return false;
		} else if (compareTo(((Die) obj)) != 0) {
			return false;
		}
		return true;
	}

}
