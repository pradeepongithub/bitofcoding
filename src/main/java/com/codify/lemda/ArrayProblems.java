package com.codify.lemda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    int[] A = {3, 4, -7, 1, 3, 3, 1, -4};
    int sum = 7;

    printallSubarrays(A, sum);

    printAllSubArrayForGivenSum(36, arr);



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

  // Utility function to insert <key, value> pair into the Multimap
  private static <K, V> void insert(Map<K, List<V>> hashMap, K key, V value) {
    // if the key is seen for the first time, initialize the list
    if (!hashMap.containsKey(key)) {
      hashMap.put(key, new ArrayList<>());
    }

    hashMap.get(key).add(value);
  }

  // Utility function to print a subarray A[i, j]
  public static void printSubarray(int[] A, int i, int j) {
    System.out.print("[" + i + ".." + j + "] -- { ");
    for (int k = i; k <= j; k++) {
      System.out.print(A[k] + " ");
    }

    System.out.println("}");
  }

  // Function to find subarrays with given sum in an array
  public static void printallSubarrays(int[] A, int sum) {
    // create a map for storing end index of all subarrays with
    // sum of elements so far
    Map<Integer, List<Integer>> hashMap = new HashMap<>();

    // To handle the case when the subarray with given sum starts
    // from 0th index
    insert(hashMap, 0, -1);

    int sum_so_far = 0;

    // traverse the given array
    for (int index = 0; index < A.length; index++) {
      // sum of elements so far
      sum_so_far += A[index];

      // check if there exists at-least one sub-array with given sum
      if (hashMap.containsKey(sum_so_far - sum)) {
        List<Integer> list = hashMap.get(sum_so_far - sum);
        for (Integer value : list) {
          printSubarray(A, value + 1, index);
        }
      }

      // insert (sum so far, current index) pair into the map
      insert(hashMap, sum_so_far, index);
    }
  }

  private static void printAllSubArrayForGivenSum(int sum, int... arr) {

    int[] arr1 = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      arr1[i] = arr[i] * arr[i];
    }

    Map<Integer, List<Integer>> hashMap = new HashMap<>();

    insert(hashMap, 0, -1);

    int sum_so_far = 0;

    for (int index = 0; index < arr1.length; index++) {
      // sum of elements so far
      sum_so_far += arr[index];

      // check if there exists at-least one sub-array with given sum
      if (hashMap.containsKey(sum_so_far - sum)) {
        List<Integer> list = hashMap.get(sum_so_far - sum);
        for (Integer value : list) {
          printSubarray(arr, value + 1, index);
        }
      }

      // insert (sum so far, current index) pair into the map
      insert(hashMap, sum_so_far, index);
    }

  }



}
