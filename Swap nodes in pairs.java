Given a linked list, swap every two adjacent nodes and return its head.
You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)


  1->2->3->4->null
p c
 2->1->3->4->null
    p  c 

algortihm : 
create a dummy node before head ... prev
curr points to head for traversal. 
now, see the steps : according to the new list, 
1. above in the example  prev pointer should point to 2 that is curr.next  -- prev.next = curr.next 
2. current pointer should point to 3 curr.next.next -- curr.next = curr.next.next
3. in the above two steps we have connected the list according to list so now is the time to swap the links : 2 should point to 1 i.e prev.next.next = curr. 
4. update the current and previous.  according to the new list current shoudl be 3 that means curr.next since links have been updated.  curr = curr.next
5. prev should point to 1 that is prev = prev.next.next 

code: 
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0) , prev = dummy , curr = head; 
        dummy.next = head; 
        while(curr != null &&  curr.next != null){
            prev.next = curr.next;
            curr.next = curr.next.next ;
            prev.next.next = curr; 
           curr = curr.next ;
            prev = prev.next.next;
        }
        return dummy.next;
    }
}
 
