Write a function to delete a node in a singly-linked list. 
  You will not be given access to the head of the list, instead you will be given access to the node to be deleted directly.

It is guaranteed that the node to be deleted is not a tail node in the list.
  
  
  solution : the idea is that copy the value of the next node of the given node to the given node and then connect the given node to the next of the next. 
    code: 

public class Solution {
        public void deleteNode(ListNode node) {
            if(node != null && node.next != null) {
                node.val = node.next.val;
                node.next = node.next.next;
            }
        }
    }
	
