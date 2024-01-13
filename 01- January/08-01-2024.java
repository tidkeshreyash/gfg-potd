class GfG
{
    Node mergeResult(Node node1, Node node2)
    {
	// Your code here
	ArrayList<Integer> list = new ArrayList<>();
	Node head1 = node1;
	Node head2 = node2;
	
	while(head1 != null){
	    list.add(head1.data);
	    head1 = head1.next;
	}
	while(head2 != null){
	    list.add(head2.data);
	    head2 = head2.next;
	}
	
	Collections.sort(list,Collections.reverseOrder());
	
	if(list == null || list.isEmpty()){
	    return null;
	}
	Node newLL = new Node(list.get(0));
	Node temp = newLL;
	for(int i=1; i<list.size(); i++){
	    Node newNode = new Node(list.get(i));
	    temp.next = newNode;
	    temp = temp.next;
	}
	
	return newLL;
    }
}
