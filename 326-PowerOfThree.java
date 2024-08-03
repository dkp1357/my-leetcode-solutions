// 326

class Solution {
    public boolean isPowerOfThree(int n) {
        if (n == 1)
            return true;
        if (n < 3)
            return false;
        long x = 1;
        long n1 = n;
        // will exit out of this loop if x >= n
        while (x < n1) {
            x *= 3;
        }
        return x == n1;
    }
}

// tc = o(n)
// sc = o(!)