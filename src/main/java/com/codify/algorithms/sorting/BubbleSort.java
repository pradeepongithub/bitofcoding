package com.codify.algorithms.sorting;

public class BubbleSort {

	public static void bubbleSort(int... a) {

		for (int i = 1; i < a.length - 2; i++) {
			boolean sorted = false;

			for (int j = 0; j < a.length - i; j++) {
				if (a[j] > a[j + 1]) {
					swap(j, j + 1, a);
					sorted = true;
				}
			}
			if (!sorted) {
				break;
			}
		}

	}

	private static void swap(int i, int j, int... a) {
		int temp =a[i];
		a[i] = a[j];
		a[j] = temp;

	}

	public static void main(String[] args) {

		int[] a = { 4, 6, 9, 2, 1, 7, 5, 3,1,2 };
		bubbleSort(a);

		for (int i : a) {
			System.out.println(i);
		}
	}

}
