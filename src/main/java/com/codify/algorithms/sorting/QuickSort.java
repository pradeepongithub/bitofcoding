package com.codify.algorithms.sorting;

public class QuickSort {

	public static void quickSort(int start, int end, int... a) {

		if (start < end) {

			int pIndex = partition(start, end, a);

			quickSort(start, pIndex - 1, a);

			quickSort(pIndex + 1, end, a);
		}
	}

	private static int partition(int start, int end, int[] a) {

		int pivot = a[end];
		int pIndex = start;

		for (int i = start; i < end; i++) {

			if (a[i] <= pivot) {

				swap(i, pIndex, a);
				pIndex++;
			}
		}

		swap(pIndex, end, a);

		return pIndex;
	}

	private static void swap(int i, int j, int[] a) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;

	}

	public static void main(String[] args) {
		
		int[] a = { 4, 6, 9, 2, 1, 7, 5, 3, 1, 2, 55, 8, 11, 20,-4,-3,-12 };
		quickSort(0, a.length - 1, a);

		for (int i : a) {
			System.out.println(i);
		}
	}

}
