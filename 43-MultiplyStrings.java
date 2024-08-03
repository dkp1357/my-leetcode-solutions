// 43

// 1 <= num1.length,num2.length <= 200

class MultiplyStrings {
	public static void main(String[] args) {
		System.out.println(new Solution().multiply("123","456"));
	}
}

class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
			return "0";
		}

		StringBuffer sb = new StringBuffer();
		int l1 = num1.length();
		int l2 = num2.length();

		// max length of product of two numbers (strings) is the sum of their lengths
		int[] result = new int[l1+l2]; //indices = 0,1,2,.......,l1+l2-1

		// initialising array elements to 0
		for (int i = 0; i < result.length; i++) result[i] = 0;

		// for i = l1-1, j = l2-1 , result of their product should be stored in last element of result array
		// that is, result[l1+l2-2+1] = result[i+j+1] = result[l1+l2-1]
		// when i = l1-2,j = l2-1, result[l1+l2-3+1] will be used,
		// that is, second last element of result array
		for (int i = l1 - 1; i >= 0; i--) {
			for (int j = l2 - 1; j >= 0; j--) {
				int p = (int)(num1.charAt(i) - '0') * (int)(num2.charAt(j) - '0');
				result[i+j+1] += p;
			}
		}

		// for adding the carries
		int carry = 0;
		for (int i = result.length - 1; i >= 0; i--) {
			result[i] += carry;
			if (i == 0) { // if leading element of result array, add carry and move on as StringBuffer will handle it
				break;
			}
			carry = result[i] / 10; // ten's place
			result[i] = result[i] % 10; // unit's place 
		}

		// we do not have to consider leading zeroes
		// so we find the index from which no leading zeroes are there
		int start = 0;
		while(start < result.length && result[start] == 0) start++; // will exit when result[start] != 0
 		
		while (start < result.length) {
			sb.append(result[start]);
			start++;
		}

		return sb.toString();
    }
}

/*

public class Solution {
    public String multiply(String num1, String num2) {
        int n1 = num1.length(), n2 = num2.length();
        int[] products = new int[n1 + n2];
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int d1 = num1.charAt(i) - '0';
                int d2 = num2.charAt(j) - '0';
                products[i + j + 1] += d1 * d2;
            }
        }
        int carry = 0;
        for (int i = products.length - 1; i >= 0; i--) {
            int tmp = (products[i] + carry) % 10;
            carry = (products[i] + carry) / 10;
            products[i] = tmp;
        }
        StringBuilder sb = new StringBuilder();
        for (int num : products) sb.append(num);
        while (sb.length() != 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
*/