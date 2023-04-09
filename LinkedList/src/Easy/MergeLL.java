package Easy;

public class MergeLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//use a dummy node for LL questions to avoid inserting in a empty list 
	//maintaim a tail and a start pointer 
	//keep on changing the tail pointer to point to the next node which is smaller in the two lists 
	//if one list is over then the other cn be put as in the merged List
	
	  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
          ListNode mergedList=new ListNode();
          ListNode pointer=mergedList;
          while(list1!=null && list2!=null)
          {
              if(list1.val<list2.val)
              {
                  pointer.next=list1;
                  list1=list1.next;
              }
              else
              {
                  pointer.next=list2;
                  list2=list2.next;
              }
              pointer=pointer.next;
          }
          
          pointer.next=list1!=null ? list1:list2;
          return mergedList.next;
      }
}
