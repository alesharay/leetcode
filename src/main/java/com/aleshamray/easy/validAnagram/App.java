package com.aleshamray.easy.validAnagram;

public class App {

  public static void main(String[] args) {
    String s1 = "anagram", t1 = "nagaram";
    String s2 = "rat", t2 = "car";
    String s3 = "ab", t3 = "a";

    System.out.println();
    System.out.println("expected: true; received: " + (App.isAnagram(s1, t1) ? "true" : "false"));
    System.out.println("expected: false; received: " + (App.isAnagram(s2, t2) ? "true" : "false"));
    System.out.println("expected: false; received: " + (App.isAnagram(s3, t3) ? "true" : "false"));
    System.out.println();
  }

  public static boolean isAnagram(String s, String t) {
    if (s.length() != t.length() || 
    (s.isEmpty() && !t.isEmpty() ||
    (!s.isEmpty() && t.isEmpty()))) return false;

    for (String letter : s.split("")) {
      if (t.contains(letter)) t = t.replaceFirst(letter, "");
    } 

    return t.isEmpty();
  }
}

/* 
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 * 
 * Example 1:
 * 
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 * 
 * Input: s = "rat", t = "car"
 * Output: false 
 * 
 * Constraints:
 * 
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 *  
 * Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 */
