package com.fpc.Test;

import java.util.ArrayList;

/*
 * ��Ŀ������
 * ����һ������ͻ������ڵĴ�С���ҳ����л�����������ֵ�����ֵ�����磬�����������{2,3,4,2,6,2,5,1}���������ڵĴ�С3��
 * ��ôһ������6���������ڣ����ǵ����ֵ�ֱ�Ϊ{4,4,6,6,6,5}�� �������{2,3,4,2,6,2,5,1}�Ļ�������������6���� 
 * {[2,3,4],2,6,2,5,1}�� {2,[3,4,2],6,2,5,1}�� {2,3,[4,2,6],2,5,1}�� {2,3,4,[2,6,2],5,1}�� {2,3,4,2,[6,2,5],1}��
 *  {2,3,4,2,6,[2,5,1]}��
 * */
public class maxInWindows {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {	
    	ArrayList list = new ArrayList<Integer>();
    	int i = 0 , j = size - 1;
    	while ( j < num.length && j >= 0 ) {
    		list.add(maxValuePatition(num,i,j));
    		i++;
    		j++;
    	}
        return list;
    }
    
    public int maxValuePatition( int[] num, int i, int j ) {
    	int max = num[i];
    	for ( int k = i + 1 ; k <= j ; k++ ) {
    		if ( max < num[k] ) {
    			max = num[k];
    		}
    	}
    	return max;
    }
    
    public static void main( String[] args ) {
    	int [] num = {10,14,12,11};
    	ArrayList list = new maxInWindows().maxInWindows(num, 0);
    	System.out.println(list);
    }
}
