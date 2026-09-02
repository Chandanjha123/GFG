class Solution {

    static int matrixMultiplication(int arr[]) {

        int n = arr.length;

        int dp[][] = new int[n][n];

        for (int[] ar : dp) {
            Arrays.fill(ar, -1);
        }

        return solve(arr, 1, n - 1, dp);
    }

    static int solve(int arr[], int i, int j, int dp[][]) {

        // Base case
        if (i >= j) {
            return 0;
        }

        // Already calculated
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int minimum = Integer.MAX_VALUE;

        for (int k = i; k <= j - 1; k++) {

            int tempans =
                solve(arr, i, k, dp)
                + solve(arr, k + 1, j, dp)
                + (arr[i - 1] * arr[k] * arr[j]);

            minimum = Math.min(minimum, tempans);
        }

        return dp[i][j] = minimum;
    }
}