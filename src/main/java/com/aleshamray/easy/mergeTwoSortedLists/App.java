package com.aleshamray.easy.mergeTwoSortedLists;


/* 

  You are given the heads of two sorted linked lists list1 and list2.

  Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

  Return the head of the merged linked list.

  Example 1:

  Input: list1 = [1,2,4], list2 = [1,3,4]
  Output: [1,1,2,3,4,4]
  Example 2:

  Input: list1 = [], list2 = []
  Output: []
  Example 3:

  Input: list1 = [], list2 = [0]
  Output: [0] 
*/

import com.aleshamray.easy.addTwoNumbers.ListNode;

public class App {

  public static void main(String[] args) {

    // ListNode l1_two = new ListNode(4, null);
    // ListNode l1_one = new ListNode(2, l1_two);
    ListNode l1 = null;

    // ListNode l2_two = new ListNode(4, null);
    // ListNode l2_one = new ListNode(3, l2_two);
    ListNode l2 = null;

    ListNode result = mergeTwoLists(l1, l2);

    System.out.print("\n[");
    while(result != null) {
      if (result.next == null) System.out.print(result.val);
      else System.out.print(result.val + ", ");
      result = result.next;
    }
    System.out.print("]\n");
    
  }

  public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
      ListNode front = new ListNode();
      ListNode current = front;

      while (list1 != null || list2 != null) {

        // if (list1 == null && list2 == null) return null;
        if (((list2 == null) && (list1 != null)) || (((list1 != null) && (list2 != null)) && list1.val <= list2.val)) {
          if (front.next == null) front.next = new ListNode(list1.val, null);
          else {
            current.next = new ListNode(list1.val);
            current = current.next;
            list1 = list1.next;
          }
        } else if (((list1 == null) && (list2 != null)) || (((list1 != null) && (list2 != null)) && list2.val < list1.val)) {
          if (front.next == null) front.next = new ListNode(list2.val, null);
          else {
            current.next = new ListNode(list2.val);
            current = current.next;
            list2 = list2.next;
          }
        }
      } 

      return front.next;
  }
  
}
