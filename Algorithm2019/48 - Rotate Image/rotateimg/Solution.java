package rotateimg;

public class Solution {
	 public void rotate(int[][] matrix) {
	        int i = 0;
			int j = matrix.length - 1;
			boolean[][] isChanged = new boolean[j + 1][j + 1];
			while (j > i) {
				int[] temp = matrix[j];
				matrix[j] = matrix[i];
				matrix[i] = temp;
				i++;
				j--;
			}
			for (int k = 0; k < matrix.length-1; k++) {
				for (int l = 0; l < matrix.length; l++) {
					if(!isChanged[k][l]){
					int val = matrix[l][k];
					matrix[l][k]=matrix[k][l];
					matrix[k][l]=val;
					isChanged[k][l]= true;
					isChanged[l][k]=true;
					}			
				}

			}
	    }
}
