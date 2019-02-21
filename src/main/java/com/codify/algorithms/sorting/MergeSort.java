package com.codify.algorithms.sorting;

public class MergeSort {

	public static void mergeSort(int... a) {

		int l = a.length;

		if (l < 2) {
			return;
		}

		int mid = l / 2;

		int[] left = new int[mid];
		int[] right = new int[l - mid];

		for (int i = 0; i < mid; i++) {
			left[i] = a[i];
		}

		for (int i = mid; i < l; i++) {
			right[i - mid] = a[i];
		}

		mergeSort(left);
		mergeSort(right);
		merge(left, right, a);

	}

	private static void merge(int[] left, int[] right, int[] a) {

		int i = 0, j = 0, k = 0;
		int nl = left.length, nr = right.length;

		while (i < nl && j < nr) {

			if (left[i] <= right[j]) {
				a[k] = left[i];
				i++;
				k++;
			} else {
				a[k] = right[j];
				j++;
				k++;
			}
		}

		while (i < nl) {
			a[k] = left[i];
			i++;
			k++;
		}

		while (j < nr) {
			a[k] = right[j];
			j++;
			k++;
		}

	}

	public static void main(String[] args) {

		int[] a = { 4, 6, 9, 2, 1, 7, 5, 3, 1, 2, 55, 8, 11, 20 };
		mergeSort(a);

		for (int i : a) {
			System.out.println(i);
		}

	}

}
