class Solution
{
    public static ArrayList<Integer> repeatedRows(int matrix[][], int m, int n)
    {
        //code here
        ArrayList<Integer> ans=new ArrayList<>();
        Set<ArrayList<Integer>> set = new HashSet<>();
        
        for(int i=0;i<m;i++){
            ArrayList<Integer> temp=new ArrayList<Integer>();
            for(int j=0;j<n;j++){
                temp.add(matrix[i][j]);
            }
            
            if(set.contains(temp))
            ans.add(i);
            else{
                set.add(temp);
            }
        }
        
        return ans;
    }
}
