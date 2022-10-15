Given the head of a singly linked list, sort the list using insertion sort, and return the sorted list's head.

The steps of the insertion sort algorithm:

Insertion sort iterates, consuming one input element each repetition and growing a sorted output list.
At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list and inserts it there.
It repeats until no input elements remain.
The following is a graphical example of the insertion sort algorithm. The partially sorted list (black) initially contains
only the first element in the list. One element (red) is removed from the input data and inserted in-place into the sorted list with each iteration.

  
  
  Solution : We know that in insertion sort the first half of the array is sorted and linearly we have to pick a element from the second half(unsorted)
    and place it at it's right position in the first half. 
    For this purpose we you a dummy node that points the head of the sorted part. 
    
    
    code: 

class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(10); 
        ListNode curr = head , prev = dummy , next = null; 
        while(curr != null){
            next = curr.next ; 
            while(prev.next != null && prev.next.val < curr.val)
                prev = prev.next ; 
            
            curr.next = prev.next ; 
            prev.next = curr; 
            curr = next ; 
            prev = dummy ; 
        }
        return dummy.next;
    }
}
