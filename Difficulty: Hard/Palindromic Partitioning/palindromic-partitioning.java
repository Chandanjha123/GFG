class Solution {

    int dp[][] = new int[1001][1001];

    public int palPartition(String s) {
        int n = s.length();

        for (int ar[] : dp) {
            Arrays.fill(ar, -1);
        }

        return solve(s, 0, n - 1, dp);
    }

    boolean isPalindrome(String s, int i, int j) {

        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    int solve(String s, int i, int j, int[][] dp) {

        // Base case
        if (i >= j) {
            return 0;
        }

        // Whole substring is palindrome
        if (isPalindrome(s, i, j)) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int minimum = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {

            // IMPORTANT OPTIMIZATION
            if (isPalindrome(s, i, k)) {

                int left = solve(s, i, k, dp);
                int right = solve(s, k + 1, j, dp);

                int tempans = left + right + 1;

                minimum = Math.min(minimum, tempans);
            }
        }

        return dp[i][j] = minimum;
    }
}