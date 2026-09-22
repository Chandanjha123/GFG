class Solution {
	int dp[];
	
	int minCost(int[] height) {
		
		int n = height.length;
		dp = new int[n + 1];
		Arrays.fill(dp, -1);
		
		return solve(0, n, height, dp);
		
	}
	int solve(int i, int n, int[] height, int[]dp) {
		if (i >= n - 1) {
			return 0;
		}
		if (i == n - 2) {
			return Math.abs(height[i] - height[n - 1]);
		}
		if (dp[i] != -1) {
			return dp[i];
		}
		int firstStair = Math.abs(height[i]-height[i + 1]) + solve(i + 1, n, height, dp);
		
		int secondStair = Math.abs(height[i]-height[i + 2]) + solve(i + 2, n, height, dp);
		
		int	result = Math.min(firstStair, secondStair);
		
		return dp[i] = result;
	}
}
