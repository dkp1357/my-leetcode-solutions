// 258

#include <stdio.h>
#include <math.h>

int addDigits(int num) {
    if(num < 10)
        return num;
        
    return (num % 9 == 0) ? 9 : (num % 9) ;
}

int main(int argc, char const *argv[])
{
	
	return 0;
}

/*

int addDigits(int num) {
    int sum = 0;
    int k;
    while(num!=0)
    {
        sum += num%10;
        num /=10;
    }
    if(sum >= 10) // not single digit
        k =  addDigits(sum);
    else // single digit
        k = sum;

    return k;
}

*/

/*

int addDigits(int num) {
    int sum = 0;
    while(num!=0)
    {
        sum += num%10;
        num /=10;
    }
    if(sum >= 10) // not single digit
        return addDigits(sum);
    else // single digit
        return sum;
}

*/