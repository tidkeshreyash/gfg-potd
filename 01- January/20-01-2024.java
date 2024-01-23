class Solution
{
    public static int solve(Node root, int[] moves){
            if(root == null){
                return 0;
            }
            
            int left = solve(root.left, moves);
            int right = solve(root.right, moves);
            
            moves[0] += Math.abs(left) + Math.abs(right);
            
            return root.data + left + right - 1;
        }
        
    public static int distributeCandy(Node root)
    {
        //code here
         int[] ans = new int[1];
            
             solve(root, ans);
             
             return ans[0];
    }
}
