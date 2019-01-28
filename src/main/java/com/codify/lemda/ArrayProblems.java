package com.codify.lemda;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

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
    int[] arr = {2, 5, 9, 1, 5, 1, 8, 2, 8, 9, 5};
    findNumberOccursOddTimes(arr);
    findNumberOccursOddTimesHash(arr);

    findPairWithGivenSum(6, arr);
    findAllPairsForGivenSum(6, arr);

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

  private static void findNumberOccursOddTimes(int... arr) {

    int num = arr[0];

    for (int i = 1; i < arr.length; i++) {
      num = num ^ arr[i];

    }

    System.out.println("Number is : " + num);

  }

  private static void findNumberOccursOddTimesHash(int... arr) {

    Map<Integer, Integer> map = new HashMap<>();
    int number = 0, occurance = 0;

    for (int i = 0; i < arr.length; i++) {
      if (map.containsKey(arr[i])) {
        map.put(arr[i], map.get(arr[i]) + 1);
      } else
      map.put(arr[i], 1);
    }

    for (Entry<Integer, Integer> m : map.entrySet()) {
      if (m.getValue() % 2 != 0) {
        number = m.getKey();
        occurance = m.getValue();
        break;
      }
    }

    System.out.println("Hash Algo Number is : " + number + " occurs : " + occurance + " times");
  }

  private static void findPairWithGivenSum(int sum, int... arr) {

    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < arr.length; i++) {
      if (map.containsKey(sum - arr[i])) {
        System.out.println("Pair found at index " + map.get(sum - arr[i]) + " and " + i);
        return;
      }
      map.put(arr[i], i);
    }

    System.out.println("Pair not found");
  }

  private static void findAllPairsForGivenSum(int sum, int... arr) {

    Map<Integer, Integer> map = new HashMap<>();

    StringBuilder strBuilder = new StringBuilder();

    for (int i = 0; i < arr.length; i++) {
      if (map.containsKey(sum - arr[i])) {
        strBuilder.append(" (").append(map.get(sum - arr[i])).append(", ").append(i).append(") ");
      }
      map.put(arr[i], i);

    }

    System.out.println("Pair for a given sum are : " + strBuilder);

  }



}
