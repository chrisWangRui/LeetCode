import java.util.HashMap;

public class Q1_TwoSum {
    public static void main(String[] args) {
        int[] testNums = new int[]{2, 5, 5, 11};
        int testTarget = 10;
        int[] testResult = new int[]{0, 0};

        testResult = twoSum(testNums,testTarget);
        for(int i = 0; i < testResult.length; i++) {
            System.out.print(testResult[i] + " ");
        }
        System.out.println();
        testResult = twoSum1(testNums,testTarget);
        for(int i = 0; i < testResult.length; i++) {
            System.out.print(testResult[i] + " ");
        }
        System.out.println();
        testResult = twoSum2(testNums,testTarget);
        for(int i = 0; i < testResult.length; i++) {
            System.out.print(testResult[i] + " ");
        }
    }

    // 暴力算法
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length; j++) {
                if(i != j) {
                    if((nums[i] + nums[j]) == target) {
                        result[0] = i;
                        result[1] = j;
                        return result;
                    }
                }
            }
        }
        return result;
    }
    // 两遍哈希表
    public static int[] twoSum1(int[] nums, int target) {
        HashMap<Integer, Integer> firstElements = new HashMap<>();
        int expectedValue = 0;
        for(int i = 0; i < nums.length; i++) {
            firstElements.put(nums[i], i );
        }

        for(int j = 0; j < nums.length; j++) {
            expectedValue = target - nums[j];
            if(firstElements.containsKey(expectedValue) && firstElements.get(expectedValue) != j) {
                return new int[]{j, firstElements.get(expectedValue)};
            }
        }
        return new int[]{0, 0};
    }

    // 一遍哈希表
    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> firstElements = new HashMap<>();
        int expectedValue = 0;
        for(int i = 0; i < nums.length; i++) {
            expectedValue = target - nums[i];
            if(firstElements.containsKey(expectedValue)) {
                return new int[]{firstElements.get(expectedValue), i};
            }
            firstElements.put(nums[i], i);
        }
        return new int[]{0, 0};
    }
}
