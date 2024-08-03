//1752

// tc 4n
// sc 
class CheckIfArrayIsSortedAndRotated {
	public static void main(String[] args) {
		int[] arr = {2,1,3,4};
		System.out.println(new Solution().check(arr));
	}
}

/*
this is wrong {6,10,6}

class Solution {
	public boolean check(int[] nums) {
		// sorted arrays are stored in ascending order
		
		int minElement = Integer.MAX_VALUE;
		int index = 0;

		// find minElement and its index
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < minElement) {
				minElement = nums[i];
				index = i;
			}
		}

		//index will give us right rotation by what place
		//to get the original array, left rotate by 'index' places

		//left rotate by index
		nums = reverseArray(nums,0,index-1);
        nums = reverseArray(nums,index,nums.length-1);
        nums = reverseArray(nums,0,nums.length-1);

        //checking if sorted in ascending order
        for (int i = 0; i+1 < nums.length; i++) {
        	if (nums[i] > nums[i+1]) {
        		return false;
        	} else { // arr[i] <= arr[i+1]

        	}
        }

      	return true;
	}

	public int[] reverseArray(int[] arr,int start,int end) {
		while(start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
		return arr;
	}

}

*/

class Solution {
    public boolean check(int[] nums) {

        // Note: An array A rotated by x positions results in an array B of the same length such that 
        // 		 A[i] == B[(i+x) % A.length], where % is the modulo operation.

        // drop = true if previous > next

        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
        	if (nums[i] > nums[i+1]) {
        		count++;
        	}
        }

        if (nums[0] < nums[n-1]) // to check for wrap-arround drop (drop at the array's end)
        	count++;
        
        return count >= 1;
    }
}

/*
In a sorted array that has been rotated, there will be only one point where the element at index i is less than the element at index i - 1. This point is called the rotation point.
If there exist two point than array is not sorted.

Intuition

The given problem is to determine if an array nums can be considered a sorted array that has been rotated. 
A sorted array that is rotated would have at most one "drop" or point where an element is greater than the next element. 
If the array is rotated, the elements will eventually wrap around to the start of the array. 
Therefore, we need to check if there is at most one such "drop" point.


Check Wrap Around: After the loop, check if the first element is less than the last element. 
If it is, increment count since this implies a "drop" from the end of the array to the start.

Concider this case: nums = [2,1,3,4]
this wrap-arround case

This case will give you result true without %size but it is not sorted and rotated. 
So we have to check last and first element also.

*/