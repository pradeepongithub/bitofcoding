package com.codify.algorithms.sorting;

public class SelectionSort {

	public static void selectionSort(int... a) {

		for (int i = 0; i < a.length - 1; i++) { // we have to do n-2 passes

			int iMin = i; // ith position min element at each pass

			for (int j = i + 1; j < a.length; j++) {

				if (a[j] < a[iMin]) {

					iMin = j; // update the index of min element
				}
			}

			int temp = a[i];
			a[i] = a[iMin];
			a[iMin] = temp;

		}

	}

	public static void main(String[] args) {

		int[] a = { 2, 7, 5, 9, 1, 6 };

		selectionSort(a);

		for (int i : a) {
			System.out.println(i);
		}
	}

}
