//704

// nums is sorted in ascending order and contains no duplicates. 
// if 'target' exists return its index else return -1

// tc = o(log n)
// sc = o(1)

class BinarySearch {
	public static void main(String[] args) {
		int[] nums = {-1,0,3,5,9,12};
		System.out.println(new Solution().search(nums,12));
	}
}

class Solution {
	public int search(int[] nums,int target) {
		int low,high,mid;

		low = 0;
		high = nums.length-1;

		while(high >= low) {
			mid = (low+high)/2;
			if (nums[mid] == target)
				return mid;	
			else if (target > nums[mid])
				low = mid+1;
			else if (target < nums[mid])
				high = mid-1;
		}

		return -1;
	}
}