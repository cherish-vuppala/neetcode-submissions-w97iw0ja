class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);

        for (int[] row : matrix) {
            reverse(row);
        }
    }

    public void reverse(int[] arr) {
        int s = 0, e = arr.length-1;

        while (s < e) {
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }

    public void transpose(int[][] matrix) {
        int rows, cols;
        rows = cols = matrix.length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = i; j < cols; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
