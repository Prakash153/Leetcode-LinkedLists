You are given a doubly linked list, which contains nodes that have a next pointer, a previous pointer, 
and an additional child pointer. This child pointer may or may not point to a separate doubly linked list, 
also containing these special nodes. These child lists may have one or more children of their own, and so on,
to produce a multilevel data structure as shown in the example below.

Given the head of the first level of the list, flatten the list so that all the nodes appear in a single-level,
doubly linked list. Let curr be a node with a child list. The nodes in the child list should appear after curr and before curr.next in the flattened list.

Return the head of the flattened list. The nodes in the list must have all of their child pointers set to null.



I/P: 1---2---3---4---5---6--NULL
         |
         7---8---9---10--NULL
             |
             11--12--NULL
             
 O/P: 1->2->7->8->11->12->9->10->3->4->5->6->null;
 
 
 code : 
 class Solution {
    public Node flatten(Node head) {
        Node curr = head ;  // for traversal 
        Node tail = head;   // for keeping the track of previous node 
        Stack<Node> stack = new Stack<>();   // for storing the regerence of next node when child node encounters
        while(curr != null){        
            if(curr.child != null){              // if there is a child 
                Node child = curr.child;           // creating a node for child 
                if(curr.next != null){               // if there is list after we child a child
                    stack.push(curr.next);          // pushing the list to the stack 
                    curr.next.prev = null;          // pointing its previous to null
                }
                curr.next = child;                  // pointing the current's reference to child
                child.prev = curr;                  // pointing child's previous reference to current. 
                curr.child = null;                  // pointing the current's child pointer to null 
            }
            tail = curr ;                           // for keeping track of previous nodes
            curr= curr.next;                        // traversing 
        } 
        while(!stack.isEmpty()){                     // checking if the stack has still nodes in it. 
            curr = stack.pop();                      // getting the last node of the list pushed into the stack 
            tail.next = curr;                        // pointing the previos node to the last node
            curr.prev = tail;                        // pointing previos pointer of the last node to the previos node. 
            while( curr != null){                    // traversing the last node's popped out of stack
                tail = curr;
                curr = curr.next ;
            }
        }
        return head;                                     
    }
}
