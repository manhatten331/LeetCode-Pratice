public class MaximumSubarray {
    public static void main(String[] args) {
//        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        MaximumSubarray obj = new MaximumSubarray();
        System.out.println(obj.maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        int windowSum = -10001;
        int maxSum = windowSum;

        for (int num : nums) {
            windowSum = Math.max(windowSum+num, num);

            if (windowSum > maxSum) {
                maxSum = windowSum;
            }
        }

        return maxSum;
    }
}
