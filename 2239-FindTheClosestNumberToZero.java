// 2239

class Solution {
    public int findClosestNumber(int[] nums) {
       int min = Integer.MAX_VALUE;
        int ans = Integer.MIN_VALUE; // ans should be maximum number which has minimum distance to 0
        // find minimum distance
        for(int i = 0; i < nums.length; i++)
        {
            int d = (int)Math.abs(nums[i]-0);
            if (min > d) { // change min
                min = d;
            }
        }
        // find answer
        for(int i = 0; i < nums.length; i++)
        {
            int d = (int)Math.abs(nums[i]-0);
            if (d == min) {
                ans = Math.max(nums[i],ans);
            }
        }
        return ans;
    }
}

/*

        int closest = nums[0];
        for (int current_number : nums) {
            if(Math.abs(closest) > Math.abs(current_number)){
                closest = current_number;
            }
            else if(Math.abs(closest) == Math.abs(current_number)){
                closest = Math.max(closest,current_number);
            }
        }
        return closest;

*/

/*

        int min = Integer.MAX_VALUE;
        int ans = Integer.MIN_VALUE; // ans should be maximum number which has minimum distance to 0
        // find minimum distance
        for(int i = 0; i < nums.length; i++)
        {
            int d = (int)Math.abs(nums[i]-0);
            if (min > d) { // change min
                min = d;
                ans = nums[i];
            } else if (min == d) {
                ans = Math.max(ans,nums[i]);
            }
        }
        return ans;
*/