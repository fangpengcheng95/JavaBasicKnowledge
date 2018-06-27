package com.fpc.Test;

public class QuickSort extends Sort {
	public static void sort (Comparable[] a) {
		sort(a,0,a.length - 1);
	}
	
	public static void sort(Comparable[] a , int lo ,int hi ) {
		if ( hi <= lo ) {
			return;
		}
		int j = partition(a,lo,hi);
		sort(a,lo,j-1);
		sort(a,j+1,hi);
	}
	
	public static int partition(Comparable[] a, int lo ,int hi) {
		int i = lo , j = hi + 1;
		Comparable v = a[lo];
		while (true) {
			while( less(a[++i],v) ) {
				if ( i == hi ) {
					break;
				}
			}
			
			while( less( v , a[--j] ) ) {
				if ( j == lo ) {
					break;
				}
			}
			
			if ( j <= i ) {
				break;
			}
			exch(a,i,j);
		}
		exch(a,lo,j);
		return j;
	}
	
	public static void main( String[] args ) {
		String[] a= {"E","A","S","Y","Q"};  
        sort(a);  
        assert isSorted(a);  
        show(a);  
	}

}
