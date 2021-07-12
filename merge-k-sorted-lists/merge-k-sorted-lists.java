/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    class Node{
        int index;
        ListNode node;
        Node(int index,ListNode node){
            this.index = index;
            this.node = node;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        PriorityQueue<Node>queue = new PriorityQueue<Node>(new Comparator<Node>(){
            public int compare(Node n1,Node n2){
                return n1.node.val - n2.node.val;
            }
        });
        int counter = 0;
        for(ListNode list : lists){
            if(list!=null){
              queue.add(new Node(counter,list));
            }
            counter++;
        }
        ListNode soln = new ListNode(-1);
        ListNode temp = soln;
        while(queue.size()!=0){
            Node current = queue.remove();
            int idx = current.index;
            int val = current.node.val;
            temp.next = new ListNode(val);
            temp = temp.next;
            if(lists[idx]!=null)
               lists[idx] = lists[idx].next;
            if(lists[idx]!=null)
               queue.add(new Node(idx,lists[idx]));
        }
        return soln.next;
        
    }
}