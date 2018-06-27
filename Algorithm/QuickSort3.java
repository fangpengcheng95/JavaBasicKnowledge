package com.fpc.Test;

public class QuickSort3 {
	public void sort(int[] nums) {
		sort(nums,0,nums.length-1);
	}
	
	public void sort( int[] nums , int lo , int hi ) {
		if ( lo >= hi ) {
			return;
		}
		int j = partition(nums,lo,hi);
		sort(nums,lo,j-1);
		sort(nums,j+1,hi);
	}
	
	public void exchange( int[] nums , int i , int j ) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	public int partition( int[] nums , int lo , int hi ) {
		int i = lo , j = hi + 1;
		while( true ) {
			while( nums[++i] <= nums[lo] ) {
				if ( i == hi ) {
					break;
				}
			}
			
			while( nums[--j] >= nums[lo] ) {
				if ( j == lo ) {
					break;
				}
			}
			
			if ( i >= j ) {
				break;
			}
			exchange(nums,i,j);
		}
		exchange(nums,lo,j);
		return j;
	}
	public  static void main( String[] args ) {
		int[] array = {1,-1,23,2,-23,-100,43,3,6,23,100,-400};
		QuickSort3  q = new QuickSort3();
		q.sort(array);
		for( int i = 0 ; i < array.length ; i++ ) {
			System.out.print( array[i] + " ");
		}
	}
}
