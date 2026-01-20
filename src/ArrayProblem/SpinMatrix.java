package ArrayProblem;

public class SpinMatrix {
    public int[][] generateMatrix(int n) {
        int startX = 0;
        int startY = 0 ;
        int cur = 1;
        int curLength = n-1;
        int[][] matrix =new int[n][n];

        for(int i=0; i<n/2; i++){

            for(int j = startY; j<i+curLength;j++){
                matrix[startX][j] = cur;
                cur++;
                startY++;
            }

            for(int m = startX; m<i+curLength; m++){
                matrix[m][startY] = cur;
                cur++;
                startX++;
            }

            for(int j = startY; j>(n-1-curLength)-i; j--){
                matrix[startX][j] = cur;
                cur++;
                startY--;
            }

            for(int m = startX; m>(n-1-curLength-i); m--){
                matrix[m][startY] = cur;
                cur++;
                startX--;
            }
            startX++;
            startY++;
            curLength = curLength-2;
        }



        if(n%2 == 1){
            matrix[startX][startY] = n*n;
        }

        return matrix;


    }

}
