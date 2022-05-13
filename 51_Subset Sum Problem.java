class Solution{
    static Boolean isSubsetSum(int n, int arr[], int sum){
        // Dp- 0-1 Knapsack , Subset Sum
        boolean dp[][] = new boolean[n+1][sum+1];
        for(int i = 0 ; i< sum+1; i++) dp[0][i] = false;  // making 1st row false, no non-zero no can give zero sum
        for(int i = 0 ; i< n+1; i++) dp[i][0] = true;    // making whole 1st column true, null set will always give zero sum for any numbers.
    
        for(int i = 1; i< n+1; i++){
            for(int j = 1; j< sum+1; j++){
                if(arr[i-1] <= j)
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j] ;
                else
                    dp[i][j] = dp[i-1][j];
            } 
        }
        return dp[n][sum];
    }
}