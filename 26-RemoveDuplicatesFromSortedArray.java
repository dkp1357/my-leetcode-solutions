// 26

class RemoveDuplicatesFromSortedArray {
	public static void main(String[] args) {
        
    }
}
class Solution {
    public int removeDuplicates(int[] nums) {
       // array is sorted in ascending order
        int i = 1, j = 1;
        while (i < nums.length) {
            if (nums[i] != nums[i-1]) {
                nums[j] = nums[i];
                j++;
            }
            i++;
        }
        return j; // considering from 0 i guess        
    }
}