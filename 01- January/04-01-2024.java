class Solution {
    static int singleElement(int[] arr , int N) {
        // code here
       Arrays.sort(arr);
        for(int i=0;i<N;i+=3){
            if(i+1>=N ||i+2>=N){
                return arr[i];
            }
            if(arr[i]!=arr[i+1] || arr[i]!=arr[i+2] ){
                return arr[i];
            }
        }
        return -1;
    }
}
