// 875

class KokoEatingBananas {
    public static void main(String[] args) {
       int[] piles = {3,6,7,11};
       int h = 8;
       System.out.println(new Solution().minEatingSpeed(piles,h)); 
    }
}

// if k = 7, piles[i] = 12, hourstoeat = 1.714... so 2 hours will be taken
// if k = 2, piles[i] = 1, hourstoeat = 0.5, so 1 hour will be taken

class Solution {
    // binary search
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = this.findMax(piles);
        int minSpeed = Integer.MAX_VALUE;
        while (high >= low) {
            int mid = (high + low)/2;
            int totalHoursSpent = this.hoursSpent(piles,mid); 
            if (totalHoursSpent > h) { // speed should increase
                low = mid + 1;
            } else { // this.hoursSpent(piles,mid) <= h , therefore, to find minimum speed, speed should decrease 
                high = mid - 1;
            }
        }
        return low;
    }

    /*
    // linear search
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = this.findMax(piles);
        for (int i = low; i <= high; ++i) {
            int totalHours = this.hoursSpent(piles,i);
            if (totalHours <= h) {
                return i;
            }
        }
        return low;
    }
    */

    int findMax(int[] piles) {
        int maxElement = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++)
            maxElement = Math.max(maxElement,piles[i]);
        return maxElement;
    }

    int hoursSpent(int[] piles,int speed) {
        int hoursSpent = 0;
        double k = speed + 0.0; // important step
        for (int i = 0; i < piles.length; i++) {
            hoursSpent += Math.ceil(piles[i]/k);
        }
        return hoursSpent;
    }
}