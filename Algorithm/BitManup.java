package com.fpc.Test;

public class BitManup {
	
	public int BinarySearch( int[] array ) {
		int left = 0,right = array.length -1;
		while ( left <= right ) {
			int mid = left + ( right - left ) / 2;
			if ( array[mid] == mid + 2) {
				right = mid - 1;
			} else if ( array[mid] == mid + 1 ) {
				left = mid + 1;
			}
		}
		return left + 1;
	}
	public static void main( String[] args ) {
		int[] array = {2,3,4,5,6,7,8};
		int m = array.length + 1;
		int res = array[0];
		for ( int i = 1 ; i < array.length ; i++ ) {
			res ^= array[i];
		}
		
		for ( int i = 1 ; i <= array.length + 1 ; i++ ) {
			res ^= i;
		}
		System.out.println(res);
		BitManup b = new BitManup();
		int res1 = b.BinarySearch(array);
		System.out.println(res1);
	}
}
