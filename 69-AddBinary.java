//67

/*
    1 <= a.length, b.length <= 10^4
    a and b consist only of '0' or '1' characters.
    Each string does not contain leading zeros except for the zero itself.
*/


class Solution {
    public String addBinary(String a, String b) {

        StringBuffer sb = new StringBuffer();
        
        int rem,i,j;
        i = a.length() - 1;
        j = b.length() - 1;

        int carry = 0; // carry is 0 initially

        while(i >= 0 || j >= 0) { // will exit loop when i < 0 && j < 0
            int x,y;

            if (i < 0)
                x = 0;
            else 
                x = (int)a.charAt(i) - '0';

            if (j < 0)
                y = 0;
            else 
                y = (int)b.charAt(j) - '0';

            rem = x+y+carry;
            
            if (rem == 0 || rem == 1) { // carry should be changed to 0 in such cases as its job is done for now
                carry = 0;
            }
            if (rem == 2) { // 2 in binary = 10
                rem = 0;
                carry = 1;
            } else if (rem == 3) { // 3 in binary = 11
                rem = 1;
                carry = 1;
            }

            sb.append(rem);
            i--;
            j--;
        }

        if (carry == 1) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}

/*

 StringBuilder result = new StringBuilder(); // 存储结果的字符串
        int i = a.length() - 1; // a 的末尾索引
        int j = b.length() - 1; // b 的末尾索引
        int carry = 0; // 进位
        int sum = 0;

        // 从末尾开始逐位相加
        while (i >= 0 || j >= 0) {
            sum = carry; // 当前位的和，初始化为进位
            if (i >= 0) sum += a.charAt(i--) - '0'; // a 的当前位
            if (j >= 0) sum += b.charAt(j--) - '0'; // b 的当前位
            result.append(sum % 2); // 当前位的和
            carry = sum / 2; // 更新进位
        }

        if (carry != 0) result.append(carry); // 如果有进位，添加到结果中

        return result.reverse().toString(); // 反转结果字符串并返回
*/