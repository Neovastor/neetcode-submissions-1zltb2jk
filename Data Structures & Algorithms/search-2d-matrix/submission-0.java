class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;
        int colLength = matrix[0].length - 1;
        while (left <= right){
            int middle = (left + right) / 2;
            if (target >= matrix[middle][0]  && target <= matrix[middle][colLength]){
                return searchArray(matrix[middle], target);
            } else if (target < matrix[middle][0]){
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return false;
    }

    private boolean searchArray(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right){
            int middle = (left + right) / 2;

            if (arr[middle] == target){
                return true;
            } else if (arr[middle] > target){
                right = middle -1;
            } else {
                left = middle + 1;
            }
        }

        return false;
    }
}
