class Solution {
	public int countPartitions(int[] arr, int diff) {
		int n = arr.length;
		int sum = 0;
		for (int i:arr) {
			sum += i;
		}
		
		if ((sum + diff)%2 != 0)
			return 0;
		if (diff>sum)
			return 0;
		
		int s1 = (sum + diff)/2;
		
		int[][] dp = new int[n + 1][s1 + 1];
		for (int i = 0; i <= n; i++) {
			dp[i][0] = 1;
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= s1; j++) {
				if (arr[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j - arr[i - 1]]+dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n][s1];
	}
	
}
