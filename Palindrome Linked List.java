# Given the head of a singly linked list, return true if it is a palindrome.

solution: 1. find the middle element. 
          2. reverse the list that is after the middle elemdent.
          3.  check for both halfs now. 
      
      
      code:
      
     class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast != null){
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head ; 
        while(slow != null){
            if(fast.val != slow.val){
                return false;
            }
            slow = slow.next ; 
            fast = fast.next ;
        }
        return true;
    }
   public ListNode reverse(ListNode head) {
    ListNode prev = null;
    while (head != null) {
        ListNode next = head.next;
        head.next = prev;
        prev = head;
        head = next;
    }
    return prev;
}
}
