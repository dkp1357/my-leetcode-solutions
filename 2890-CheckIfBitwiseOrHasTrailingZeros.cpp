// 2890

// all even numbers will have atleast one trailing zeroes in binary
// OR (||) of two or more even numbers will always be even
// 2 || 4 = 6

#include <bits/stdc++.h>

class Solution {
public :
	bool hasTrailingZeroes(vector<int>& nums) {
		int countOfEven = 0;
		for (int i = 0; i < nums.size(); ++i)
		{
			if (nums[i] % 2 == 0)
			{
				countOfEven++;
			}
		}
		return countOfEven >= 2;
	}
};

int main(int argc, char const *argv[])
{
	/* code */
	return 0;
}
