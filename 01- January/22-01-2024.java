class Solution
{
    static ArrayList<ArrayList<Integer>> res;
    
    public static ArrayList<ArrayList<Integer>> printPaths(Node root, int sum)
    {
        // code here
        res = new ArrayList<>();
        helper(root, sum, new ArrayList<>());
        return res;
    }
    
    static void helper(Node root, int sum, ArrayList<Integer> al){
        if(root == null){
            return;
        }
        al.add(root.data);
        if(sum == root.data){
            res.add(new ArrayList<>(al));
        }
        helper(root.left, sum-root.data, al);
        helper(root.right, sum-root.data, al);
        al.remove(al.size()-1);
    
        
        
    }
}
