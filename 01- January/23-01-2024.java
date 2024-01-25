class Solution
{
    static class Edge{
        public int src;
        public int des;
        public int wt;

        public Edge(int src,int des,int wt){
            this.src=src;
            this.des=des;
            this.wt=wt;

        }

    }
    static boolean findOrderUtil(int cur, ArrayList<Edge>[] graph,boolean[] visited,Stack<Integer> stack,boolean[] stackArr){
       visited[cur]=true;
       stackArr[cur]=true;
        for (int i = 0; i <graph[cur].size() ; i++) {
            int edge=graph[cur].get(i).des;
            if(stackArr[edge]) return true;
            if(!visited[edge]){
                if(findOrderUtil(edge,graph,visited,stack,stackArr)) return true;
            }

        }
        stackArr[cur]=false;
        stack.push(cur);
        return false;
    }
    static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) 
    {
        // add your code here
        boolean[] visited=new boolean[n];
         boolean[] stackArr=new boolean[n];
        ArrayList<Edge>[] graph=new ArrayList[n];
        for (int i = 0; i <n ; i++) {
            graph[i]=new ArrayList<>();
        }
        for (int i = 0; i <m ; i++) {
           int dest= prerequisites.get(i).get(0);
           int src= prerequisites.get(i).get(1);
           if(dest==src) return new int[0];
            graph[src].add(new Edge(src,dest,1));
        }
        Stack<Integer> stack=new Stack<>();

        for (int i = 0; i <n ; i++) {
            if(!visited[i]){
                if(findOrderUtil(i,graph,visited,stack,stackArr)) return new int[0];
            }
        }
        int[] order=new int[n];
        for(boolean v:visited){
            if(!v){
              
              return new int[0];  
            } 
        }
        int i=0;
        while (!stack.isEmpty()){
            order[i++]=stack.pop();
        }
return order;
        
    }
}
