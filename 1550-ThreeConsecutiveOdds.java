class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            if(count >= 3)
                return true;
            if(arr[i] % 2 == 0) { // even
                count = 0;
            } else { //odd
                count++;
            }
        }
        if(count >= 3)
            return true;

        return false;
    }
}