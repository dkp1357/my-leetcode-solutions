import java.util.ArrayList;
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        //int nums3[] = new int[nums1.length+nums2.length];
        List<Integer> l1 = new ArrayList();

        // adding in ascending order
        while(i < nums1.length && j < nums2.length) {
            // chotta wala add kar
            // phir uska pointer badha
            if (nums1[i] > nums2[j]) {
                l1.add(nums2[j]); 
                j++; 
            } else if(nums1[i] == nums2[j]) {
                l1.add(nums2[j]); 
                j++;
                l1.add(nums1[i]); 
                i++;
            } else { // nums1[i] < nums2[j]
                l1.add(nums1[i]); 
                i++; 
            }
        }

        if (i >= nums1.length) {
            for (;j < nums2.length; j++) {
                l1.add(nums2[j]);
            }
        }
        if (j >= nums2.length) {
            for (;i < nums1.length; i++) {
                l1.add(nums1[i]);
            }
        }

        double median;

        if (l1.size() % 2 == 0) {  // example if l1 size is 4, median is average of index 1 and index 2
            median = (l1.get(l1.size()/2 - 1) + l1.get(l1.size()/2))/2.0;
        } else { // example if l1 size is 5, median is at index 2 (5 / 2 = 2.5 which is 2)
            median = (double)l1.get(l1.size()/2);
        }

        return median;
    }
}

/*

Time

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        int left = 0, right=m;
        while(left<=right){
            int partitionX = left + (right-left)/2;
            int partitionY = (m+n+1)/2 - partitionX;

            int maxleftX = (partitionX==0) ? Integer.MIN_VALUE : nums1[partitionX-1];
            int minrightX = (partitionX==m) ? Integer.MAX_VALUE : nums1[partitionX];
            
            int maxleftY = (partitionY==0) ? Integer.MIN_VALUE : nums2[partitionY-1];
            int minrightY = (partitionY==n) ? Integer.MAX_VALUE : nums2[partitionY];

            if(maxleftX <= minrightY && maxleftY <= minrightX){
                if((n+m)%2==0){
                    return (double)(Math.max(maxleftX,maxleftY)+Math.min(minrightX,minrightY))/2.0;
                }
                else{
                    return Math.max(maxleftX,maxleftY);
                }
            }
            else if(maxleftX > minrightY){
                right=partitionX-1;
            }
            else{
                left=partitionX+1;
            }

        }
        return -1;
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

Memory

/*class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len = nums1.length + nums2.length;

        int[] result = new int[len];

        boolean isOdd = false;
        isOdd = (len % 2 == 1)? true: false;

        int medianPos = len / 2;

        if (nums1.length == 0)
        {
            if (isOdd)
            {
                return nums2[medianPos];
            }
            else
            {
                return (double)(nums2[medianPos - 1] + nums2[medianPos]) / 2;
            } 
        }
        if (nums2.length == 0)
        {
            if (isOdd)
            {
                return nums1[medianPos];
            }
            else
            {
                return (double)(nums1[medianPos - 1] + nums1[medianPos]) / 2;
            } 
        }
        


    
        for (int i = 0, j = 0; i + j <= medianPos;)
        {
            if (i == nums1.length)
            {
                result[i+j] = nums2[j];
                j++;
            }
            else if(j == nums2.length)
            {
                result[i+j] = nums1[i];
                i++;
            }
            else if (nums1[i] >= nums2[j])
            {
                result[i+j] = nums2[j];
                j++;
            }
            else if (nums1[i] < nums2[j])
            {
                result[i+j] = nums1[i];
                i++;
            }
        }

        if (isOdd)
        {
            return result[medianPos];
        }
        else
        {
            return (double)(result[medianPos - 1] + result[medianPos]) / 2;
        }
        
    }
}
*/
/*
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       double center = (nums1.length + nums2.length) / 2.0;
        int i = nums1.length == 0 ? -1 : 0;
        int j = nums2.length == 0 ? -1 : 0;
        int checks = center % 1.0 == 0 ? 1 : 0;
        while (checks < (int) center) {
            checks++;
            if (i == -1) {
                j++;
                continue;
            }
            if (j == -1) {
                i++;
                continue;
            }
            if (nums1[i] < nums2[j]) {
                if (i < nums1.length - 1) {
                    i++;
                } else {
                    i = -1;
                }
            } else {
                if (j < nums2.length - 1) {
                    j++;
                } else {
                    j = -1;
                }
            }
        }

        if (center % 1.0 == 0) {
            if (i != -1 && j != -1) {
                if (nums1[i] < nums2[j] && i < nums1.length - 1 && nums1[i + 1] < nums2[j]) {
                    j = -1;
                } else if (nums2[j] < nums1[i] && j < nums2.length - 1 && nums2[j + 1] < nums1[i]) {
                    i = -1;
                }
            }
            if (i == -1) {
                System.gc();
                return (nums2[j] + nums2[j + 1]) / 2.0;
            }
            if (j == -1) {
                System.gc();
                return (nums1[i] + nums1[i + 1]) / 2.0;
            }
            return (nums1[i] + nums2[j]) / 2.0;
        } else {
            if (i == -1) {
                return nums2[j];
            }
            if (j == -1) {
                return nums1[i];
            }

            if (nums1[i] < nums2[j]) {
                return nums1[i];
            } else {
                return nums2[j];
            }
        }
    }
}

*/
