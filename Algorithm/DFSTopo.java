package com.fpc.Test;

import java.util.Stack;

public class DFSTopo {
	
	//����DFS��ȡ��������
	public Stack<Character> result;
	
	/*
	 * adjMatrix�Ǵ�����ͼ���ڽӾ���
	 * value�Ǵ�����ͼ���������Ƿ񱻱������ж����ݣ�0����δ��������0�����Ѿ�������
	 * */
	
	public void DFS ( int[][] adjMatrix , int[] value ) {
		result = new Stack<Character>();
		for ( int i = 0 ; i < value.length ; i++ ) {
			if ( value[i] == 0 ) {
				DFSVisit(adjMatrix,value,i);
			}
		}
	}
	
	public void DFSVisit ( int[][] adjMatrix, int[] value, int number ) {
		value[number] = 1;
		for ( int i = 0 ; i < value.length ; i++ ) {
			if ( adjMatrix[number][i] == 1 && value[i] == 0 ) {
				DFSVisit(adjMatrix,value,i);
			}
		}
		char temp = (char) ('A' + number);
		result.add(temp);
	}
	
	public static void main( String[] args ) {
		DFSTopo dfsTopo = new DFSTopo();
		int[][] adjMatrix = {{0,0,1,0,0},{0,0,1,0,0},{0,0,0,1,1},{0,0,0,0,1},{0,0,0,0,0}};
		int[] value = new int[5];
		
		dfsTopo.DFS(adjMatrix,value);
		while ( !dfsTopo.result.isEmpty() ) {
			System.out.print( dfsTopo.result.pop() + "---->");
		}
	}
}
