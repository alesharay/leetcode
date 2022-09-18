package com.aleshamray.easy.linkedListCycle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class App {

  public static void main(String[] args) {
    int[] valArr = new int[]{3,2,0,-4};
    ListNode head = createLinkedList(valArr, 1);
    boolean result = hasCycle(head);
    System.out.printf("expected: true ; received: %b\n", result); 

    valArr = new int[]{5};
    head = createLinkedList(valArr, 0);
    result = hasCycle(head);
    System.out.printf("expected: true ; received: %b\n", result);

    valArr = new int[]{1,2};
    head = createLinkedList(valArr, 0);
    result = hasCycle(head);
    System.out.printf("expected: true ; received: %b\n", result);

    valArr = new int[]{1};
    head = createLinkedList(valArr, -1);
    result = hasCycle(head);
    System.out.printf("expected: false ; received: %b\n", result);
    
    valArr = new int[]{};
    head = createLinkedList(valArr, -1);
    result = hasCycle(head);
    System.out.printf("expected: false ; received: %b\n", result);
  }

  public static ListNode createLinkedList(int[] arr, int pos) {    
    ListNode list = null; 
    ListNode head = null;
    int currentPos = 0;
    HashMap<Integer, ListNode> positions = new HashMap<>();

    for(Integer value : arr) {
      if (head == null) {
        head = new ListNode(value);
        list = head;
        positions.put(currentPos, head);
      } else {
        head.next = new ListNode(value);
        positions.put(currentPos, head);
        currentPos++;
        head = head.next;
      }
    }
    
    if (pos != -1) {
      head.next = positions.get(pos);      
    }

    return list;
  }

  public static void displayList(ListNode head, int pos) {

    // System.out.print("\n[");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("\n[");
    while(head != null) {
      // System.out.print(head.val + ", ");
      stringBuilder.append(String.valueOf(head.val) + ", ");
      head = head.next;
    }
    // System.out.println("]\n");
    stringBuilder.append("]\n");

    System.out.println(stringBuilder);
  }

  public static boolean hasCycle(ListNode head) {
    if (head == null) { return false; }
    ListNode node = head;
    List<ListNode> nodes = new ArrayList<>();
    boolean nodeInRange = (node.val >= -10000) && (node.val <= 100000);

    while(node != null && nodeInRange) {
      if (nodes.contains(node)) { return true; } 
      nodes.add(node);
      node = node.next;
    } 

    return false;
  }
}
