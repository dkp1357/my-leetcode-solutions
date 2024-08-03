class Solution {
    public boolean isPalindrome(int x) {
        int k = x ;
        int total =0;
        int b;

	    if(x < 0) 
            return false;

        while(x>0)
        {
            b =x%10;
            total= total*10 + b;
            x=x/10;

        }
        if(total == k)
        {
            return true;
        }
        else
        {
            return  false;
        }
       // A negative number is not even checked so we can optimise it 
}