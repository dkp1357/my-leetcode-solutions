// 75

// sc = o(3) + o(n) , we are distorting the same array
// tc = o(3) + o(n) + o(n)

import java.util.HashMap;

class SortColors {
	public static void main(String[] args) {
		int[] nums = {2,0,2};
		printArray(nums);
		new Solution().sortColors(nums);
		printArray(nums);
	}

	static void printArray(int[] nums) {
		System.out.println();
		for(int x: nums) {
			System.out.print(x+" ");
		}
		System.out.println();
	}
}

class Solution {
	public void sortColors(int[] nums) {
		int[] hashArray = new int[3]; // indices = 0,1,2
		
		for (int i = 0;i < 3; i++)
			hashArray[i] = 0;

		for (int i = 0; i < nums.length; i++)
			hashArray[nums[i]]++;

		int k;
		int i = 0;

		k = hashArray[0];
		while (k > 0) {
			nums[i] = 0;
			k--;
			i++;
		}
		k = hashArray[1];
		while (k > 0) {
			nums[i] = 1;
			k--;
			i++;
		}
		k = hashArray[2];
		while (k > 0) {
			nums[i] = 2;
			k--;
			i++;
		}
	} 
}