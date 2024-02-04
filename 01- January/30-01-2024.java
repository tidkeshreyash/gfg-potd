class Solution 
{ 
    static String a;
    static String b;
    static String c;
    
    // Creating a 3D array to store the results of subproblems
    static int[][][] gp = new int[26][26][26];
    
    int LCSof3(String A, String B, String C, int n1, int n2, int n3) 
    { 
        // code here
         a = A;
        b = B;
        c = C;
        
        // Initializing the 3D array with -1
        for (int[][] m : gp){
            for (int[] r : m){
                Arrays.fill(r, -1);
            }
        }
        
        // Calling the helper function to compute the result
        return helper(n1 - 1, n2 - 1, n3 - 1);
    }
    
    // Helper function to compute the length of the Longest Common Subsequence
    static int helper(int i, int j, int k) {
        // Base case: if any of the strings is empty, return 0
        if (i == -1 || j == -1 || k == -1) {
            return 0;
        }
        
        // If the result for the current subproblem is already computed, returning it
        if (gp[i][j][k] != -1) {
            return gp[i][j][k];
        }
 
        // If the characters at the current positions in all three strings are equal
        if (a.charAt(i) == b.charAt(j) && b.charAt(j) == c.charAt(k)) {
            // Incrementing the result and move to the previous positions in all three strings
            return gp[i][j][k] = 1 + helper(i - 1, j - 1, k - 1);
        } else {
            // If the characters are not equal, finding the maximum length by considering all possibilities
            return gp[i][j][k] = Math.max(Math.max(helper(i - 1, j, k), helper(i, j - 1, k)), helper(i, j, k - 1));
        }
        
    }
