class Solution
{
    public int solve(int ind, int prevSum, int n, String str, int dp[][]) {
        if(ind == n)
            return 1;
            
        if(dp[ind][prevSum] != -1)
            return dp[ind][prevSum];
            
        int count = 0, sum = 0;
        for(int i = ind; i < n; i++) {
            sum += str.charAt(i) - '0';
            if(prevSum <= sum)
                count += solve(i + 1, sum, n, str, dp);
        }
        
        return dp[ind][prevSum] = count;
    } 
    public int TotalCount(String str)
    {
        // Code here
         int n = str.length();
	    int dp[][] = new int[n][1000];
	    
	    for(int i = 0; i < n; i++)
	        for(int j = 0; j < 1000; j++)
	            dp[i][j] = -1;
	    
	    return solve(0, 0, n, str, dp);
    }
}
