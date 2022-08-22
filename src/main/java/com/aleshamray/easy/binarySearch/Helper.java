package com.aleshamray.easy.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Helper {

  public static Map<int[], Integer> values = new HashMap<>();

  public static int[] generateSortedArray(int size) {
    int[] arr = new int[size];
    List<Integer> uniqueNums = new ArrayList<>();
    int num = (int)Math.floor(Math.random()*(10000-(-10000)+1)+(-10000));

    for (int i = 0 ; i < size; i++) {
      while(uniqueNums.contains(num)) { 
        num = (int)Math.floor(Math.random()*(10000-(-10000)+1)+(-10000)); 
      }
      uniqueNums.add(num);
    }

    Collections.sort(uniqueNums);
    arr = uniqueNums.stream().mapToInt(Integer::intValue).toArray();

    // System.out.println();
    // System.out.print("[");
    // for (int i = 0 ; i < size; i++) {
    //   if (i < size-1) System.out.print(arr[i] + ",");
    //   else System.out.print(arr[i]);
    // } 
    // System.out.print("]");
    // System.out.println();

    return arr;
  }

  public static int generateTargetInArray(int[] arr) {

    int randomIndex = (int)Math.floor(Math.random()*(arr.length+1)); 

    return arr[randomIndex];
  }

  public static int findIndex(int arr[], int t)
  {

      int index = Arrays.binarySearch(arr, t);
      return (index < 0) ? -1 : index;
  }

  public static Map<int[], Integer> getTestValues() {
    int[] arr = new int[]{-5876,-5869,-5593,-4699,-4061,-3919,-3612,-2446,-959,-34,162,325,867,4759,5160,5746,6356,6474,7493,7506};

    int target = 7493;

    values.put(arr, target);

    return values;
  }

  public static int searchHelper(int[] nums, int start, int end, int target) {

    if (nums.length == 0) return -1;

    if (target > nums[end] || target < nums[start]) return -1;

    int halfNums = (start + end) / 2;
    int mid = nums[halfNums];

    if (target == mid) return halfNums;
    else if (target < mid) {
      return searchHelper(nums, 0,  halfNums, target);
    } else {
      return searchHelper(nums, halfNums+1, end, target);
    }
  }

}
