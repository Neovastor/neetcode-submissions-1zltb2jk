class Solution {
    /**
     * @param {number[][]} matrix
     * @return {void}
     */
    rotate(matrix) {
    let result = [];
    for (let i = 0; i < matrix.length; i++) {
        const row = matrix[i];
        let temp = [];
        for (let j = 0; j < row.length; j++) {
            const col = row[j];
            temp.push(0);
        }
        result.push(temp);
    }

    for (let i = 0; i < matrix.length; i++) {
        const row = matrix[i];
        for (let j = 0; j < row.length; j++) {
            const value = row[j];
            result[j][row.length - i - 1] = value; 
        }
    }

    for (let i = 0; i < matrix.length; i++) {
        const row = matrix[i];
        for (let j = 0; j < row.length; j++) {
            matrix[i][j] = result[i][j]; 
        }
    }
    return matrix;

    }
}
