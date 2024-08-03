//167

//we could use hashmap but SC will be o(n)
//two pointers SC o(1)

// not using same element twice, array is sorted in ascending order

class TwoSum2 {
	public static void main(String[] args) {
		int[] nums = {-1,0};
		int[] ans = new Solution().twoSum(nums,-1);
		for(int x: ans) {
			System.out.println(x);
		}
	}
}

class Solution {
	public int[] twoSum(int[] numbers, int target) {
		int[] ans = new int[2];
		// i = low pointer, j = high pointer
		int i = 0, j = numbers.length-1;
		while(j > i) {
			if (numbers[i]+numbers[j] == target) {
				ans[0] = i+1;
				ans[1] = j+1;
				break;
			}
			if (numbers[i]+numbers[j] > target)
				j--;
			if (numbers[i]+numbers[j] < target)
				i++;
		}
		return ans;
	}
}