class Solution {
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , int n) {
        // code here
        return new ArrayList<>(helper(arr, n, 0));
        
        
    }
    
    static Set<ArrayList<Integer>> helper(ArrayList<Integer> arr, int n, int i) {
        if (i == n - 1) {
            ArrayList<Integer> p = new ArrayList<>();
            p.add(arr.get(i));
            Set<ArrayList<Integer>> base = new TreeSet<>(new ArrayListComparator());
            base.add(p); // [[1]]
            return base;
        }

        Set<ArrayList<Integer>> smallAns = helper(arr, n, i + 1);// [[2,1],[1,2]]

        Set<ArrayList<Integer>> ans = new TreeSet<>(new ArrayListComparator());
        for (ArrayList<Integer> perm : smallAns) {
            ArrayList<Integer> sub = new ArrayList<>();
            for (int j = 0; j <= perm.size(); j++) {
                sub.addAll(perm.subList(0, j));
                sub.add(arr.get(i));
                sub.addAll(perm.subList(j, perm.size()));
                ans.add(new ArrayList<>(sub)); // Make a copy of 'sub' to avoid modifying it later
                sub.clear();
            }
        }
        return ans;
    }

    // Custom comparator for ArrayList<Integer>
    static class ArrayListComparator implements java.util.Comparator<ArrayList<Integer>> {
        @Override
        public int compare(ArrayList<Integer> list1, ArrayList<Integer> list2) {
            // Compare the lists element by element
            for (int i = 0; i < Math.min(list1.size(), list2.size()); i++) {
                int cmp = Integer.compare(list1.get(i), list2.get(i));
                if (cmp != 0) {
                    return cmp;
                }
            }
            // If lists have different sizes, the shorter one is considered smaller
            return Integer.compare(list1.size(), list2.size());
        }
    }
};
