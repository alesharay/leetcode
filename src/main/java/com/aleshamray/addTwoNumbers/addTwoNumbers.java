package com.aleshamray.addTwoNumbers;

/* 
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * 
 */

public class addTwoNumbers {
  
  public static void main(String[] args) {
    ListNode l1_two = new ListNode(3, null);
    ListNode l1_one = new ListNode(4, l1_two);
    ListNode l1 = new ListNode(2, l1_one);

    ListNode l2_two = new ListNode(4, null);
    ListNode l2_one = new ListNode(6, l2_two);
    ListNode l2 = new ListNode(5, l2_one);

    ListNode result = addTwoNumbers.solution(l1, l2);

    ListNode temp = result;
    while (true) {
      if ( temp == null ) break;
      System.out.print(temp.val + ", ");
      temp = temp.next;
    }
    System.out.println();
  }

  public static ListNode solution(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode curr = dummyHead;
    int carry = 0;
    while (l1 != null || l2 != null || carry != 0) {
        int x = (l1 != null) ? l1.val : 0;
        int y = (l2 != null) ? l2.val : 0;
        int sum = carry + x + y;
        carry = sum / 10;
        curr.next = new ListNode(sum % 10);
        curr = curr.next;
        if (l1 != null)
            l1 = l1.next;
        if (l2 != null)
            l2 = l2.next;
    }
    return dummyHead.next;
  }

}
