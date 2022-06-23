# Given the head of a linked list, rotate the list to the right by k places.

 
I/P : 1->2->3->4->5-null;
     k = 2
O/P:  4->5->1->2->3->4->null


Algorithm : 

1. get the length of the linked list = n . 
2. get the modulo of k%n as the length of rotations can be many times. 
3. if k == n return head; 
4. now traverse through a curr node till n-k-1.   n-k-1 is the last node of our new linked list. 
5. now store the n-k node as the newHead and then point the next of n-k-1 node to null. //  get newhead and break the link  
6 traverse till the end of the list and poin the next of the last node to the head.    //  join the newlist



class Solution {
    public int length(ListNode head){
        int len = 0 ; 
        while(head != null){
            head = head.next ;
            len++;
        }
        return len;
    }
    public ListNode rotateRight(ListNode head, int k) {
        int n = length(head) ; 
        if(head == null || head.next == null || k%n == 0)
        return head;
        
        k = k % n ; 
        ListNode curr = head;
        for(int i = 0 ;i<n-k-1;i++){
        curr = curr.next;
        }
        ListNode newHead = curr.next ; 
        ListNode newTail = curr.next ; 
        curr.next = null ; 
        
        while(newTail.next != null){
            newTail = newTail.next;
        }
        newTail.next = head ; 
        return newHead;
    }
}
