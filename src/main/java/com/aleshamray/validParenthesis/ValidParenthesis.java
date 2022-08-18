package com.aleshamray.validParenthesis;
/* 
  * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

  * An input string is valid if:
  * 
  * Open brackets must be closed by the same type of brackets.
  * Open brackets must be closed in the correct order.
  * 
  * 
  * Example 1:
  * 
  * Input: s = "()"
  * Output: true
  * Example 2:
  * 
  * Input: s = "()[]{}"
  * Output: true
  * Example 3:
  * 
  * Input: s = "(]"
  * Output: false
  * 
  * 
  * Constraints:
  * 
  * 1 <= s.length <= 104
  * s consists of parentheses only '()[]{}'.
 */

import java.util.Stack;

public class ValidParenthesis {
  
  public static void main(String[] args) {

    System.out.println();
    System.out.println("expected: true, received: " + ValidParenthesis.solution("()"));
    System.out.println("expected: true, received: " + ValidParenthesis.solution("()[]{}"));
    System.out.println("expected: false, received: " + ValidParenthesis.solution("(]"));
    System.out.println("expected: true, received: " + ValidParenthesis.solution("(({{({[[()]]})}}))"));
    System.out.println("expected: false, received: " + ValidParenthesis.solution("(){[)[[}}){{(})}}]]]})"));
    System.out.println("expected: false, received: " + ValidParenthesis.solution("{]]((("));
    System.out.println("expected: false, received: " + ValidParenthesis.solution("(])"));
    System.out.println();
    
  }

  public static boolean solution(String s) {
    
    // create a stack object
    Stack<String> stack = new Stack<>();

    for (Character currentValue : s.toCharArray()) {
      String cur = currentValue.toString();

      switch(cur) {
        case "(":
        case "{":
        case "[":
          stack.push(cur);
          break;
        case ")":
          if (stack.empty()) return false;
          if (stack.peek().equals("(")) stack.pop();
          else return false;
          break;
        case "}":
          if (stack.empty()) return false;
          if (stack.peek().equals("{")) stack.pop();
          else return false;
          break;
        case "]":
          if (stack.empty()) return false;
          if (stack.peek().equals("[")) stack.pop();
          else return false;
          break;
      }
    }
    
    return stack.empty();
  }
}