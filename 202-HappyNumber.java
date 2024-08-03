// 202

class Solution {
    public boolean isHappy(int n) {
        // our number of consideration is n
        if (n <= 1)
            return n == 1;
        Set<Integer> hs = new HashSet<>();
        // exit out of loop when n == 1 
        // or
        // when set contains n ,i.e, it will loop and repeat the cycle
        while(n != 1 && hs.contains(n) == false) {
            hs.add(n);
            int temp = 0;
            while(n != 0) {
                temp += Math.pow(n % 10,2);
                n /= 10;
            }
            n = temp; // now,our new number of consideration is temp
        }
        return n == 1;
    }
}

// tc = o(n^2)
// sc = o(n)