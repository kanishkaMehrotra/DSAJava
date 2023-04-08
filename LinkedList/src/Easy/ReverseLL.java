package Easy;

public class ReverseLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
/**
 * Definition for singly-linked list.
 */
 class ListNode {
    int val;
      ListNode next;
     ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }



/*
class Solution {
    public ListNode reverseList(ListNode head) {
        
        Stack<Integer> stack =new Stack<Integer>();
        
        while(head!=null && head.next!=null)
        {
            stack.push(head.val);
            head=head.next;
        }
        ListNode tmp=head;
        while(!stack.isEmpty())
        {
            ListNode newNode=new ListNode(stack.pop());
            tmp.next=newNode;
            tmp=newNode;
        }
        return head;
    }
}
*/
class Solution {
    public ListNode reverseList(ListNode head) {

       ListNode first=null;
       ListNode second=null;
       ListNode tmp=head;

       while(tmp!=null)
       {
           first=second;
           second=tmp;
           tmp=tmp.next;
           second.next=first;
         
       } 

       return second;
    }
}
