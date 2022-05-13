class Solution {
		public int coinChange (int[] coins, int amount) {
			int[] dp = new int[amount + 1];
			for (int i = 0; i < dp.length; i++) {
				dp[i] = -1;
			}
			dp[0] = 0;
			for (int i = 0; i < coins.length; i++) {
				for (int j = 0; j < dp.length; j++) {
					if (j - coins[i] >= 0 && dp[j - coins[i]] != -1) {
						if (j - coins[i] >= 0) {
							if (dp[j] != -1) {
								dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]);
							} else {
								dp[j] = dp[j - coins[i]] + 1;
							}
						}
					}
				}
			}
			return dp[dp.length - 1];
		}
	}