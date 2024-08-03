// 540

class SingleElementInASortedArray {
	public static void main(String[] args) {
		int[] nums = {3,3,7,7,10,11,11};
		System.out.println(new Solution().singleNonDuplicate(nums));
	}
}

class Solution {
	public int singleNonDuplicate(int[] nums) {

		if (nums[nums.length-2] != nums[nums.length-1])
			return nums[nums.length-1];

		if (nums[1] != nums[0])
			return nums[0];

		// nums.length will be odd
		int l = 0, h = nums.length - 1;
		int m = 0;

		while(h >= l) {
			m = (h+l)/2;

			if(nums[m-1] != nums[m] && nums[m+1] != nums[m])
				break;

			if(nums[m] == nums[m-1]) {
				if ((l-(m-2)+1)%2 != 0) { // left side is odd
					h = m-2;
				} else { // right side is odd
					l = m+1;
				}
			} else if(nums[m] == nums[m+1]) {
				if ((l-(m-1)+1)%2 != 0) { // left side is odd
					h = m-1;
				} else { // right side is odd
					l = m+2;
				}
			}

		}

		return nums[m];
	}
}