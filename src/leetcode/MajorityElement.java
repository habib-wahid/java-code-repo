package leetcode;

public class MajorityElement {

    public static int majorityElement(int[] nums) {
        int len = nums.length;
        int count = 0; int ans = nums[0];

        for(int x : nums) {
            if (count == 0) {
                ans = x;
            }

            if (x == ans) {
                count++;
            } else {
                count--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }
}
