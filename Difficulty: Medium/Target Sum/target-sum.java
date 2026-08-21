class Solution {
	public int totalWays(int[] arr, int target) {
		int sum=0;
        for(int i:arr){
            sum += i;
        }
        target=-(target);
        if((sum+target)%2!=0) return 0;
        if(target>sum) return 0;
        int s1=(sum+target)/2;
		int n = arr.length;
		int dp[][] = new int[n + 1][s1 + 1];
		for (int i = 0; i <= n; i++) {
			dp[i][0] = 1;
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= s1; j++) {
				if (arr[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		
		return dp[n][s1];
	}
}
