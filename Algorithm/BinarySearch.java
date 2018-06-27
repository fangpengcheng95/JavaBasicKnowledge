package com.fpc.Test;

public class BinarySearch {
	//�Ƿ��ܰ����л���Ϊÿ������֮�Ͳ�����x��m��������
	boolean is_part ( int[] A , int x , int m ) {
		
	//ÿ�����һ��֣�����������õĻ����߲�����m-1����
	int line = 0 , s = 0;
	for ( int i = 0 ; i < A.length ; i++ ) {
		if ( s + A[i] > x ) {
			//�ʹ���x�������ٰѵ�ǰԪ�ؼ�����
			line++;
			s = A[i];
			if ( line > m - 1 ) {
				//�ָ����Ѿ�����m-1��
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
		while ( l <= r ) { //ע�⵱l==r��ʱ�򣬴�ʱһ�����ڷ���ȷ��λ�ã���l����rʱ�˳�ѭ��
			mid = l + ( r - l ) / 2;
			if ( is_part(A , mid , m) ) {
				r = mid - 1;//��midΪ��ȷλ��ʱ����r��ֵΪmid - 1��ζ�ŵ�midǡ������ȷλ��ʱ��rΪ��ǰһ����
			} else {
				l = mid + 1;//��mid������ȷ��λ��ʱ����һ����������ȷ��λ��һ���ٺ��棬��l��ֵΪmid+1
			}//��l==rightʱ����Ϊrʼ��ָ����ȷλ�õ�ǰһ���ڵ㣬��ʱl==r�Ľڵ�һ������ȷλ�õ�ǰһ���ڵ㣬��ʱl+1�����˳�ѭ��
		}
		return l;//ֻ�ܷ���l����Ϊr�ڵ�Ϊ��ȷ�ڵ��ǰһ���ڵ㣬���ܷ���l
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
