// 217

// return true if any value appears atleast twice in array 
// else return false if all unique

import java.util.Set;
import java.util.HashSet;

class ContainsDuplicate {
	public static void main(String[] args) {
		int[] nums = {0,8,4325,3247,0};
		System.out.println(new Solution().containsDuplicate(nums));
	}
}

class Solution {
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> hs = new HashSet<>();
		for (int i = 0; i < nums.length; ++i) {
			if(hs.contains(nums[i]) == true) //Returns true if this set contains the specified element.
				return true;
			
			hs.add(nums[i]); //Adds the specified element to this set if it is not already present 
		}
		return false;
	}
}

/*

class Solution {
    public boolean containsDuplicate(int[] nums) {
                HashSet<Integer> set = new HashSet<>();
                    for (int num : nums) {
                                if (!set.add(num)) {
                                                return true;
                                }
                    }
                        return false;
         
        
    }
}

*/