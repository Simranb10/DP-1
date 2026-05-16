//Coin Change
//Time Complexity: O(m*n) where m is the amount and n is the number of coins
//Space Complexity: O(m) where m is the amount

public class CoinChange {
    int dp[];
    public int CoinChange(int[] coins, int amount) {
        dp = new int[amount+1];

        dp[0] = 0;
        for(int i = 1; i <= amount; i++) {
            dp[i] = 99999;
        }

        for(int i = 1; i <= coins.length; i++) {
            for (int amt=1; amt<= amount; amt++) {
                if(amt >= coins[i-1]) {
                    dp[amt] = Math.min(1 + dp[amt - coins[i - 1]], dp[amt]);
                }
            }
        }
        return dp[amount] == 99999 ? -1 : dp[amount];
    }
}
