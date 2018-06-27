package com.fpc.Test;

/*
 * ��Ŀ������������һ��m�к�n�еķ���һ�������˴�����0,0�ĸ��ӿ�ʼ�ƶ���ÿһ��ֻ�������ң��ϣ����ĸ������ƶ�һ��
 * ���ǲ��ܽ�������������������λ֮�ʹ���k�ĸ��ӡ� ���磬��kΪ18ʱ���������ܹ����뷽��35,37������Ϊ3+5+3+7 = 18��
 * ���ǣ������ܽ��뷽��35,38������Ϊ3+5+3+8 = 19�����ʸû������ܹ��ﵽ���ٸ����ӣ�
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
