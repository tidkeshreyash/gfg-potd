class GfG {
    // Function to reverse first k elements of a queue.
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        // add code here.
          Stack<Integer> reverse = new Stack<Integer>();
      for(int i=0;i<k;i++){
            reverse.push(q.peek());
            q.poll();
        }
        // find the new size of q
        int len=q.size();
        // push the stack in q
        while(!reverse.isEmpty()){
            q.add(reverse.peek());
            reverse.pop();
        }
        // take the front element and put in backside
        while(len--!=0){
          int  num = q.peek();
            q.poll();
            q.add(num);
        }
        return q;
    }
}
