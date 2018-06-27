package com.fpc.Test;

import java.util.Stack;

/*
Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
*/
public class LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		int max = 0;
		for ( int i = 0 ; i < n ; i++ ) {
			dp[i] = 1;
			for ( int j = 0 ; j < i ; j++ ) {
				if ( nums[j] < nums[i] ) {
					dp[i] = Math.max(dp[j] + 1,dp[i]);
				}
			}
			max = Math.max(max, dp[i]);
		}
		return max;
    }
	
	public static void main( String[] args ) {
		int[] nums = {10,9,2,5,3,7,101,18};
		LongestIncreasingSubsequence l = new LongestIncreasingSubsequence();
		int length = l.lengthOfLIS(nums);
		System.out.println( length );
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Long.MIN_VALUE);
	}
}
