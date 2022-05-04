public class MonotonicArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 3, 4};
        int[] nums2 = {6, 5, 4, 4, 1};
        // nums = [1, 12, 1]
        //  1, 0

        MonotonicArray obj = new MonotonicArray();
        System.out.println(obj.isMonotonic(nums1));
        System.out.println(obj.isMonotonic(nums2));
    }

    public boolean isDecreasing(int[] nums) {
        int pastNum;
        for (int i = 1; i < nums.length; i++) {
            pastNum = nums[i - 1];

            if (nums[i] > pastNum) {
                return false;
            }
        }
        return true;
    }

    public boolean isIncreasing(int[] nums) {
        int pastNum;
        for (int i = 1; i < nums.length; i++) {
            pastNum = nums[i - 1];

            if (nums[i] < pastNum) {
                return false;
            }
        }
        return true;
    }

    public boolean isMonotonic(int[] nums) {
        return isIncreasing(nums) || isDecreasing(nums);
    }
}
