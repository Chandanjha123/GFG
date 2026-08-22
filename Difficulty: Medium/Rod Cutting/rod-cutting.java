class Solution {
	public int cutRod(int[] price) {
		int n = price.length;
		int w = n;
		int length[] = new int[n];
		for (int i = 0; i<n; i++) {
			length[i] = i + 1;
		}
		int [][]dp = new int[n + 1][w + 1];
		
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= w; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else {
					
					if (length[i - 1] <= j) {
						dp[i][j] = Math.max(price[i - 1]+dp[i][j - length[i - 1]], dp[i - 1][j]);
					} else {
						dp[i][j] = dp[i - 1][j];
					}
				}
			}
		}
		return dp[n][w];
	}
}
