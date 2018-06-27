package com.fpc.Test;

/*
 * 题目描述：地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * */
public class RoboatMove {
	private int step = 0;
	public int movingCount(int threshold, int rows, int cols)
    {
		boolean[] flag = new boolean[rows*cols];
		moving(threshold,rows,cols,0,0,flag);
		return step;
    }
	
	public void moving( int threshold , int rows , int cols , int i , int j , boolean[] flag  ) {
		int index = i * cols + j;
		if ( i < 0 || i >= rows || j < 0 || j >= cols || flag[index] || (bitSum(i) + bitSum(j)) > threshold ) {
			return;
		}
		step++;
		flag[index] = true;
		moving(threshold,rows,cols,i,j - 1,flag);
		moving(threshold,rows,cols,i,j + 1,flag);
		moving(threshold,rows,cols,i - 1,j,flag);
		moving(threshold,rows,cols,i + 1,j,flag);
	}
	
	public int bitSum( int a ) {
		int sum = 0;
		while ( a != 0 ) {
			sum += a % 10;
			a /= 10;
		}
		return sum;
	}
	
	public static void main( String[] args ) {
		RoboatMove r = new RoboatMove();
//		int a = r.bitSum(12344555);
//		System.out.println(a);
		int a = r.movingCount(1, 2, 2);
		System.out.println(a);
    }
}
