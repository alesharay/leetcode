package com.aleshamray.easy.buyAndSellStock;

/* 
 * You are given an array of prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * 
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * 
 * Example 1:
 * 
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * 
 * Example 2:
 * 
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 * 
 * 
 * Constraints:
 * 
 * 1 <= prices.length <= 10^5
 * 0 <= prices[i] <= 10^4
 * 
 */

public class App {
  public static void main(String[] args) {
    
    int[] prices = new int[]{7,1,5,6,3,4};
    System.out.println("expected: 5, received: " + App.solution(prices));
    
    prices = new int[]{7,6,4,3,1};
    System.out.println("expected: 0, received: " + App.solution(prices));
  }

  // public static int solution(int[] prices) {

  //   // set a max item
  //   int max = 0;
  //   // for each item in the array
  //   for (int i = 0; i < prices.length; i++) {
  //     // for each next item in the array
  //     for (int j = i+1; j < prices.length; j++) {
  //       // if the price on the next day minus the price on the current day is more than the max item
  //       int profit = prices[j] - prices[i];
  //       if (profit > max) {
  //         // set the max item ammount
  //         max = profit;
  //       }
  //     }
  //   }
  //   // return the max item amount
  //   return max;
  // }

  public static int solution(int[] prices) {

    // set the max int as the least possible price
    int least = Integer.MAX_VALUE;
    // create current and total profit
    int currentProfit = 0, totalProfit = 0;

    // for each price in prices
    for (int i = 0; i < prices.length; i++) {
      // if the current price is less than the least possible price
      if (prices[i] < least) {
        // set the current price as the least possible price
        least = prices[i];
      }
      // set the current profit as the current price minus the least possible price
      currentProfit = prices[i] - least;
      // if the total profit is less than the current profit
      if (totalProfit < currentProfit) {
        // set the total profit to the current profit
        totalProfit = currentProfit;
      }
    }
    // return total profit
    return totalProfit;
  }
}
