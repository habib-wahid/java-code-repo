package leetcode.interviewprep;

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

    public int solution(int[] cost) {
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

    static void main() {
        DynamicProgramming dp = new DynamicProgramming();

       // int[] nums = new int[] {1,2,1,2,1,1,1};
        //System.out.println(dp.solution(nums));

        String s = "bbba";
        System.out.println(longestPalindromicSubString(s));

        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>();
        findSubStringRec(s, s.length(), 0, sb, result);
       // System.out.println(result);

        int[] nums = new int[]{9, 1,2, 1};

       // System.out.println(LIS(nums));
    }
}
