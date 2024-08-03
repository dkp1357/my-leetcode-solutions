// working !

#include <stdio.h>
#include <stdbool.h>

/*
xor ^
same pe 0
diff pe 1

true = 1
false = 0
*/

_Bool isEven(int n)
{
	if (n % 2 == 0)
	{
		return true;
	}
	return false;
}


_Bool isArraySpecial(int *nums, int numsSize) {
	int i = 0;
	int j = 1;
	_Bool flag = true;
	while(j < numsSize)
	{
		if (isEven(nums[i]) ^ isEven(nums[j]) == 0)
		{
			flag = false;
		}
		i++;
		j++;
	}
	return flag;
}


int main(int argc, char const *argv[])
{
	int nums[] = {1,2,3,4,5,6};
	if (isArraySpecial(nums,6))
	{
		printf("true\n");
	} else {
		printf("false\n");
	}
	return 0;
}