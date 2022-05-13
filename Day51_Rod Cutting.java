class Solution{
    public int cutRod(int price[], int n) {
        //Same as unbounded KnapSack just - unlimited amount of an cut part can be taken (multiple ocuurences allowed)
        /*
        val[] = price[]
        wt[] = length[] = {1,2,3,  , N-1, N};
        W = capacity = N = length of rod
        */
        int[][] dp = new int[n+1][n+1]; // rows for length of price arr (allowed  piece's prices) , colums for sum prices of rods pieces
        for(int i=0; i<n+1 ; i++) dp[0][i] = 0; 
        for(int i= 0; i<n+1 ; i++) dp[i][0] = 0;
        
        int [] length = new int[n];
        for(int i=0 ; i< n ; i++) length[i] = i+1;   //length[] = {1,2,3  ,n};
        
        for(int i=1 ; i< n+1 ; i++){
            for(int j=1 ; j< n+1 ; j++){
                if(length[i-1] <= j )
                    dp[i][j] = Math.max( dp[i-1][j] , //Excliding this size 
                                price[i-1] + dp[i][j- length[i-1]] ); // including this size/length 
                else dp[i][j] = dp[i-1][j];
            }
        }
        
        return dp[n][n];
    }
}
0