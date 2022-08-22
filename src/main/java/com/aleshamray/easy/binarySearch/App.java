package com.aleshamray.easy.binarySearch;

public class App {
  public static void main(String[] args) {
    int size = 10000;

    int[] nums = Helper.generateSortedArray(size);
    // for(int[] arr : Helper.getTestValues().keySet()) { nums = arr; }
    
    int target = (int)Math.floor(Math.random()*(10000-(-10000)+1)+(-10000));
    // int target = Helper.generateTargetInArray(nums);
    // for(int val : Helper.getTestValues().values()) { target = val; }


    System.out.println("\ntarget: " + target + "\n");

    System.out.println("expected: " + Helper.findIndex(nums, target) + "; received: " + App.search(nums, target));
  }
  

  public static int search(int[] nums, int target) {
    return Helper.searchHelper(nums, 0, nums.length-1, target);
  }
}


/* 
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 * 
 * 
 * Example 2:
 * 
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 104
 * -104 < nums[i], target < 104
 * All the integers in nums are unique.
 * nums is sorted in ascending order.
 */