// 1598

import java.util.Stack;

class CrawlerLogFolder {
	public static void main(String[] args) {
		String logs[] = {"d1/","d2/","../","d21","./"};
		Solution s1 = new Solution();
		System.out.println(s1.minOperations(logs));	
	}
}

class Solution {
	public int minOperations(String[] logs) {
		Stack<String> st = new Stack<>();
		for (int i = 0; i < logs.length; i++) {
			if (logs[i].equals("../")) {
				if(!st.empty())
					st.pop();
			} else if (logs[i].equals("./")) {
				
			} else {
				st.push(logs[i]);
			}
		}
		int n = 0;
		while(st.empty() == false) {
			st.pop();
			n++;
		}
		return n;
	}
}