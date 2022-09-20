package com.aleshamray.easy.queueUsingStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyQueue {

  private Deque<Integer> stack;

  public MyQueue() {
    stack = new ArrayDeque<Integer>();
  }
  
  public void push(int x) {
    stack.push(x);
  }
  
  public int pop() {

    Deque<Integer> tempStack = new ArrayDeque<>();
    int result = 0;

    while(stack.peek() != null) {
      tempStack.push(stack.pop());
    }

    result = tempStack.pop();

    while(tempStack.peek() != null) {
      stack.push(tempStack.pop());
    }

    return result;
  }
  
  public int peek() {
    Deque<Integer> tempStack = new ArrayDeque<>();
    int result = 0;

    while(stack.peek() != null) {
      tempStack.push(stack.pop());
    }

    result = tempStack.peek();

    while(tempStack.peek() != null) {
      stack.push(tempStack.pop());
    }

    return result;
  }
  
  public boolean empty() {
    return stack.isEmpty();
  }
}
