/*
For each house check waht if paint red or blue or green
If we paint red, then minimum cost to print all the housed while painting this house red is
min of cost of painting prev green or blue + cost to paid the current house red
*/
class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[n][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        for(int i=1;i<n;i++){
            int[] cost = costs[i];
            int red = cost[0];
            int green = cost[1];
            int blue = cost[2];

            int prev_red = dp[i-1][0];
            int prev_green = dp[i-1][1];
            int prev_blue = dp[i-1][2];

            dp[i][0] = Math.min(prev_blue,prev_green) + red;
            dp[i][1] = Math.min(prev_blue,prev_red) + green;
            dp[i][2] = Math.min(prev_red,prev_green) + blue;
        }



        return Math.min(dp[n-1][0],Math.min(dp[n-1][1],dp[n-1][2]));
    }
}