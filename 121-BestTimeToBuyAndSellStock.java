class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int min = prices[0]; // minimum element
        int max; // max element
        int profit;
        // for i = 0; min = prices[0]; profit = 0
        for (int i = 1; i < prices.length; i++) {
            min = (prices[i] < min) ? prices[i] : min;
            profit = prices[i] - min;
            maxProfit = (profit > maxProfit) ? profit : maxProfit;
        }
        max = min + maxProfit;
        return maxProfit;
    }
}

/*
0 ms run time
class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            } else if (prices[i] - buy > profit) {
                profit = prices[i] - buy;
            }
        }
        return profit;
    }
}

*/