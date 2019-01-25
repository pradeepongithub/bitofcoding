package com.codify.lemda;

public class ArrayProblems {

  // Find last index of an element in a sorted array with duplicates
  // array = {0, 1, 2, 2, 4, 5, 5, 5, 8};
  // number = 5;
  // Output:
  // Element 5 found at index 7
public static void main(String[] args) {
    int[] array = {0, 1, 2, 2, 4, 5, 5, 5, 8};
    System.out.println("Linear search complexity is n Element found at index : "
        + findLastIndexOfElement(5, array));
    System.out.println("Binary search complexity log(n) Element found at index : "
        + findLastIndexOfElementBinarySearch(5, array));
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

    int l = 0, h = arr.length - 1, mid = (l + h) / 2;

    while (h > l) {
      if (ele == arr[mid]) {
        return mid + 1;
      } else if (ele > arr[mid]) {
        l = mid + 1;
      } else {
        h = mid - 1;
      }
      mid = (l + h) / 2;
    }
    return -1;
  }

}
