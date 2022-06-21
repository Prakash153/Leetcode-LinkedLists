You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.


solution: 

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode a = list1, b = list2; 
        ListNode head = null,tail = null;
        if(a==null) return b;
        if(b==null) return a;
        if(a.val <= b.val){
            head = tail = a;
            a = a.next;
        }
        else{
            head = tail = b;
            b = b.next ;
        }
         head.next = tail;
        while(a != null && b != null){
            if(a.val <= b.val){
                tail.next = a;
                tail = a; 
                a= a.next;
            }
            else{
                tail.next = b;
                tail = b;
                b = b.next;
            }
        }
        if(a==null)
            tail.next = b;
        else
            tail.next = a;
        return head;
    }
}
