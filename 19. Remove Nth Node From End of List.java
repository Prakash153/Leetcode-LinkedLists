Given the head of a linked list, remove the nth node from the end of the list and return its head.
  
  
  
  Solution : the idea is to use two pointers slow and fast. 
    now create a gap of n size between and move both the pointer linearly until the fast.next becmoes null...hence slow will reach at required destination 
    
    code: 
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head;
        for (int i = 0; i < n; i++) fast = fast.next;
        if (fast == null) return head.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
