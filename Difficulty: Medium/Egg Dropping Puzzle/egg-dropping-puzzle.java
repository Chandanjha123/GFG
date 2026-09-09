class Solution {

    static int eggDrop(int n, int k) {

        int dp[][] = new int[n + 1][k + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(n, k, dp);
    }

    static int solve(int n, int f, int[][] dp) {

        // Base cases
        if (n == 1) {
            return f;
        }

        if (f == 0 || f == 1) {
            return f;
        }

        // Already calculated
        if (dp[n][f] != -1) {
            return dp[n][f];
        }

        int low = 1;
        int high = f;

        int mn = Integer.MAX_VALUE;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int eggBreaks = solve(n - 1, mid - 1, dp);

            int eggNotBreaks = solve(n, f - mid, dp);

            int temp = 1 + Math.max(eggBreaks, eggNotBreaks);

            mn = Math.min(mn, temp);

            if (eggBreaks < eggNotBreaks) {
                // Need to go higher
                low = mid + 1;
            } else {
                // Need to go lower
                high = mid - 1;
            }
        }

        return dp[n][f] = mn;
    }
}