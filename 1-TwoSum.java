class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] array = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i==j)
                    continue;
                if ((nums[i]+nums[j])==target) {
                    array[0] = j;
                    array[1] = i;
                    return array;
                }
            }
        }
        return null;
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
       for (int i = 1; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[j] + nums[j - i] == target) {
                    return new int[]{j, j - i};
                }
            }
        }
        return null;
    }
}