Given a Linked List of size N, where every node represents a sub-linked-list and contains two pointers:
(i) a next pointer to the next node,
(ii) a bottom pointer to a linked list where this node is head.
Each of the sub-linked-list is in sorted order.
Flatten the Link List such that all the nodes appear in a single level while maintaining the sorted order. 
Note: The flattened list will be printed using the bottom pointer instead of next pointer.



Input:
5 -> 10 -> 19 -> 28
|     |     |     | 
7     20    22   35
|           |     | 
8          50    40
|                 | 
30               45
Output:  5-> 7-> 8- > 10 -> 19-> 20->
22-> 28-> 30-> 35-> 40-> 45-> 50.
Explanation:
The resultant linked lists has every 
node in a single level.
(Note: | represents the bottom pointer.)

class GfG
{
    Node mergeTwoLists(Node a,Node b){             // merging the bottom lists of two nodes in sorted manner. 
        Node temp = new Node(0);
        Node res = temp;
        
        while( a != null && b != null){
            if(a.data <= b.data){
                temp.bottom = a; 
                temp = temp.bottom;
                a = a.bottom;
            }
            else{
                temp.bottom = b; 
                temp = temp.bottom;
                b = b.bottom;
            }
        }
        if(a == null) temp.bottom = b;
        if(b == null) temp.bottom = a;
        return res.bottom;
    }
    Node flatten(Node root)
    {
	// Your code here
	if(root == null || root.next ==null)
	return root;
	
	root.next = flatten(root.next);    // reaching the last node.
	root = mergeTwoLists(root,root.next);         // merging before returning the last node.
	return root;
    }
}
