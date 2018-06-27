package com.fpc.Test;

public class BinarySearch {
	//是否能把序列划分为每个序列之和不大于x的m个子序列
	boolean is_part ( int[] A , int x , int m ) {
		
	//每次往右划分，划分完后，所用的划分线不大于m-1即可
	int line = 0 , s = 0;
	for ( int i = 0 ; i < A.length ; i++ ) {
		if ( s + A[i] > x ) {
			//和大于x，不能再把当前元素加上了
			line++;
			s = A[i];
			if ( line > m - 1 ) {
				//分割线已经超过m-1条
				return false;
			} 
		} else {
			s += A[i];
		}
	}
		return true;
	}
	
	int binary_solve (int[] A , int max , int sum ,int m) {
		int l = max , r = sum , mid = 0;
		while ( l <= r ) { //注意当l==r的时候，此时一定处于非正确的位置，当l大于r时退出循环
			mid = l + ( r - l ) / 2;
			if ( is_part(A , mid , m) ) {
				r = mid - 1;//当mid为正确位置时，将r赋值为mid - 1意味着当mid恰好是正确位置时，r为其前一个数
			} else {
				l = mid + 1;//当mid不是正确的位置时，下一个可能是正确的位置一定再后面，则将l赋值为mid+1
			}//当l==right时，因为r始终指向正确位置的前一个节点，此时l==r的节点一定是正确位置的前一个节点，此时l+1才能退出循环
		}
		return l;//只能返回l，因为r节点为正确节点的前一个节点，不能返回l
	}
	
	public static void main( String[] args ) {
		int[] A = {1 , 2 , 3 , 2 , 5 , 4};
		int max = A[0], sum = 0;
		for ( int i = 0 ; i < A.length ; i++ ) {
			sum += A[i];
			if ( max < A[i]) {
				max = A[i];
			}
		}
		BinarySearch demo = new BinarySearch();
		System.out.println(demo.binary_solve(A , max , sum, 3));
	}
}
