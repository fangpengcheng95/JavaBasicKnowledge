package com.fpc.Test;

public class UniquePaths {
	private int countPath = 0;
	 public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		 path(obstacleGrid,0,0);
	     return countPath;   
	 }
	 
	 public void path( int[][] obstacleGrid , int row , int col ) {
		 int n = obstacleGrid.length - 1;
		 int m= obstacleGrid[0].length - 1;
		 if ( row == n && col == m && obstacleGrid[row][col] != 1 ) {
			 countPath++;
		 }
		 //down
		 if ( row + 1 <= n && obstacleGrid[row+1][col] != 1 ) {
			 path(obstacleGrid , row + 1, col );
		 }
		 //right
		 if ( col + 1 <= m && obstacleGrid[row][col+1] != 1 ) {
			 path(obstacleGrid , row, col + 1 );
		 }
	 }
	 
	 public static void main( String[] args ) { 
		 int[][]  obstacleGrid = {{1}};
		 UniquePaths up = new UniquePaths();
		 int res = up.uniquePathsWithObstacles(obstacleGrid);
		 System.out.print(res);
	 }
}
