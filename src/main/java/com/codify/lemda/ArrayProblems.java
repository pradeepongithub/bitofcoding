package com.codify.lemda;

public class ArrayProblems {

  // Find last index of an element in a sorted array with duplicates
  // array = {0, 1, 2, 2, 4, 5, 5, 5, 8};
  // number = 5;
  // Output:
  // Element 5 found at index 7
public static void main(String[] args) {
    int[] array = {0, 1, 2, 2, 4, 5, 5, 5, 8, 10, 10, 10, 11};
    System.out
        .println("Linear search complexity is n find last occurance of element found at index : "
        + findLastIndexOfElement(10, array));
    System.out
        .println("Binary search complexity log(n) find last occurance of element found at index : "
            + findLastIndexOfElementBinarySearch(10, array));

    System.out
        .println("Binary search complexity log(n) find first occurance of element found at index : "
            + findFirstIndexOfElementBinarySearch(10, array));
}

  private static int findLastIndexOfElement(int ele, int... arr) {
    int index = 0;
    for (int i = 0; i < arr.length; i++) {
      if (ele == arr[i]) {
        index = i;
      }
    }
    return index;

  }

  private static int findLastIndexOfElementBinarySearch(int ele, int... arr) {

    int l = 0, h = arr.length - 1, result = -1;

    while (h >= l) {
      int mid = (l + h) / 2;
      if (ele == arr[mid]) {
        result = mid;
        l = mid + 1;
      } else if (ele > arr[mid]) {
        l = mid + 1;
      } else {
        h = mid - 1;
      }
    }
    return result;
  }

  private static int findFirstIndexOfElementBinarySearch(int ele, int... arr) {

    int l = 0, h = arr.length - 1, result = -1;

    while (h >= l) {
      int mid = (l + h) / 2;
      if (ele == arr[mid]) {
        result = mid;
        h = mid - 1;
      } else if (ele > arr[mid]) {
        l = mid + 1;
      } else {
        h = mid - 1;
      }
    }
    return result;
  }

}
