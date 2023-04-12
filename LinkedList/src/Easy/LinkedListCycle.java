package Easy;

public class LinkedListCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	  /* public boolean hasCycle(ListNode head) {

    //hashmap approach time O(1) space O(n)
    HashSet<ListNode> seen=new HashSet();
    ListNode temp=head;
    while (temp!=null)
    {
        if(seen.contains(temp))
        return true;
        else 
        seen.add(temp);
        temp=temp.next;
    }
    return false;
    
}*/
//Floyd’s Cycle-Finding Algorithm use a fast and a slow pointer if they meet then there is a cycle 
//time O(n) space O(1) 
    public boolean hasCycle(ListNode head) {
        
        ListNode fast=head;
        ListNode slow=head;
    
    while (fast!=null && fast.next !=null)
    {
    fast=fast.next.next;
     slow=slow.next; 
      if(fast==slow)
        return true;
    }
    return false;
    
}
}
