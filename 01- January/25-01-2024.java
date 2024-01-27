class Solution{
    int solve(int num1,int num2){
        //code here
        int n = 10000;
        int prime[] = new int[n];
        Arrays.fill(prime,1);
        
        for(int i=2;i*i<n;i++)
            for(int j=i*i;j<n;j+=i)
                if(prime[j]==1)
                    prime[j]=0;
        
        int dp[] = new int[10000];
        int vis[] = new int[10000];
        
        Queue<Integer> q = new LinkedList<>();
        q.add(num1);
        while(!q.isEmpty()){
            int node = q.remove();
            if(vis[node]==1)
            continue;
            
            vis[node] = 1;
            String num = Integer.toString(node);
            for(int i=0;i<4;i++){
                for(char c = '0';c<='9';c++){
                    if((i==0 && c=='0') || num.charAt(i)==c)
                    continue;
                    
                    String next = num.substring(0,i)+c+num.substring(i+1);
                    int nxtNode = Integer.parseInt(next);
                    if(prime[nxtNode]==1 && dp[nxtNode]==0){
                        dp[nxtNode] = 1 + dp[node];
                        q.add(nxtNode);
                    }
                }
            }
        }
        return dp[num2];
    }
}
