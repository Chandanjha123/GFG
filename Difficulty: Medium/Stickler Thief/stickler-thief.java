class Solution {
	int dp[];
	public int findMaxSum(int arr[]) {
		int n = arr.length;
		dp = new int[n + 1];
		return solve(0, n, arr, dp);
	}
	public int solve(int i, int n, int[] arr, int[] dp) {
		if (i >= n) {
			return 0;
		}
		if (dp[i] != 0) {
			return dp[i];
		}
		int pick = arr[i]+solve(i + 2, n, arr, dp);
		int noPick = solve(i + 1, n, arr, dp);
		return dp[i] = Math.max(pick, noPick);
	}
}
