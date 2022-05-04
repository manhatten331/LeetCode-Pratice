import java.util.Arrays;

public class NextGreaterElement {
    public static void main(String args[]) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};

        NextGreaterElement obj = new NextGreaterElement();

        int[] ints = obj.nextGreaterElement(nums1, nums2);

        System.out.println(Arrays.toString(ints));
    }

    public int findIndex(int numFromNums1, int[] nums2) {
        for (int j = 0; j < nums2.length; j++) {
            if (numFromNums1 == nums2[j]) {
                return j;

            }
        }
        return -1;
    }

    public int findNextGreaterInNums2(int startIndex, int[] nums2){
        for (int i = startIndex; i < nums2.length; i++) {
            if(nums2[startIndex] < nums2[i]) {
                return nums2[i];
            }
        }
        return -1;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            int index = findIndex(nums1[i], nums2);
            int nextGreaterInNums2 = findNextGreaterInNums2(index, nums2);
            ans[i] = nextGreaterInNums2;
        }

        return ans;
    }

}
