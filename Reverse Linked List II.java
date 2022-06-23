Given the head of a singly linked list and two integers left and right where left <= right, 
reverse the nodes of the list from position left to position right, and return the reversed list.


example : 1->2->3->4->5->null 
             ~~~~~~~
left = 2 , right = 4 
          1->4->3->2->5->null
             ~~~~~~~
             
             
Solution: Approach is to traverse the list through a previous pointer pointing to left -1 ; 
          starting of the sub reverse list will be prev.next. that is the tail 
          
          we will reverse it right - left times. 
          each time we reverse we follow 4 rules : 
          store prev's next.
          connect prev next to tails next 
          connect tails next to tail's next to the next
          connect prev's next to next to temp;
          
          
    1->  2->    3->4->5->
    pre  tail
    1->3->  2->  4->5->
    pre     tail
    1->     4->3->   2->  5->
    pre               tail 
    
