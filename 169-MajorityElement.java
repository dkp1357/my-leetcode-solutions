// we can do array hashing only if we know the quantity required
//getKey(),getValue(),setValue(Value v)

import java.util.*;

class Solution {
    public int majorityElement(int[] nums) {
        int major = 0;
		int majorElement = 0;
		// Map <key,value>
		HashMap<Integer,Integer> hash = new HashMap<>();

		// putting keys and values
		for (var x: nums) {
			if (hash.containsKey(x) == false) { // or hash.get(x) == null
				hash.put(x,1); //puts key and value // it has occured one time
			} else { // hash.containsKey(x) == true // or hash.get(x) != null
				int k = hash.get(x); // returns value if it exists , else returns null
				k++;
				hash.put(x,k);
			}
		}

		//System.out.println("\n");
		//find major
		for (var i : hash.keySet()) { // Returns a Set view of the keys contained in this map.
			int k = hash.get(i);
			major = Math.max(major,k);
		}

		// find majorElement
		for (var i : hash.keySet()) { // Returns a Set view of the keys contained in this map.
			int k = hash.get(i);
			if (k == major) {
				majorElement = i;
				return majorElement;
			}
		}

		/*
		System.out.println("\n");
		for (var i : hash.entrySet()) { // Returns a Set view of the keys contained in this map.
			System.out.println(i);
		}
		*/
		

		return majorElement;
    }
}

/*
// we can do array hashing only if we know the quantity required

import java.util.*;

//169
class 169-MajorityElement {
	public static void main(String[] args) {
		Solution sl = new Solution();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter size of arr : ");
		int n = sc.nextInt();
		int[] arr = new int[n];
		System.out.println("Enter array : ");
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println("\n"+sl.majorityElement(arr)+"\n");
	}
}

class Solution {
	public int majorityElement(int[] nums) {
		int major = 0;
		int majorElement = 0;
		// Map <key,value>
		HashMap<Integer,Integer> hash = new HashMap<>();

		for (var x: nums) {
			if (hash.containsKey(x) == false) { // or hash.get(x) == null
				hash.put(x,1); //puts key and value // it has occured one time
			} else { // hash.containsKey(x) == true // or hash.get(x) == null
				int k = hash.get(x); // returns value if it exists , else returns null
				k++;
				hash.put(x,k);
			}
		}

		//System.out.println("\n");
		for (var i : hash.keySet()) { // Returns a Set view of the keys contained in this map.
			int k = hash.get(i);
			major = Math.max(major,k);
		}

		for (var i : hash.keySet()) { // Returns a Set view of the keys contained in this map.
			int k = hash.get(i);
			if (k == major) {
				majorElement == i;
				return majorElement;
			}
		}

		
		System.out.println("\n");
		for (var i : hash.entrySet()) { // Returns a Set view of the keys contained in this map.
			System.out.println(i);
		}
		
		

		return majorityElement;
	}
}


/*
Enter size of arr : 3
Enter array :
3
2
3


key : 2 value : 0
key : 3 value : 1

// key,value
2=0
3=1

1



*/

/*
Moore voting algorithm

Intuition:

The intuition behind the Moore's Voting Algorithm is based on the fact that if there is a majority element in an array, it will always remain in the lead, even after encountering other elements.
Explanation:

Algorithm:

    Initialize two variables: count and candidate. Set count to 0 and candidate to an arbitrary value.
    Iterate through the array nums:
    a. If count is 0, assign the current element as the new candidate and increment count by 1.
    b. If the current element is the same as the candidate, increment count by 1.
    c. If the current element is different from the candidate, decrement count by 1.
    After the iteration, the candidate variable will hold the majority element.

Explanation:

    The algorithm starts by assuming the first element as the majority candidate and sets the count to 1.
    As it iterates through the array, it compares each element with the candidate:
    a. If the current element matches the candidate, it suggests that it reinforces the majority element because it appears again. Therefore, the count is incremented by 1.
    b. If the current element is different from the candidate, it suggests that there might be an equal number of occurrences of the majority element and other elements. Therefore, the count is decremented by 1.
        Note that decrementing the count doesn't change the fact that the majority element occurs more than n/2 times.
    If the count becomes 0, it means that the current candidate is no longer a potential majority element. In this case, a new candidate is chosen from the remaining elements.
    The algorithm continues this process until it has traversed the entire array.
    The final value of the candidate variable will hold the majority element.

Explanation of Correctness:
The algorithm works on the basis of the assumption that the majority element occurs more than n/2 times in the array. This assumption guarantees that even if the count is reset to 0 by other elements, the majority element will eventually regain the lead.

Let's consider two cases:

    If the majority element has more than n/2 occurrences:
        The algorithm will ensure that the count remains positive for the majority element throughout the traversal, guaranteeing that it will be selected as the final candidate.

    If the majority element has exactly n/2 occurrences:
        In this case, there will be an equal number of occurrences for the majority element and the remaining elements combined.
        However, the majority element will still be selected as the final candidate because it will always have a lead over any other element.

In both cases, the algorithm will correctly identify the majority element.

The time complexity of the Moore's Voting Algorithm is O(n) since it traverses the array once.

This approach is efficient compared to sorting as it requires only a single pass through the array and does not change the original order of the elements.

class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        
        return candidate;
    }
}

*/