class Solution {
    public void setZeroes(int[][] matrix) {
        var firstRowHasZero = false;
        var firstColHasZero = false;

        int m = matrix.length;
        int n = matrix[0].length;

        // check first row
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        // check first col
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }

        // mark zeroes other than first row and first col
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // zero out cells based on marking skip first row and first col for now
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // zero out first row if presnt
        if (firstRowHasZero) {
            for (int j = 0; j < n; j++) 
                matrix[0][j] = 0;
        }

        // zero out first col if presnt
        if (firstColHasZero) {
            for (int i = 0; i < m; i++) 
                matrix[i][0] = 0;
        }
    }
}
