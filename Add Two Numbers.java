You are given two non-empty linked lists representing two non-negative integers. 
  The digits are stored in reverse order, and each of their nodes contains a single digit. 
  Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
  
  
  solution : 
the idea is to sum up the values of list 1 and 2 simultaneously and store the sum as sum%10 and carry as sum/10. 
create a dummy node . 
  
  class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode (0); // creating a dummy node 
        ListNode curr = dummy; 
        int carry = 0 ; 
        while(l1 != null ||  l2 != null || carry != 0){
            int sum = 0 ; 
            sum =( l1 == null ? 0 : l1.val ) + (l2 == null ? 0 : l2.val) + carry ;  // computing the sum 
            ListNode node = new ListNode(sum % 10);  // adding the sum as new node 
            carry = sum/10 ;    //computing the carry 
            curr.next = node ;    // adding the summed up node to the answer list 
            curr = curr.next ;     // iterating through the answer list 
            
            l1 = l1 == null ? l1 : l1.next ; 
            l2 = l2 == null ? l2 : l2.next ; 
        }
        return dummy.next ;
    }
}
