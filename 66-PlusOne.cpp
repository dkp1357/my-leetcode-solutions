// 66
#include <iostream>
#include <bits/stdc++.h>

using namespace std;

class Solution {
	public :
		vector<int> plusOne(vector<int> &digits) {
			vector<int> v;
			int sum,carry = 0;
			int n = digits.size(); // n elements

			sum = digits[n-1] + 1 + carry; // carry = 0 anyway
			v.push_back(sum % 10);
			carry = sum / 10;

			for (int i = n-2; i >= 0; --i)
			{
				sum = digits[i] + carry;
				v.push_back(sum % 10);
				carry = sum / 10;
			}

			if (carry != 0)
				v.push_back(carry);

			reverse(v.begin(),v.end());

			return v;
		}
};

/*

#include <bits/stdc++.h>

class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        vector<int> v;
			int sum,carry = 0;
			int n = digits.size(); // n elements

			sum = digits[n-1] + 1 + carry; // carry = 0 anyway
			v.push_back(sum % 10);
			carry = sum / 10;

			for (int i = n-2; i >= 0; --i)
			{
				sum = digits[i] + carry;
				v.push_back(sum % 10);
				carry = sum / 10;
			}

			if (carry != 0)
				v.push_back(carry);

			reverse(v.begin(),v.end());

            return v;
    }
};

*/

/*


class Solution {
public:
    vector<int> plusOne(vector<int>& v) {
        int n = v.size();
        for(int i = n-1; i >= 0; i--){
            if(i == n-1)
                v[i]++;
            if(v[i] == 10){
                v[i] = 0;
                if(i != 0){
                    v[i-1]++;
                }
                else{
                    v.push_back(0);
                    v[i] = 1;
                }
            }
        }
        return v;
    }
};

/*
