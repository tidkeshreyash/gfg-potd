class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        // Your code here 
         Arrays.sort(arr,(a,b)->Double.compare(b.value*1.0/b.weight,a.value*1.0/a.weight));//double compare is imp for correct ans
        
        double ans = 0;
        for(int i=0;i<n;i++)
        {
            //System.out.println(arr[i].value + " "+ arr[i].weight + " "+ arr[i].value*1.0/arr[i].weight);
            if(arr[i].weight<=W)
            {
                ans += arr[i].value;
                W -= arr[i].weight;
            }
            else
            {
                ans += (arr[i].value*1.0/arr[i].weight) * W;
                break;
            }
        }
        return ans;
    }
}
