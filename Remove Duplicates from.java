# Given the head of a sorted linked list, delete all nodes that have duplicate numbers,
 # leaving only distinct numbers from the original list. Return the linked list sorted as well.
   
Input:  1->1->1->3->4->4->5->null
Output: 3->5->null
  
  
Solution:  
1. create a dummy node 
Node dummy = new Node(0,h) ; 
Node prev  = dummy ; 

2. traverse the list until you reach null. 
3. during traversing you will encounter two conditions : 
   a) 1->-1->1   : duplicates present.
   b) 3->4       : No duplicates. 
4. when no duplicates are present then move one ahead in both the dummy list and original list. 
5. when duplicates are present traverse the list the list till : curr.val != curr.next.val
   since the current is at the last node of the duplicate node so connect the dummy node's next to current node's next. 
   prev.next = curr.next ; 
   move the current now one ahead. 
     
code: 

class Solution {
public ListNode deleteDuplicates(ListNode head) {
if(head == null) return null;
    ListNode curr = head;
    ListNode dummy = new ListNode(0,head);
    ListNode prev = dummy;
    
    while(curr != null)
    {
        if(curr.next != null && curr.val == curr.next.val)
        {
            while(curr.next != null && curr.val == curr.next.val)
            {
                curr = curr.next;
            }
            
            prev.next = curr.next;
            curr = curr.next;
        }
        else
        {
            prev= prev.next;
            curr = curr.next;
        }
    }
    
    return dummy.next;
    
    
}
}
