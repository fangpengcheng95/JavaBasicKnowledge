package com.fpc.Test;

public class QuickSort1 {
	
	public void sort( int[] array , int lo , int hi ) {
		if ( hi <= lo ) {
			return;
		}
		int j = partition( array , lo , hi );
		sort( array , lo , j - 1 );
		sort( array , j + 1 , hi );
	}
	
	public void exchange( int[] array , int i , int  j ) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public int partition( int[] array , int lo , int hi ) {
		int i = lo , j = hi + 1;
		while(true) {
			while( array[++i] <= array[lo] ) {
				if( i == hi ) {
					break;
				}
			}
			
			while( array[--j] >= array[lo] ) {
				if ( j == lo ) {
					break;
				}
			}
			
			if ( i >= j ) {
				break;
			}
			exchange(array,i,j);
		}
		exchange(array,lo,j);
		return j;
	}
	
	public static void main( String[] args ) {
		int[] array = {1,-1,23,2,-23,-100,43,3,6,23,100,-400};
		QuickSort1  q = new QuickSort1();
		q.sort(array, 0, array.length - 1);
		
		for( int i = 0 ; i < array.length ; i++ ) {
			System.out.print( array[i] + " ");
		}
		String s = "abcdddd";
		char[] ch = s.toCharArray();
	}
}
