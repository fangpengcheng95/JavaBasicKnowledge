package com.fpc.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class QuickSort2 {
	private static final int HashSet = 0;
	public void sort(int[] array) {
		sort(array,0,array.length -1);
	}
	public void sort( int[] array , int left , int right ) {
		if ( left >= right ) {
			return;
		}
		int k = partition(array,left,right);
		sort(array,left,k - 1);
		sort(array,k + 1,right);
	}
	
	public void exchange( int[] array , int i , int j ) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public int partition( int[] array , int left , int right ) {
		int i = left,j = right + 1;
		while(true) {
			while( array[++i] <= array[left] ) {
				if ( i == right ) {
					break;
				}
			}
			while( array[--j] >= array[left] ) {
				if ( j == left ) {
					break;
				}
			}
			if ( i < j ) {
				exchange(array,i,j);
			}else {
				break;
			}
		}
		exchange(array,left,j);
		return j;
	}
	
	public ArrayList<ArrayList<Integer>> threeSum(int[] nums) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        for ( int i = 0 ; i < nums.length ; i++ ) {
            for ( int j = i + 1 ; j < nums.length ; j++ ) {
                for ( int k = j + 1 ; k < nums.length ; k++ ) {
                    if ( nums[i] + nums[j] + nums[k] == 0 ) {
                        ArrayList l = new ArrayList<Integer>();
                        l.add(i);
                        l.add(j);
                        l.add(k);
                        list.add(l);
                    }
                }
            }
        }
        return list;
    }
	public static void main( String[] args ) {
		int[] array = {1,-1,23,2,-23,-100,43,3,6,23,100,-400};
		QuickSort2  q = new QuickSort2();
		q.sort(array, 0, array.length - 1);
		
		for( int i = 0 ; i < array.length ; i++ ) {
			System.out.print( array[i] + " ");
		}
	}
}
