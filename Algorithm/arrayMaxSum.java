package com.fpc.Test;

public class arrayMaxSum {
	public int[] maxSubArray( int[] nums ) {
		int[] res = new int[3];
		if ( nums.length != 0 ) {
			int local = nums[0];
			res[0] = nums[0];
			int start = 0,end = 0;
			for ( int i = 1 ; i < nums.length ; i++ ) {
				if ( nums[i] + local > nums[i] ) {
					end = i;
					local += nums[i];
				} else {
					start = i;
					end = i;
					local = nums[i];
				}
				if ( res[0] < local ) {
					res[0] = local;
					res[1] = start;
					res[2] = end;
				}
			}
		}
		return res;
	}
	
	public static void main( String[] args  ) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		arrayMaxSum arr = new arrayMaxSum();
		int[] res = arr.maxSubArray(nums);
		System.out.println("max sum : " + res[0] + " start index : " + res[1] + " end index : " + res[2]);
	}
}
