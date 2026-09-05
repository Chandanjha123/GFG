class Solution {
	
	static long[][][] dp;
	
	static int countWays(String s) {
		int n = s.length();
		
		dp = new long[n][n][2];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dp[i][j][0] = -1;
				dp[i][j][1] = -1;
			}
		}
		
		return (int) solve(s, 0, n - 1, 1);
	}
	
	static long solve(String s, int i, int j, int isTrue) {
		
		// Base case
		if (i > j) {
			return 0;
		}
		
		// Single operand
		if (i == j) {
			if (isTrue == 1) {
				return s.charAt(i) == 'T' ? 1 : 0;
			} else {
				return s.charAt(i) == 'F' ? 1 : 0;
			}
		}
		
		// Already calculated
		if (dp[i][j][isTrue] != -1) {
			return dp[i][j][isTrue];
		}
		
		long ans = 0;
		
		// Operators are at i+1, i+3, i+5...
		for (int k = i + 1; k < j; k += 2) {
			
			char op = s.charAt(k);
			
			long leftTrue =
			solve(s, i, k - 1, 1);
			
			long leftFalse =
			solve(s, i, k - 1, 0);
			
			long rightTrue =
			solve(s, k + 1, j, 1);
			
			long rightFalse =
			solve(s, k + 1, j, 0);
			
			long total = 0;
			
			if (op == '&') {
				
				if (isTrue == 1) {
					// T & T = T
					total = leftTrue * rightTrue;
				} else {
					// T&F, F&T, F&F
					total = leftTrue * rightFalse
					+ leftFalse * rightTrue
					+ leftFalse * rightFalse;
				}
				
			} else if (op == '|') {
				
				if (isTrue == 1) {
					// T|T, T|F, F|T
					total = leftTrue * rightTrue
					+ leftTrue * rightFalse
					+ leftFalse * rightTrue;
				} else {
					// F|F = F
					total = leftFalse * rightFalse;
				}
				
			} else { // '^'
				
				if (isTrue == 1) {
					// T^F, F^T
					total = leftTrue * rightFalse
					+ leftFalse * rightTrue;
				} else {
					// T^T, F^F
					total = leftTrue * rightTrue
					+ leftFalse * rightFalse;
				}
			}
			
			ans += total; }
			
			return dp[i][j][isTrue] = ans;
		}
	}
