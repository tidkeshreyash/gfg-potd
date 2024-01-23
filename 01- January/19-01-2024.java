class Solution {
    public static ArrayList<ArrayList<Integer>> kTop(int[] arr, int N, int K) {
        // code here
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();

        HashMap<Integer,Integer> ha=new HashMap<>();
        ArrayList<Integer> temp=new ArrayList<>();
        for (int i = 0; i < N; i++) {

            if(ha.containsKey(arr[i])) {
                ha.put(arr[i], ha.getOrDefault(arr[i], 0) + 1);

                // sorting done on the basis of frequency in decreassing order.
                Collections.sort(temp,(a,b)->{
                    int val=ha.get(b)-ha.get(a);
                    // sort on the basis of array value in increasing order
                    // both element same it return 0
                    // Smart work****
                    if(val==0){
                        return a-b;
                    }
                    else{
                        return val;
                    }
                });


            }
            else{
                ha.put(arr[i], ha.getOrDefault(arr[i], 0) + 1);

                temp.add(arr[i]);
                // sort on the basis of array value in increasing order
                Collections.sort(temp, (a, b) -> {
                    return a - b;
                });
                // sorting done on the basis of frequency in decreassing order.
                Collections.sort(temp, (a, b) -> {
                    return ha.get(b) - ha.get(a);
                });


            }
            // it will handle only atmost  first 'k' element will be go to our result array list.
            ArrayList<Integer> temp2=new ArrayList<>();
            int size=Math.min(K,temp.size());

            for (int j = 0; j <size ; j++) {
                temp2.add(temp.get(j));
            }
            res.add(new ArrayList<>(temp2));

        }
        return res;
    }
}
