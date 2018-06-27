package com.fpc.Test;

public class MergeSort {
	private static Comparable[] aux;
	
	public static boolean less ( Comparable v , Comparable w ) {
		return v.compareTo(w) < 0; //�ж�v�Ƿ�С��w
	}
	
	public static void show (Comparable[] a) {
		for ( int i = 0 ; i < a.length ; i++ ) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	public static void merge ( Comparable[] a , int lo , int mid , int hi ) {
		//Comparable[] aux = new Comparable[a.length];
		//�����������������[lo,mid]��[mid+1,hi]�ϲ�
		int i = lo;//�������������ͷ��㣬֮�󲻶ϵ��ƶ����������ͷ���
		int j = mid + 1;
		
		for ( int k = lo ; k <= hi ; k++ ) {
			aux[k] = a[k];
		}
		
		for ( int l = lo ; l <= hi ; l++ ) {
			if ( i > mid ) {
				a[l] = aux[j++];
			} else if ( j > hi ) {
				a[l] = aux[i++];
			} else if ( less(aux[i],aux[j]) ) {
				a[l] = aux[i++];
			} else {
				a[l] = aux[j++];
			}
		}
	}
	
	public static void sort ( Comparable[] a , int lo , int hi ) {
		if ( lo >= hi ) {
			return;
		}
		int mid = lo + ( hi - lo ) / 2;
		sort(a,lo,mid);
		sort(a,mid+1,hi);
		merge(a,lo,mid,hi);
	}
	
	public static void sort( Comparable[] a ) {
		aux = new Comparable[a.length];
		sort(a,0,a.length - 1);
	}
	
	
	public static void Msort ( Comparable[] a ) {
		int len = a.length;
		aux = new Comparable[a.length];
		for ( int sz = 1 ; sz < len ; sz *= 2 ) {
			//Ϊʲôlo<len-sz,��Ϊ���ֻҪ�ϲ���ǰһ��sz
			for ( int lo = 0 ; lo < len - sz ; lo += sz * 2 ) {
				merge(a,lo,lo + sz - 1 , Math.min(len - 1 , lo + sz + sz -1));
			}
		}
	}
	public static void main( String[] args ) {
		Comparable[] a = {5,6,1,11,2,24,3,7,43};
//		sort(a);
		Msort(a);
		show(a);
	}
}
