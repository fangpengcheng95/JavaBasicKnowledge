package com.fpc.Test;

public class Sort {
	public static void sort(Comparable[] a) {
		
	}
	
	//选择排序
	public static void selectSort( Comparable[] a ) {
		//升序排序
		for ( int i = 0 ; i < a.length ; i++ ) {
			int min = i; //定义初始化的最小数索引，不断在内循环中更新最小数索引
			for ( int j = i ; j < a.length ; j++ ) {
				if ( less(a[j] , a[min]) ) {
					min = j;
				}
			}
			exch(a , min , i); //在外循环，交换最小索引和当前索引
		}
	}
	
	//冒泡排序
	public static void bubbleSort( Comparable[] a ) {
		for ( int i = 0 ; i < a.length - 1 ; i++ ) {
			for ( int j = 0 ; j < a.length - i - 1 ; j++ ) {
				if ( less(a[j+1],a[j]) ) {
					exch(a,j,j+1);
				}
			}
		}
	}
	
	//插入排序
	public static void insertSort( Comparable[] a) {
		for ( int i = 1 ; i < a.length ; i++  ) {
			for ( int j = i ; j > 0 && less(a[j],a[j-1]) ; j-- ) {
				exch(a,j - 1 ,j);
			}
		}
	}
	
	//Shell排序
	public static void shellSort( Comparable[] a ) {
		int len = a.length;
		int h = 1;
		while ( h < len/3) {
			h = 3*h + 1;
		}
		//得到最大的h，再逐渐h/3，直到h=1
		while ( h >= 1 ) {
			for ( int i = h ; i < len ; i++ ) {
				for ( int j = i ; j >= h && less(a[j],a[j -h]) ; j -= h ) {
					exch(a,j,j-h);
				}
			}
			h = h/3;
		}
	}
	
	//改进版冒泡排序
	public static void bulledSortImproved ( Comparable[] a ) {
		int count = 0;
		for ( int i = 0 ; i < a.length - 1 ; i++ ) {
			boolean flag = true;
			count++;
			for ( int j = 0 ; j < a.length - i - 1 ; j++ ) {
				if ( less( a[j+1],a[j] ) ) {
					exch(a,j,j+1);
					flag = false;
				}
			}
			if ( flag ) {
				break;
			}
		}
		System.out.println("count : " + count);
	}
	
	public static boolean less ( Comparable v , Comparable w ) {
		return v.compareTo(w) < 0; //判断v是否小于w
	}
	
	public static void exch ( Comparable[] a , int i ,int j ) {
		Comparable temp = a[i]; //将数组为i和j位置的元素交换
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void show (Comparable[] a) {
		for ( int i = 0 ; i < a.length ; i++ ) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	public static boolean isSorted (Comparable[] a) {
		for ( int i = 0 ; i < a.length ; i++ ) {
			if ( less(a[i],a[i-1] ) ) {
				return false;
			}
		}
		return true;
	}
	
	
	public static void main ( String[] args ) {
		String[] a = {"A","B","C","D","E"};
		bulledSortImproved(a);
		assert isSorted(a);
		show(a);
	}
}
