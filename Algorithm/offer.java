package com.fpc.Test;


/*
 * ��Ŀ�����������һ�������������ж���һ���������Ƿ����һ������ĳ�ַ��������ַ���·����
 * ·�����ԴӾ����е�����һ�����ӿ�ʼ��ÿһ�������ھ������������ң����ϣ������ƶ�һ�����ӡ����һ��·�������˾����е�ĳһ�����ӣ�
 * ���·�������ٽ���ø��ӡ� ���� a b c e s f c s a d e e �����а���һ���ַ���"bcced"��·�������Ǿ����в�����"abcb"·����
 * ��Ϊ�ַ����ĵ�һ���ַ�bռ���˾����еĵ�һ�еڶ�������֮��·�������ٴν���ø��ӡ�
 * */
public class offer {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
    	for ( int i = 0 ; i < rows ; i++ ) {
    		for ( int j = 0 ; j < cols ; j++ ) {
    			boolean[] flag = new boolean[matrix.length];
    			if ( findPath(matrix,rows,cols,str,i,j,0,flag) ) {
    				return true;
    			}
    		}
    	}
    	return false;
    }
    
    public boolean findPath( char[] matrix, int rows, int cols, char[] str ,int i , int j,int k,boolean[] flag ) {
    	int index = i * cols + j;
    	if ( i < 0 || i >= rows || j < 0 || j >= cols || flag[index] || matrix[index] != str[k] ) {
    		return false;
    	}
    	if ( k == str.length - 1 ) {
    		return true;
    	}
    	flag[index] = true;
    	if (findPath(matrix,rows,cols,str,i,j-1,k+1,flag) || findPath(matrix,rows,cols,str,i,j+1,k+1,flag) 
    			|| findPath(matrix,rows,cols,str,i-1,j,k+1,flag) || findPath(matrix,rows,cols,str,i+1,j,k+1,flag) ) {
    		return true;
    	}
    	return false;
    }
    
    public static void main( String[] args ) {
    	char[] matrix = {'a' ,'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
    	char[] str = {'b','c','c','e','d'};
    	char[] str1 = {'a','b','c','d'};
    	System.out.println(new offer().hasPath( matrix, 3, 4, str1 ));
    }
}
