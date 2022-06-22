Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If 
the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
You may not alter the values in the list's nodes, only nodes themselves may be changed.
  
  
  
  Logic : 

1. Add frist megthod : 
this is a method to reverse a linked list. In this method we create a temporary head and temporary tail. 
now we iterrate the list using current node. 
    step I : store curr.next in forward variable. 
    step II : break the link between current and current.next by curr.next = null ; 
    step III : pass the current node to addfirst function. 
    stepIV : check if the temporary head is null. if it is then make the th = node and tt = node. 
    step V: If it is not null then the current node will point to the temporary head and then the current node becomes new temporary head. 
      
 1->2->3->4->5->null              null null
 c  f                             th   tt

2->3->4->5->null                   1 
 c  f                              th tt
 
 3->4->5->null                      2->1 
 c  f                               th   tt
 
 4->5->null                         3->2->1
 c  f                               th    tt

5->null                            4-3->2->1
c  f                               th      tt
 
null                               5->4->3->2->1
 c                                  th          tt
 
 
 2. For reversing the linked list in groups of k we use the add first method. 
step I : create a original head and tail oh and ot. 
step II : check if the oh is null. if it is then assign the first reverse grp as oh = th and ot = tt. 
step III : if it oh is not null then assign ot.next = th and the new ot becomes ot = tt. 
step IV: make the th and tt again null . 
  
  
  code : 

class Solution {
    public ListNode th = null ; 
    public ListNode tt = null ; 
    public void addFirstNode(ListNode node){
        if(th == null){
            th = node ; 
            tt = node ;
        }
        else{
            node.next = th ; 
            th = node;
        }
    }
    public int Length(ListNode head){
        ListNode curr = head; 
        int len = 0 ; 
        while( curr != null){
            curr = curr.next; 
            len++;
        }
        return len;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 0){
            return head;
        }
        int length = Length(head);    
        ListNode curr = head;
        ListNode oh = null ; 
        ListNode ot = null ; 
        while(length >= k){
            int tempk = k ; 
            while(tempk-- > 0){
                ListNode forw = curr.next ;
                curr.next = null ; 
                addFirstNode(curr);
                curr = forw;
            }
            if(oh == null){
                oh = th ; 
                ot = tt;
            }
            else{
                ot.next = th;
                ot = tt;
            }
            th = null; 
            tt = null;
            length -= k;
        }
        ot.next = curr;
        return oh;
    }
}
             
             
