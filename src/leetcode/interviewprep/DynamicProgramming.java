package leetcode.interviewprep;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicProgramming {


    private int ans = 0;
    private int[][] dp = new int[30][3];

    public int searchPath(int currentStair, int target) {
        if (currentStair > target)
            return 0;

        if (currentStair == target){
            return 1;
        }

        dp[currentStair][1] = searchPath(currentStair + 1, target);
        dp[currentStair][2] =  searchPath(currentStair + 2, target);

        return dp[currentStair][1] + dp[currentStair][2];

    }


    public int climbStairs(int n) {
        return searchPath(0, n);
       // return ans;
    }

    public int rob(int[] nums) {
        var n = nums.length;
        int[] dp = new int[n];
        int maxSum = 0;

        for (int i = 0; i < n; i++) {
          calculateSum(nums, dp, i );
        }

        for (int i = 0; i < n; i++) {
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }

  //  nums=[5,1,2,10,6,2,7,9,3,1]

    public int calculateSum(int[] nums, int[] dp, int index) {
        if (index >= nums.length) {
            return 0;
        }

        if (dp[index] != 0) {
            return dp[index];
        }

        if (index == nums.length - 1) {
            dp[index] = nums[index];
            return dp[index];
        }

        int currentSum = 0;

        for (int i = index + 2; i < nums.length; i++) {
            currentSum = Math.max(currentSum, calculateSum(nums, dp, i));
        }

        dp[index] = currentSum + nums[index];

        return dp[index];
    }

    public int wordBreak(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];

        Arrays.fill(dp, -1);

        minCost(cost, 0, n, dp);

        return Math.min(dp[0], dp[1]);
    }

    public int minCost(int[] cost, int index, int len, int[] dp) {
        if (index >= len) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        dp[index] = Math.min(minCost(cost, index + 1, len, dp) + cost[index], minCost(cost, index + 2, len, dp) + cost[index]);

        return dp[index];
    }

    public static List<String> findSubString(String s) {
        List<String> result = new ArrayList<>();
        int len = s.length();

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                result.add(s.substring(i, j + 1));
            }
        }

        return result;
    }

    public static void findSubStringRec(String s, int len, int index, StringBuilder cur, List<String> result) {
        if (index >= len)
            return;

        cur.append(s.charAt(index));
        result.add(cur.toString());
        findSubStringRec(s, len, index + 1, cur, result);

        cur.deleteCharAt(cur.length() - 1);

        if (cur.isEmpty()) {
            findSubStringRec(s, len, index + 1, cur, result);
        }

    }

    public static int LIS(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int max = 0;

        Arrays.fill(res, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    res[i] = Math.max(res[i], res[j] + 1);
                    max = Math.max(max, res[i]);
                }
            }
        }

        return max;

    }

    public static String longestPalindromicSubString(String s) {
        int len = s.length();
        int maxLen = 1;
        String result = s.substring(0, 1);

        for (int i = 0; i < len-1; i++) {

            if (i-1 >=0 && s.charAt(i -1) == s.charAt(i + 1)) {
                int j = i - 1;
                int k = i + 1;

                while (j >= 0 && k < len && s.charAt(j) == s.charAt(k)) {
                    j--;
                    k++;
                }

                String sub = s.substring(j + 1, k);
                if (sub.length() > maxLen) {
                    maxLen = sub.length();
                    result = sub;
                }
            }

            if (s.charAt(i) == s.charAt(i + 1)) {
                int j = i - 1;
                int k = i + 2;

                while (j>=0 && k < len && s.charAt(j) == s.charAt(k)) {
                    j--;
                    k++;
                }

                String sub = s.substring(j + 1, k);
                if (sub.length() > maxLen) {
                    maxLen = sub.length();
                    result = sub;
                }
            }

        }

        return result;
    }

    public static int change(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int currentAmount = 1; currentAmount <= amount; currentAmount++) {
            for (int coin : coins) {
                if (currentAmount - coin >= 0) {
                    dp[currentAmount] = Math.min(dp[currentAmount], 1 + dp[currentAmount - coin]);
                }
            }
        }

        return dp[amount] == max ? -1 : dp[amount];
    }

    public static int path(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++)
            dp[i][0] = 1;
        for (int j = 0; j < n; j++)
            dp[0][j] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n -1];
    }

    public static int countWays(String s) {
        if (s.startsWith("0")) return 0;
        int len = s.length();

        int res = 1;
        for (int i = 1; i < len; i++) {
            if (i + 1 < len && s.charAt(i + 1) == '0')
                continue;

            String st = s.substring(i - 1, i + 1);
            int val = Integer.parseInt(st);


            if (s.charAt(i) == '0') {
                if (val <= 0 || val > 26) return 0;
            }
            else {
                if (val > 9 && val <= 26)
                    res++;
            }

        }

        return res;

    }

    public static boolean wordBreak(String s, List<String> dict) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[s.length()];

        queue.offer(0);

        while (!queue.isEmpty()) {
            int idx = queue.poll();

            if (idx >= s.length())
                return true;

            if (!visited[idx]) {
                for (String word : dict) {
                    if (s.startsWith(word, idx)) {
                        queue.offer(idx + word.length());
                    }
                }
            }

            visited[idx] = true;
        }


        return false;
    }

    public static int maxiMumProduct(int[] nums) {
        int globalMax = nums[0];
        int currentMax = nums[0];
        int currentMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int tempMax = Math.max(nums[i], Math.max(currentMax * nums[i], currentMin * nums[i]));
            currentMin = Math.min(nums[i], Math.min(currentMax * nums[i], currentMin * nums[i]));
            currentMax = tempMax;

            globalMax = Math.max(globalMax, currentMax);
        }

        return globalMax;

    }

    public static int editDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <=m ; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <=n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                }
            }
        }

        return dp[m][n];
    }

    static void main() {
        DynamicProgramming dp = new DynamicProgramming();

        int[] nums = new int[] {-3, -4, -2};
      //  System.out.println(maxiMumProduct(nums));

        int[] coins = new int[] {5,10};
        int amount = 16;

       // System.out.println(countWays("2101"));
       // change(coins, amount);


        String s = "bbba";
       // System.out.println(longestPalindromicSubString(s));

        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>();
        findSubStringRec(s, s.length(), 0, sb, result);
       // System.out.println(result);

       // int[] nums = new int[]{9, 1,2, 1};

       // System.out.println(LIS(nums));

      //  System.out.println(wordBreak("aaaaaa", Arrays.asList("a","aa","aaa")));

        System.out.println(editDistance("a", "b"));
    }
}
