// 56
#include <bits/stdc++.h>

using namespace std;

class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        sort(intervals.begin(),intervals.end());
        vector<vector<int>> ans;
        for (size_t i = 0; i < intervals.size(); i++)
        {
            if (ans.empty())
            {
                ans.push_back(intervals[i]);
            }
            else
            {
                vector<int> temp = ans.back();
                if (intervals[i][0] > temp[1])
                {
                    ans.push_back(intervals[i]);
                }
                else if (intervals[i][0] <= temp[1])
                {
                    ans.back()[1] = max(temp[1],intervals[i][1]); // ans.back()[1] will get modified
                } 
            }
        }
        return ans;
    }
};