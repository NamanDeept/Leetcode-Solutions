/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
     ListNode lastres = new ListNode(1);
     ListNode result = lastres;
     int sum =0,carry=0;
     while(l1!=null || l2!=null){
         int x = (l1!=null)?l1.val:0;
         int y = (l2!=null)?l2.val:0;
         sum = x + y + carry;
         carry = sum/10;
         lastres.next = new ListNode(sum%10);
         lastres = lastres.next;
         
         
         l1 = (l1!=null)?l1.next:null;
         l2 = (l2!=null)?l2.next:null;
             
     }
        if(carry>0){
            lastres.next = new ListNode(carry);
        }
        return result.next;
}
}