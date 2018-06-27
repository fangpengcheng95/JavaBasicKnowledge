package com.fpc.Test;
public class aaa {
    public int GetNumberOfK(int [] array , int k) {
       int index =  BinarySearch(array,k);
       if ( index == -1 ) {
           return 0;
       } else {
           //��index��λ�ÿ�ʼ��ǰѰ��
           int count = 0;
           int i = index;
           while ( i >= 0 && array[i] == k ) {
               count++;
               i--;
           }
           //��index��λ�ÿ�ʼ����Ѱ��
           i = index + 1;
           while ( i < array.length && array[i] == k ) {
               count++;
               i++;
           }
           return count;
       }
    }
    
    //���ֲ�����Ҫͳ�Ƶ����ֵ�λ��
    public int BinarySearch( int[] array , int k ){
        int left = 0,right = array.length - 1;
        int mid = 0;
        while ( left <= right ) {
        	mid = left + ( right - left ) / 2;
            if ( array[mid] == k ) {
                return mid;
            }else if ( array[mid] > k ) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
    
    //�ж�һ�����ֵĶ�����λ���м���1����
    public int countBit(int x) {
    	int count = 0;
    	while( x != 0 ) {
    		count++;
    		x = (x &(x - 1 ));
    	}
    	return count;
    }
    
    public void print(int x , int number ) {
    	if ( countBit(x) == number ) {
    		for ( int i = 0 ; i < 26 ; i++ ) {
    			if ( (x & 1) == 1 ) {
    				System.out.print((char)(i+'a'));
    			}
    			x = x >> 1;
    		}
    		System.out.println();
    	}
    }
    
    public static void main( String[] args ) {
    	int N = 26;
    	int count = 25;
    	int X = (1 << N ) - 1;
    	aaa a = new aaa();
    	for ( int i = 0 ; i < X ; i++ ) {
    		a.print(i,count);
    	}
    }
}