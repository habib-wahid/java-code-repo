package leetcode;

public class KthLargestElement {
    public int largestElement(int[] nums, int k) {
        int len = nums.length;

        if (len == 1)
            return nums[0];
        for (int i = len/2 - 1; i >= 0; i--) {
            heapify(nums, i, len);
        }


        if (k == 1)
            return nums[0];

        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
        //delete(nums, k);
        return nums[0];
    }

    public void heapify(int[] nums, int i, int len) {
        int largest = i;
        int leftIndex = 2 * i + 1;
        int rightIndex = 2 * i + 2;

        if (leftIndex >= 0 && leftIndex < len && nums[leftIndex] > nums[largest]) {
            largest = leftIndex;
        }

        if (rightIndex >= 0 && rightIndex < len && nums[rightIndex] > nums[largest]) {
            largest = rightIndex;
        }

        if (largest != i) {
            int temp = nums[i];
            nums[i] = nums[largest];
            nums[largest] = temp;
        }
    }

    public void delete(int[] nums, int k) {
        int len = nums.length;
        while (k-- > 1) {
            int temp = nums[0];
            nums[0] = nums[len-1];
            nums[len-1] = temp;
            len--;

            heapify(nums, 0, len);

        }
    }
    public static void main(String[] args) {
        int[] nums = new int[] {3,2,1,5,6,4};
        System.out.println(new KthLargestElement().largestElement(nums, 2));
    }
}
