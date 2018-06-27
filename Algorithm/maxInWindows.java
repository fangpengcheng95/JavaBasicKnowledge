package com.fpc.Test;

import java.util.ArrayList;

/*
 * 题目描述：
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： 
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}，
 *  {2,3,4,2,6,[2,5,1]}。
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
