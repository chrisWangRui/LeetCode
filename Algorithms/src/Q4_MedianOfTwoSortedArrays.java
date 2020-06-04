import java.util.HashMap;

public class Q4_MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1;
        int[] nums2;
        nums2 = new int[]{1, 2, 3};
        nums1 = new int[]{4, 5, 6};
        System.out.println(findMedianSortedArrays2(nums1, nums2));

        nums2 = new int[]{1, 2, 3};
        nums1 = new int[]{4, 5, 6, 7, 8};
        System.out.println(findMedianSortedArrays2(nums1, nums2));

        nums2 = new int[]{1, 2, 3, 3, 3};
        nums1 = new int[]{4, 5, 6};
        System.out.println(findMedianSortedArrays2(nums1, nums2));

        nums2 = new int[]{1, 2, 3, 4};
        nums1 = new int[]{4, 5, 6};
        System.out.println(findMedianSortedArrays2(nums1, nums2));

        nums2 = new int[]{1, 2, 3};
        nums1 = new int[]{4, 5, 6, 7};
        System.out.println(findMedianSortedArrays2(nums1, nums2));

        nums2 = new int[]{1, 2, 3};
        nums1 = new int[]{3, 4, 5};
        System.out.println(findMedianSortedArrays2(nums1, nums2));

    }

    // 未完成
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int nums1Length = nums1.length;
        int nums2Length = nums2.length;
        double medianIndex = 0;
        double result = 0.0;

        // nums1[0] -> nums1[nums1.length] -> nums2[0] -> nums2[nums2.length]       Done!
        if (nums1[nums1Length - 1] <= nums2[0]) {
            medianIndex = (nums1Length + nums2Length) / 2.0;
            if ((medianIndex - Math.floor(medianIndex)) == 0){
                if (nums1Length == nums2Length) {
                    result = (nums1[nums1Length - 1] + nums2[0]) / 2.0;
                }
                if (nums1Length < nums2Length) {
                    result = (nums2[(int)medianIndex - nums1Length] + nums2[(int)medianIndex - nums1Length - 1]) / 2.0;
                }
                if (nums1Length > nums2Length) {
                    result = ( nums1[(int)medianIndex] + nums1[(int)medianIndex - 1]) / 2.0;
                }
            } else {
                if ((medianIndex  - nums1Length) > 0) {
                    result = nums2[(int)Math.floor(medianIndex - nums1Length)];
                }
                if ((medianIndex  - nums1Length) < 0) {
                    result = nums1[nums1Length + (int)Math.floor(medianIndex - nums1Length)];
                }
            }

        }

        // nums2[0] -> nums2[nums1.length] -> nums1[0] -> nums1[nums2.length]       Done!
        if (nums2[nums2Length - 1] <= nums1[0]) {
            medianIndex = (nums2Length + nums1Length) / 2.0;
            if ((medianIndex - Math.floor(medianIndex)) == 0){
                if (nums1Length == nums2Length) {
                    result = (nums2[nums2Length - 1] + nums1[0]) / 2.0;
                }
                if (nums2Length < nums1Length) {
                    result = (nums1[(int)medianIndex - nums2Length] + nums1[(int)medianIndex - nums2Length - 1]) / 2.0;
                }
                if (nums2Length > nums1Length) {
                    result = ( nums2[(int)medianIndex] + nums2[(int)medianIndex - 1]) / 2.0;
                }
            } else {
                if ((medianIndex  - nums2Length) > 0) {
                    result = nums1[(int)Math.floor(medianIndex - nums2Length)];
                }
                if ((medianIndex  - nums2Length) < 0) {
                    result = nums2[nums2Length + (int)Math.floor(medianIndex - nums2Length)];
                }
            }

        }

        // nums1[0] -> nums2[0] -> nums1[nums1.length] -> nums1[nums2.length]
        if (nums2[nums2Length] > nums1[nums1Length] && nums2[0] < nums1[nums1Length] && nums2[0] > nums1[0]) {

        }

        if (nums1[0] > nums2[0] && nums1[0] < nums2[nums1Length]) {

        }
        return result;
    }

    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int[] finalArr = new int[nums1.length + nums2.length];
        int p1 = nums1.length - 1;
        int p2 = nums2.length - 1;
        for (int i = finalArr.length - 1; i >= 0; i--) {
            if (p1 >= 0 && p2 >= 0) {
                if (nums1[p1] >= nums2[p2]) {
                    finalArr[i] = nums1[p1];
                    p1--;
                } else {
                    finalArr[i] = nums2[p2];
                    p2--;
                }
            } else {
                if (p1 == -1 && p2 != -1) {
                    finalArr[i] = nums2[p2];
                    p2--;
                }
                if (p2 == -1 && p1 != -1) {
                    finalArr[i] = nums1[p1];
                    p1--;
                }
            }
        }
        if (finalArr.length % 2 != 0) {
            return finalArr[(int)Math.floor(finalArr.length / 2.0)];
        } else {
            return (finalArr[finalArr.length / 2] + finalArr[finalArr.length / 2 - 1]) / 2.0;
        }
    }
}
