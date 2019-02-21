package com.codify.algorithms.sorting;

public class InsertionSort {

	public static void insertionSort(int... a) {

		for (int i = 1; i < a.length; i++) {

			int value = a[i];
			int hole = i;

			while (hole > 0 && a[hole - 1] > value) {

				a[hole] = a[hole - 1];
				hole = hole - 1;

			}

			a[hole] = value;
		}

	}

	public static void main(String[] args) {

		int[] a = { 4, 6, 9, 2, 1, 7, 5, 3, 1, 2 };
		insertionSort(a);

		for (int i : a) {
			System.out.println(i);
		}

	}

}
